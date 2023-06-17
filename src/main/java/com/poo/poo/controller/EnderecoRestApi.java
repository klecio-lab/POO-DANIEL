package com.poo.poo.controller;

import com.poo.poo.dto.EnderecoDTO;
import com.poo.poo.model.Endereco;
import com.poo.poo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoRestApi {

  private final EnderecoService enderecoService;

  @Autowired
  public EnderecoRestApi(EnderecoService enderecoService) {
    this.enderecoService = enderecoService;
  }

  @GetMapping
  public List<EnderecoDTO> listar() {
    return enderecoService.listarEnderecos();
  }

  @PostMapping
  public void salvar(@RequestBody EnderecoDTO enderecoDTO) {
    enderecoService.salvarEndereco(enderecoDTO);
  }

  @PutMapping
  public void alterar(@RequestBody EnderecoDTO enderecoDTO) {
    enderecoService.alterarEndereco(enderecoDTO);
  }

  @DeleteMapping("/{id}")
  public void excluir(@PathVariable("id") Long enderecoId) {
    enderecoService.excluirEndereco(enderecoId);
  }
}
