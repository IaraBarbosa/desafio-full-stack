package com.projeto.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.desafio.entities.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {

}
