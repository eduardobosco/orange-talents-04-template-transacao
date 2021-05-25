package com.ot4.transacoes.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartao {
	
	@Id
	private String id;
	
	private String email;
	
	@Deprecated
	public Cartao () {}

	public Cartao(String id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
}
