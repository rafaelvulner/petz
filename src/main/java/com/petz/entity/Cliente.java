package com.petz.entity;

import com.petz.entity.dtos.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Pet> pets;

    public Cliente(ClienteDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.telefone = dto.getTelefone();
        this.endereco = dto.getEndereco();
        this.pets = dto.getDtoToCliente();
    }

    public Cliente(Integer id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }
}
