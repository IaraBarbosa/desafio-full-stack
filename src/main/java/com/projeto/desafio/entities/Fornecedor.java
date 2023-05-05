package com.projeto.desafio.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cnpjOuCpf;
	private String nome;
	private String email;
	private String cep;
	
	@ManyToMany
	@JoinTable(name = "EMPRESA_FORNECEDOR",
			   joinColumns = @JoinColumn(name = "cnpj_cpf_fornecedor"),
			   inverseJoinColumns = @JoinColumn(name = "cnpj_empresa")
	)
	@JsonManagedReference
	private List<Empresa> listaEmpresas = new ArrayList<>();
	
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

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void setListaEmpresas(List<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
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
