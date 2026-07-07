package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.repositoy.ClienteRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/Cliente")
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {this.clienteRepository = clienteRepository;}
}
