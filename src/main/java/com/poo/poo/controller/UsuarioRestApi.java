package com.poo.poo.controller;



import com.poo.poo.dto.UsuarioDto;
import com.poo.poo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestApi {

  private final UsuarioService usuarioService;

  @Autowired
  public UsuarioRestApi(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @GetMapping
  public List<UsuarioDto> listar() {
    return usuarioService.listarUsuarios();
  }

  @PostMapping
  public void salvar(@RequestBody UsuarioDto usuarioDto) {
    usuarioService.salvarUsuario(usuarioDto);
  }

  @PutMapping
  public void alterar(@RequestBody UsuarioDto usuarioDto) {
    usuarioService.alterarUsuario(usuarioDto);
  }

  @DeleteMapping("/{id}")
  public void excluir(@PathVariable("id") Long usuarioId) {
    usuarioService.excluirUsuario(usuarioId);
  }
}
