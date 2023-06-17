package com.poo.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.poo.model.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {
  
}
