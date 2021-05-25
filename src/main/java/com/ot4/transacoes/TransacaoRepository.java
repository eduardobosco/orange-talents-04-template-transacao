package com.ot4.transacoes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

	List<Transacao> findByCartaoId(String idCartao);

}
