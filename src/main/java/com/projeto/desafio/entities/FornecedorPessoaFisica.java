package com.projeto.desafio.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class FornecedorPessoaFisica extends Fornecedor{
	private static final long serialVersionUID = 1L;
	
	private String rg;
	private Date dataNascimento;
	
	
	public FornecedorPessoaFisica() {
		super();
	}
	
	public FornecedorPessoaFisica(String cnpjOuCpf, String nome, String email, String cep, String rg, Date dataNascimento) {
		super(cnpjOuCpf, nome, email, cep);
		this.rg = rg;
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	

}
