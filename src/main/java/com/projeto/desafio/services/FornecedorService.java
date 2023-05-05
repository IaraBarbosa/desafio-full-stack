package com.projeto.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.desafio.entities.Fornecedor;
import com.projeto.desafio.repositories.FornecedorRepository;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	
	public List<Fornecedor> findAll(){
		return fornecedorRepository.findAll();
	}
	
	public Fornecedor findById(String cnpjOuCpf){
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(cnpjOuCpf);
		return fornecedor.orElse(null);
	}

	public Fornecedor insertFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}
	
	public Fornecedor updateFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}
	
	public void deleteById(String cnpjOuCpf) {
		fornecedorRepository.deleteById(cnpjOuCpf);
	}
	
}
