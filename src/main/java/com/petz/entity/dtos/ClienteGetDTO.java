package com.petz.entity.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petz.entity.Cliente;
import com.petz.entity.Pet;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ClienteGetDTO {

    private Integer id;

    private String nome;

    private String telefone;

    private String endereco;

    @JsonIgnore
    private List<PetDTO> pets;

    public ClienteGetDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.endereco = cliente.getEndereco();
        this.pets = clienteToDto(cliente);
    }

    private List<PetDTO> clienteToDto(Cliente cliente){
        if(cliente.getPets() != null){
            return cliente.getPets().stream().map(p -> new PetDTO(p)).collect(Collectors.toList());

        }else{
            return null;
        }
    }

    @JsonProperty("pets")
    public List<Pet> getPets(){
        return this.pets.stream().map(p -> new Pet(p)).collect(Collectors.toList());
    }
}
