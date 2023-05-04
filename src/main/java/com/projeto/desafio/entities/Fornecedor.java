package com.projeto.desafio.entities;

import java.io.Serializable;

public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cnpjOuCpf;
	private String nome;
	private String email;
	private String cep;
	
	public Fornecedor() {
	}

	public Fornecedor(String cnpjOuCpf, String nome, String email, String cep) {
		super();
		this.cnpjOuCpf = cnpjOuCpf;
		this.nome = nome;
		this.email = email;
		this.cep = cep;
	}

	public String getCnpjOuCpf() {
		return cnpjOuCpf;
	}

	public void setCnpjOuCpf(String cnpjOuCpf) {
		this.cnpjOuCpf = cnpjOuCpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpjOuCpf == null) ? 0 : cnpjOuCpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (cnpjOuCpf == null) {
			if (other.cnpjOuCpf != null)
				return false;
		} else if (!cnpjOuCpf.equals(other.cnpjOuCpf))
			return false;
		return true;
	}

}
