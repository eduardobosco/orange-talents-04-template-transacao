package com.ot4.transacoes.transacao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    List<Transaction> findFirst10ByCardCardNumber(String cardNumber);
}
