package com.petz.service;

import com.petz.entity.Cliente;
import com.petz.entity.dtos.ClienteDTO;
import com.petz.entity.dtos.ClienteGetDTO;
import com.petz.exceptions.ClienteNotFound;
import com.petz.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteGetDTO> findAll(){
        return this.clienteRepository.findAll().stream().map(cliente -> new ClienteGetDTO(cliente)).collect(Collectors.toList());
    }

    public ClienteDTO save(ClienteDTO dto){
        return new ClienteDTO(this.clienteRepository.save(new Cliente(dto)));
    }

    @Transactional
    public ClienteDTO update(ClienteDTO dto) {

        Cliente cliente = new Cliente(dto);
        return new ClienteDTO(this.clienteRepository.save(cliente));
    }

    public void delete(Integer id){
        Optional<Cliente> cliente = this.clienteRepository.findById(id);

        if(!cliente.isPresent())
            throw new ClienteNotFound("Cliente não existe!");

        this.clienteRepository.deleteById(id);
    }

    public ClienteGetDTO findById(Integer id){
        Optional<Cliente> cliente = this.clienteRepository.findById(id);

        if(!cliente.isPresent())
            throw new ClienteNotFound("Cliente não existe!");

        return new ClienteGetDTO(cliente.get());
    }
}
