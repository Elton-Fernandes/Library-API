package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.dto.ClienteRequestDTO;
import com.eltonfernandesdev.library_api.dto.ClienteResponseDTO;
import com.eltonfernandesdev.library_api.model.Cliente;
import com.eltonfernandesdev.library_api.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/library/cliente")
public class ClienteController {

   private ClienteService clienteService;

   public ClienteController(ClienteService clienteService) {this.clienteService = clienteService;}

   @PostMapping
   public ClienteResponseDTO save(@RequestBody ClienteRequestDTO dto) {
      return clienteService.save(dto);
   }

   @GetMapping("/{id}")
   public ResponseEntity<ClienteResponseDTO> findById(@PathVariable("id") Long idCliente) {
      return clienteService.findById(idCliente)
              .map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteById(@PathVariable("id") Long idCliente){
      clienteService.deleteById(idCliente);

      return ResponseEntity.noContent().build();
   }

   @PutMapping("/{id}")
   public ResponseEntity<ClienteResponseDTO> alterById(@PathVariable("id") Long idCliente, @RequestBody ClienteRequestDTO dto){

      return ResponseEntity.ok(clienteService.alterById(idCliente, dto));
   }
}
