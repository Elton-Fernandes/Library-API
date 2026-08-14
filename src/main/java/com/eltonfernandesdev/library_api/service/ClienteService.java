package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.dto.ClienteRequestDTO;
import com.eltonfernandesdev.library_api.dto.ClienteResponseDTO;
import com.eltonfernandesdev.library_api.mapper.ClienteMapper;
import com.eltonfernandesdev.library_api.model.Cliente;
import com.eltonfernandesdev.library_api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponseDTO save(ClienteRequestDTO dto) {

        Cliente cliente = clienteMapper.toEntity(dto);

        Cliente clienteSalvo = clienteRepository.save(cliente);
        System.out.println("Cliente salvo: " + cliente);
        return clienteMapper.toResponseDTO(clienteSalvo);
    }

    public Optional<ClienteResponseDTO> findById(Long idCliente) {
        return clienteRepository.findById(idCliente).map(clienteMapper::toResponseDTO);
    }

    public void deleteById(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    public ClienteResponseDTO alterById(Long idCliente, ClienteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(()-> new RuntimeException("Cliente não encontrado"));

        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());
        cliente.setBanned(dto.isBanned());

        Cliente clienteAtualizado = clienteRepository.save(cliente);

        return clienteMapper.toResponseDTO(clienteAtualizado);
    }
}
