package com.ot4.transacoes.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.ot4.transacoes.Transacao;
import com.ot4.transacoes.TransacaoRepository;

public class ListenerDaTransacao {
	
	private final Logger logger = LoggerFactory.getLogger(ListenerDaTransacao.class);

    @Autowired
    TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoMensagem transacaoMensagem) {
        logger.info("A transação {} com valor {} e o cartão {} foi lida!", transacaoMensagem.getId(), transacaoMensagem.getValor(), transacaoMensagem.getCartao().getId());
        Transacao transacao = transacaoMensagem.converteParaTransacao();
        transacaoRepository.save(transacao);
    }

}
