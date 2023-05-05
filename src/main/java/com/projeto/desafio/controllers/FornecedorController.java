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

import com.projeto.desafio.entities.Fornecedor;
import com.projeto.desafio.services.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping
	public ResponseEntity<List<Fornecedor>> findAll(){
		List<Fornecedor> listaFornecedores = fornecedorService.findAll();
		return ResponseEntity.ok().body(listaFornecedores);
	}
	
	@GetMapping("/{cnpjOuCpf}")
	public ResponseEntity<Fornecedor> findById(@PathVariable String cnpjOuCpf){
		Fornecedor fornecedor = fornecedorService.findById(cnpjOuCpf);
		return ResponseEntity.ok().body(fornecedor);
	}
	
	@PostMapping
	public ResponseEntity<Void> insertFornecedor(@RequestBody Fornecedor fornecedor){
		Fornecedor objFornecedor = fornecedorService.insertFornecedor(fornecedor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{cnpjOuCpf}").buildAndExpand(objFornecedor.getCnpjOuCpf()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{cnpjOuCpf}")
	public ResponseEntity<Void> updateFornecedor(@RequestBody Fornecedor fornecedor, @PathVariable String cnpjOuCpf){
		Fornecedor objFornecedor = fornecedorService.updateFornecedor(fornecedor);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{cnpjOuCpf}")
	public ResponseEntity<Fornecedor> deleteById(@PathVariable String cnpjOuCpf){
		fornecedorService.deleteById(cnpjOuCpf);
		return ResponseEntity.noContent().build();
	}
}
