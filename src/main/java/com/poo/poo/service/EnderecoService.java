package com.poo.poo.service;

//import com.poo.poo.dto.EnderecoDTO;
import com.poo.poo.dto.EnderecoDTO;
import com.poo.poo.model.Endereco;
import com.poo.poo.repository.RepositorioEndereco;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    private final RepositorioEndereco repositorioEndereco;

    @Autowired
    public EnderecoService(RepositorioEndereco repositorioEndereco) {
        this.repositorioEndereco = repositorioEndereco;
    }

    public List<EnderecoDTO> listarEnderecos() {
        List<Endereco> enderecos = repositorioEndereco.findAll();
        return enderecos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void salvarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = convertToEntity(enderecoDTO);
        repositorioEndereco.save(endereco);
    }

    public void alterarEndereco(EnderecoDTO enderecoDTO) {
        Long enderecoId = enderecoDTO.getId();
        if (enderecoId != null && enderecoId > 0) {
            Optional<Endereco> optionalEndereco = repositorioEndereco.findById(enderecoId);
            if (optionalEndereco.isPresent()) {
                Endereco endereco = optionalEndereco.get();
                BeanUtils.copyProperties(enderecoDTO, endereco, "id");
                repositorioEndereco.save(endereco);
            }
        }
    }

    public void excluirEndereco(Long enderecoId) {
        repositorioEndereco.deleteById(enderecoId);
    }

    private EnderecoDTO convertToDTO(Endereco endereco) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        BeanUtils.copyProperties(endereco, enderecoDTO);
        return enderecoDTO;
    }

    private Endereco convertToEntity(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        return endereco;
    }
}
