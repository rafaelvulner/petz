package com.petz.service;

import com.petz.entity.Cliente;
import com.petz.entity.Pet;
import com.petz.entity.dtos.PetDTO;
import com.petz.entity.dtos.PetGetDTO;
import com.petz.exceptions.ClienteNotFound;
import com.petz.exceptions.PetNotFound;
import com.petz.repository.ClienteRepository;
import com.petz.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<PetGetDTO> findAll(){
        return this.petRepository.findAll().stream().map(pet -> new PetGetDTO(pet)).collect(Collectors.toList());
    }

    public PetGetDTO save(PetDTO dto){

        Pet pet = new Pet(dto);

        if(dto.getIdCliente() != null){
            Optional<Cliente> cliente = this.clienteRepository.findById(dto.getIdCliente());

            if(!cliente.isPresent())
                throw new ClienteNotFound("Cliente não encontrado");

            pet.setCliente(cliente.get());
        }

        return new PetGetDTO(this.petRepository.save(pet));
    }

    @Transactional
    public PetGetDTO update(PetDTO dto){
        Optional<Pet> pet = this.petRepository.findById(dto.getId());

        if(!pet.isPresent())
            throw new PetNotFound("Pet não encontrato");

       if(dto.getIdCliente() != null){
           Optional<Cliente> cliente = this.clienteRepository.findById(dto.getIdCliente());

           if(!cliente.isPresent())
               throw new ClienteNotFound("Cliente não encontrado");

           pet.get().setCliente(cliente.get());
       }

       pet.get().setNome(dto.getNome());
       pet.get().setRaca(dto.getRaca());

        this.petRepository.save(pet.get());
        return new PetGetDTO(pet.get());
    }

    public PetGetDTO findById(Integer id){

        Optional<Pet> pet = this.petRepository.findById(id);

        if(!pet.isPresent())
            throw new PetNotFound("Pet não encontrado!");

        return new PetGetDTO(pet.get());
    }

    public void delete(Integer id){
        Optional<Pet> pet = this.petRepository.findById(id);

        if(!pet.isPresent())
            throw new PetNotFound("Pet não encontrado!");

        this.petRepository.deleteById(id);

    }
}
