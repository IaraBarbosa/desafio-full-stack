package com.projeto.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.desafio.entities.Empresa;
import com.projeto.desafio.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	public List<Empresa> findAll(){
		return empresaRepository.findAll();
	}
	
	public Empresa findById(String cnpj){
		Optional<Empresa> empresa = empresaRepository.findById(cnpj);
		return empresa.orElse(null);
	}

	public Empresa insertEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
	public Empresa updateEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
	public void deleteById(String cnpj) {
		empresaRepository.deleteById(cnpj);
	}
}
