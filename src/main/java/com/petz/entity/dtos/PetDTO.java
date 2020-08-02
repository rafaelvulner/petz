package com.petz.entity.dtos;

import com.petz.entity.Pet;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetDTO {

    private Integer id;

    private String nome;

    private String raca;

    private Integer idCliente;

    public PetDTO(Pet p) {
        this.id = p.getId();
        this.nome = p.getNome();
        this.raca = p.getRaca();
    }

    public PetDTO(){}
}
