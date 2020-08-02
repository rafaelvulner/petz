package com.petz.controller;

import com.petz.entity.dtos.ClienteDTO;
import com.petz.entity.dtos.ClienteGetDTO;
import com.petz.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @ApiOperation(value = "Retorna uma lista de clientes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de clientes"),
            @ApiResponse(code = 500, message = "Cliente não encontrado")
    })

    @GetMapping
    public ResponseEntity<List<ClienteGetDTO>> findAll(){
        return ResponseEntity.ok(this.clienteService.findAll());
    }

    @ApiOperation(value = "Salva um cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente salvo com sucesso"),
            @ApiResponse(code = 500, message = "Problemas na hora de salvar")
    })
    @PostMapping
    public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO dto){

        ClienteDTO clienteDTO = this.clienteService.save(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{codigo}")
                .buildAndExpand(clienteDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(clienteDTO);
    }

    @ApiOperation(value = "Atualiza as informações do cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mostra o cliente atualizado"),
            @ApiResponse(code = 500, message = "Cliente não encontrado")
    })
    @PutMapping
    public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO dto){

        return ResponseEntity.ok(this.clienteService.update(dto));
    }

    @ApiOperation(value = "Deleta um cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Não retorna nada"),
            @ApiResponse(code = 500, message = "Cliente não encontrado")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){

        this.clienteService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Busca um cliente por um especifico ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o cliente"),
            @ApiResponse(code = 500, message = "Cliente não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClienteGetDTO> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(this.clienteService.findById(id));
    }
}
