package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.dto.EmprestimoRequestDTO;
import com.eltonfernandesdev.library_api.mapper.EmprestimoMapper;
import com.eltonfernandesdev.library_api.model.Cliente;
import com.eltonfernandesdev.library_api.model.Emprestimo;
import com.eltonfernandesdev.library_api.model.Livro;
import com.eltonfernandesdev.library_api.repository.ClienteRepository;
import com.eltonfernandesdev.library_api.repository.EmprestimoRepository;
import com.eltonfernandesdev.library_api.repository.LivroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class EmprestimoServiceTest {

    @Mock
    private LivroRepository livroRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private EmprestimoRepository emprestimoRepository;

    @Mock
    private EmprestimoMapper emprestimoMapper;

    @InjectMocks
    private EmprestimoService emprestimoService;

    @Test
    void emprestimoRegraNegocioTest() {

        Livro livro = new Livro();
        livro.setIdLivro(1L);

        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);

        Emprestimo emprestimoExistente = new Emprestimo();
        emprestimoExistente.setLivro(livro);
        emprestimoExistente.setDevolvido(false);

        EmprestimoRequestDTO dto = new EmprestimoRequestDTO();
        dto.setIdLivro(1L);
        dto.setIdCliente(1L);

        assertThrows(RuntimeException.class, () -> {
            emprestimoService.save(dto);
        });

    }
}
