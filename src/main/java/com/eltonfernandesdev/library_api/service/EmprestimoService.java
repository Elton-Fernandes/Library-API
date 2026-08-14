package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.dto.EmprestimoRequestDTO;
import com.eltonfernandesdev.library_api.dto.EmprestimoResponseDTO;
import com.eltonfernandesdev.library_api.mapper.EmprestimoMapper;
import com.eltonfernandesdev.library_api.model.Cliente;
import com.eltonfernandesdev.library_api.model.Emprestimo;
import com.eltonfernandesdev.library_api.model.Livro;
import com.eltonfernandesdev.library_api.repository.ClienteRepository;
import com.eltonfernandesdev.library_api.repository.EmprestimoRepository;
import com.eltonfernandesdev.library_api.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    private EmprestimoRepository emprestimoRepository;
    private LivroRepository livroRepository;
    private ClienteRepository clienteRepository;
    private EmprestimoMapper emprestimoMapper;

    public EmprestimoService(EmprestimoRepository emprestimoRepository,
                             LivroRepository livroRepository,
                             ClienteRepository clienteRepository,
                             EmprestimoMapper emprestimoMapper
    ) {this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.clienteRepository = clienteRepository;
        this.emprestimoMapper = emprestimoMapper;
    }

    public EmprestimoResponseDTO save(EmprestimoRequestDTO dto) {

        Emprestimo emprestimo = emprestimoMapper.toEntity(dto);

        Livro livro = livroRepository.findById(dto.getIdLivro())
                .orElseThrow(()-> new RuntimeException("Livro não encontrado!"));

        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(()-> new RuntimeException("Cliente não encontrado!"));

        emprestimo.setCliente(cliente);
        emprestimo.setLivro(livro);
        List<Emprestimo> lista = emprestimoRepository.findByLivroIdLivro(livro.getIdLivro());

            boolean livroIndisponivel = lista.stream().anyMatch(emprestimoExistente -> !emprestimoExistente.isDevolvido());

            if (livroIndisponivel) {
                throw new IllegalArgumentException("Livro indisponível! Espere ele ser devolvido.");
            }

        emprestimo.setDataInicio(LocalDate.now());
        emprestimo.setDataFim(emprestimo.getDataInicio().plusMonths(1));

        Emprestimo emprestimoSalvo = emprestimoRepository.save(emprestimo);
        return emprestimoMapper.toResponseDTO(emprestimoSalvo);
    }

    public Optional<EmprestimoResponseDTO> findById(Long idEmprestimo) {
        return emprestimoRepository.findById(idEmprestimo).map(emprestimoMapper::toResponseDTO);
    }

    public void deleteById(Long idEmprestimo) {
        emprestimoRepository.deleteById(idEmprestimo);
    }

    public EmprestimoResponseDTO alterById(Long idEmprestimo, EmprestimoRequestDTO dto) {
        Emprestimo emprestimo = emprestimoRepository.findById(idEmprestimo)
                .orElseThrow(()-> new RuntimeException("Empréstimo não encontrado!"));

        emprestimo.setValor(dto.getValor());
        emprestimo.setPago(dto.isPago());
        emprestimo.setDevolvido(dto.isDevolvido());

        Livro livro = livroRepository.findById(dto.getIdLivro())
                .orElseThrow(()-> new RuntimeException("Livro não encontrado!"));

        emprestimo.setLivro(livro);

        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(()-> new RuntimeException("Cliente não encontrado"));

        emprestimo.setCliente(cliente);

        Emprestimo emprestimoAtualizado = emprestimoRepository.save(emprestimo);

        return emprestimoMapper.toResponseDTO(emprestimoAtualizado);
    }
}
