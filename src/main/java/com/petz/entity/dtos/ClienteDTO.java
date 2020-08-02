package com.petz.entity.dtos;

import com.petz.entity.Cliente;
import lombok.Getter;
import lombok.Setter;

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
