package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.repository.ClienteRepository;
import com.eltonfernandesdev.library_api.service.ClienteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/Cliente")
public class ClienteController {

   private ClienteService clienteService;

   public ClienteController(ClienteService clienteService) {this.clienteService = clienteService;}
}
