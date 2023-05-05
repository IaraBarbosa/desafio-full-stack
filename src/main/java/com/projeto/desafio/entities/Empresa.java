package com.projeto.desafio.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cnpj;
	private String nomeFantasia;
	private String cep;
	
	@ManyToMany(mappedBy = "listaEmpresas")
	@JsonBackReference
	private List<Fornecedor> listaFornecedores = new ArrayList<>();
	
	public Empresa() {
	}
	
	public Empresa(String cnpj, String nomeFantasia, String cep) {
		super();
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		this.cep = cep;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public List<Fornecedor> getListaFornecedores() {
		return listaFornecedores;
	}

	public void setListaFornecedores(List<Fornecedor> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}


}
