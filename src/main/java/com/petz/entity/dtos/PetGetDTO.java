package com.petz.entity.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petz.entity.Cliente;
import com.petz.entity.Pet;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetGetDTO {

    private Integer id;

    private String nome;

    private String raca;

    @JsonIgnore
    private Cliente cliente;

    public PetGetDTO(Pet p) {
        this.id = p.getId();
        this.nome = p.getNome();
        this.raca = p.getRaca();
        this.cliente = p.getCliente();
    }

    public PetGetDTO(){}

    @JsonProperty("cliente")
    public Cliente getPets(){
        if(this.cliente != null){
            return new Cliente(this.cliente.getId(), this.cliente.getNome(), this.cliente.getEndereco());

        }else{
            return null;
        }
    }
}
