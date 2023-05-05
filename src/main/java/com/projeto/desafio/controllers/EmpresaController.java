package com.projeto.desafio.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.desafio.entities.Empresa;
import com.projeto.desafio.services.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	
	@GetMapping
	public ResponseEntity<List<Empresa>> findAll(){
		List<Empresa> listaEmpresas = empresaService.findAll();
		return ResponseEntity.ok().body(listaEmpresas);
	}
	
	@GetMapping("/{cnpj}")
	public ResponseEntity<Empresa> findById(@PathVariable String cnpj){
		Empresa empresa = empresaService.findById(cnpj);
		return ResponseEntity.ok().body(empresa);
	}
	
	@PostMapping
	public ResponseEntity<Void> insertEmpresa(@RequestBody Empresa empresa){
		Empresa objEmpresa = empresaService.insertEmpresa(empresa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(objEmpresa.getCnpj()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{cnpj}")
	public ResponseEntity<Void> updateEmpresa(@RequestBody Empresa empresa, @PathVariable String cnpj){
		Empresa objEmpresa = empresaService.updateEmpresa(empresa);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{cnpj}")
	public ResponseEntity<Empresa> deleteById(@PathVariable String cnpj){
		empresaService.deleteById(cnpj);
		return ResponseEntity.noContent().build();
	}
}
