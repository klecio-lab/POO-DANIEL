package com.poo.poo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poo.poo.model.Endereco;
import com.poo.poo.repository.RepositorioEndereco;

@RestController
@RequestMapping("/endereco")
public class EnderecoRestApi  {
  @Autowired
  private RepositorioEndereco repositorio;

  @GetMapping
  public List<Endereco>listar(){
    return repositorio.findAll();
  }

  @PostMapping
  public void salvar(@RequestBody Endereco endereco){
    repositorio.save(endereco);
  }

  @PutMapping
  public void alterar(@RequestBody Endereco endereco){
    if (endereco.getId() != null && endereco.getId() > 0) {
      repositorio.save(endereco);
    }
  }

  @DeleteMapping
  public void excluir(@RequestBody Endereco endereco){
    repositorio.delete(endereco);
  }
}
