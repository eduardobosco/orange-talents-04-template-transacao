package com.ot4.transacoes.transacao;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/{cardNumber}")
    @Transactional
    public ResponseEntity<?> getTransactions(@PathVariable(value = "cardNumber") String cardNumber){
        List<Transaction> transactionList = transactionRepository.findFirst10ByCardCardNumber(cardNumber);

        if(transactionList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        List<TransactionResponse> transactionResponseList = transactionList
                .stream()
                .map(TransactionResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(transactionResponseList);
    }

}
