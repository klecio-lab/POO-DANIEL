package com.poo.poo.service;

import com.poo.poo.dto.UsuarioDto;
import com.poo.poo.model.Usuario;
import com.poo.poo.repository.RepositorioUsuario;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private final RepositorioUsuario repositorioUsuario;

    @Autowired
    public UsuarioService(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public List<UsuarioDto> listarUsuarios() {
        List<Usuario> usuarios = repositorioUsuario.findAll();
        return usuarios.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public void salvarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = convertToEntity(usuarioDto);
        repositorioUsuario.save(usuario);
    }

    public void alterarUsuario(UsuarioDto usuarioDto) {
        Long usuarioId = usuarioDto.getId();
        if (usuarioId != null && usuarioId > 0) {
            Optional<Usuario> optionalUsuario = repositorioUsuario.findById(usuarioId);
            if (optionalUsuario.isPresent()) {
                Usuario usuario = optionalUsuario.get();
                BeanUtils.copyProperties(usuarioDto, usuario, "id");
                repositorioUsuario.save(usuario);
            }
        }
    }

    public void excluirUsuario(Long usuarioId) {
        repositorioUsuario.deleteById(usuarioId);
    }

    private UsuarioDto convertToDto(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        BeanUtils.copyProperties(usuario, usuarioDto);
        return usuarioDto;
    }

    private Usuario convertToEntity(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);
        return usuario;
    }
}
