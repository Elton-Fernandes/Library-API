package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.model.Cliente;
import com.eltonfernandesdev.library_api.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/library/cliente")
public class ClienteController {

   private ClienteService clienteService;

   public ClienteController(ClienteService clienteService) {this.clienteService = clienteService;}

   @PostMapping
   public Cliente save(@RequestBody Cliente cliente) {
      return clienteService.save(cliente);
   }

   @GetMapping("/{id}")
   public Optional<Cliente> findById(@PathVariable("id") Long idCliente) {
      return clienteService.findById(idCliente);
   }

   @DeleteMapping("/{id}")
   public void deleteById(@PathVariable("id") Long idCliente){
      clienteService.deleteById(idCliente);
   }

   @PutMapping("/{id}")
   public void alterById(@PathVariable("id") Long idCliente, @RequestBody Cliente cliente){
      clienteService.alterById(idCliente, cliente);
   }
}
