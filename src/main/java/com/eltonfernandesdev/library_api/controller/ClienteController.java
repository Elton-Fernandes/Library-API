package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.dto.ClienteRequestDTO;
import com.eltonfernandesdev.library_api.dto.ClienteResponseDTO;
import com.eltonfernandesdev.library_api.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/library/cliente")
@Tag(name = "Clientes")
public class ClienteController {

   private ClienteService clienteService;

   public ClienteController(ClienteService clienteService) {this.clienteService = clienteService;}

   @Operation(summary = "Salvar clientes", description = "Cadastra clientes")
   @ApiResponses({
           @ApiResponse(responseCode = "200", description = "Cliente cadastrado."),
           @ApiResponse(responseCode = "400", description = "CPF ou email inválido.")
   })
   @PostMapping
   public ClienteResponseDTO save(@Valid @RequestBody ClienteRequestDTO dto) {
      return clienteService.save(dto);
   }

   @Operation(summary = "Buscar clientes", description = "Busca clientes pelo ID")
   @ApiResponses({
           @ApiResponse(responseCode = "200", description = "Cliente encontrado."),
           @ApiResponse(responseCode = "404", description = "Cliente não encontrado.")
   })
   @GetMapping("/{id}")
   public ResponseEntity<ClienteResponseDTO> findById(@PathVariable("id") Long idCliente) {
      return clienteService.findById(idCliente)
              .map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());
   }

   @Operation(summary = "Deletar clientes", description = "Deleta clientes pelo ID")
   @ApiResponses({
           @ApiResponse(responseCode = "200", description = "Cliente deletado.")
   })
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteById(@PathVariable("id") Long idCliente){
      clienteService.deleteById(idCliente);

      return ResponseEntity.noContent().build();
   }

   @Operation(summary = "Alterar clientes", description = "Altera o cadastro de um cliente")
   @ApiResponses({
           @ApiResponse(responseCode = "200", description = "Cadastro alterado."),
           @ApiResponse(responseCode = "400", description = "CPF ou email inválido.")
   })
   @PutMapping("/{id}")
   public ResponseEntity<ClienteResponseDTO> alterById(@PathVariable("id") Long idCliente, @Valid @RequestBody ClienteRequestDTO dto){

      return ResponseEntity.ok(clienteService.alterById(idCliente, dto));
   }
}
