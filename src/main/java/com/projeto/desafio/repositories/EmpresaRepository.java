package com.projeto.desafio.repositories;

import org.springframework.stereotype.Repository;

import com.projeto.desafio.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, String> {

}
