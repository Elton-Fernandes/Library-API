package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.model.Cliente;
import com.eltonfernandesdev.library_api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {this.clienteRepository = clienteRepository;}

    public Cliente save(Cliente cliente) {
        System.out.println("Cliente salvo: " + cliente);
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(Long idCliente) {
        return clienteRepository.findById(idCliente);
    }

    public void deleteById(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    public void alterById(Long idCliente, Cliente cliente) {
        cliente.setIdCliente(idCliente);
        clienteRepository.save(cliente);
    }
}
