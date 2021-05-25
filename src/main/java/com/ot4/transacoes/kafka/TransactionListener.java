package com.ot4.transacoes.kafka;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ot4.transacoes.transacao.Transaction;
import com.ot4.transacoes.transacao.TransactionMessage;
import com.ot4.transacoes.transacao.TransactionRepository;

@Component
public class TransactionListener {
	
	private final Logger logger = LoggerFactory.getLogger(TransactionListener.class);

	@Autowired
    private TransactionRepository transactionRepository;

    @Transactional
   @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransactionMessage message){
    	logger.info("Recebendo transação");
        System.out.println(message.toString());
        Transaction transaction = message.toModel();
        transactionRepository.save(transaction);
        logger.info("Transação cadastrada");
    }
}
