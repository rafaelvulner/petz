package com.petz.entity.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.petz.entity.Cliente;
import com.petz.entity.Pet;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ClienteDTO {

    private Integer id;

    private String nome;

    private String telefone;

    private String endereco;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.endereco = cliente.getEndereco();
    }

    public ClienteDTO(){}
}
