package com.poo.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.poo.model.Endereco;

public interface RepositorioEndereco extends JpaRepository<Endereco,Long> {
  
}
