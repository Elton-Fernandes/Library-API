package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.repository.ClienteRepository;

public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {this.clienteRepository = clienteRepository;}
}
