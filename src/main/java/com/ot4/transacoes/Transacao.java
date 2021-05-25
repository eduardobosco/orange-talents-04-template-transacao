package com.ot4.transacoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ot4.transacoes.cartao.Cartao;
import com.ot4.transacoes.estabelecimento.Estabelecimento;

@Entity
public class Transacao {

	@Id
	private String id;

	private BigDecimal valor;

	private LocalDateTime efetivadaEm;

	@ManyToOne(cascade = CascadeType.ALL)
	private Estabelecimento estabelecimento;

	@ManyToOne(cascade = CascadeType.ALL)
	private Cartao cartao;

	@Deprecated
	public Transacao() {
	}

	public Transacao(String id, BigDecimal valor, LocalDateTime efetivadaEm, Estabelecimento estabelecimento,
			Cartao cartao) {
		this.id = id;
		this.valor = valor;
		this.efetivadaEm = efetivadaEm;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

}
