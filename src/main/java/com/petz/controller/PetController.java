package com.petz.controller;

import com.petz.entity.dtos.PetDTO;
import com.petz.entity.dtos.PetGetDTO;
import com.petz.service.PetService;
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
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @ApiOperation(value = "Exibe uma lista de pets")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Exibe uma lista de pets"),
            @ApiResponse(code = 500, message = "Problemas na execução")
    })
    @GetMapping
    public ResponseEntity<List<PetGetDTO>> findAll(){
        return ResponseEntity.ok(this.petService.findAll());
    }

    @ApiOperation(value = "Salva um pet")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Retorna o pet salvo"),
            @ApiResponse(code = 500, message = "Problemas na execução")
    })
    @PostMapping
    public ResponseEntity<PetGetDTO> save(@RequestBody PetDTO dto){

        PetGetDTO petDto = this.petService.save(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{codigo}")
                .buildAndExpand(petDto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(petDto);
    }

    @ApiOperation(value = "Busca um pet por um especifico ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o pet"),
            @ApiResponse(code = 500, message = "pet não encontrado")
    })
    @GetMapping("{id}")
    public ResponseEntity<PetGetDTO> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(this.petService.findById(id));
    }

    @ApiOperation(value = "Deleta um pet")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Não retorna nada"),
            @ApiResponse(code = 500, message = "Cliente não encontrado")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        this.petService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualiza as informações do pet e adiciona ele a um cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mostra o pet atualizado"),
            @ApiResponse(code = 500, message = "pet não encontrado")
    })
    @PutMapping
    public ResponseEntity<PetGetDTO> update(@RequestBody PetDTO dto){
        return ResponseEntity.ok(this.petService.update(dto));
    }
}
