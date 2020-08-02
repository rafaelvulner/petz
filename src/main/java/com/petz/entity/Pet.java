package com.petz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.petz.entity.dtos.PetDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pet", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "raca", nullable = false)
    private String raca;

    @ManyToOne
    @JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "FK_cliente_pet"))
    @JsonIgnore
    private Cliente cliente;

    public Pet(PetDTO p) {
        this.id = p.getId();
        this.nome = p.getNome();
        this.raca = p.getRaca();
    }

    public Pet(){}

    public Pet(Pet pet){
        this.id = pet.getId();
        this.nome = pet.getNome();
        this.raca = pet.getRaca();
    }
}
