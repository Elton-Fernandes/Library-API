package com.eltonfernandesdev.library_api.service;

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

    public EmprestimoService(EmprestimoRepository emprestimoRepository,
                             LivroRepository livroRepository,
                             ClienteRepository clienteRepository
    ) {this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.clienteRepository = clienteRepository;
    }

    public Emprestimo save(Emprestimo emprestimo) {

        Long idLivro = emprestimo.getLivro().getIdLivro();
        Long idCliente = emprestimo.getCliente().getIdCliente();

        if (!livroRepository.existsById(idLivro)) {
            throw new IllegalArgumentException("Livro não encontrado");
        }

        if (!clienteRepository.existsById(idCliente)) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        List<Emprestimo> lista = emprestimoRepository.findByLivroIdLivro(emprestimo.getLivro().getIdLivro());


            boolean livroIndisponivel = lista.stream().anyMatch(emprestimoExistente -> !emprestimoExistente.isDevolvido());

            if (livroIndisponivel) {
                throw new IllegalArgumentException("Livro indisponível! Espere ele ser devolvido.");
            }



        emprestimo.setDataInicio(LocalDate.now());
        emprestimo.setDataFim(emprestimo.getDataInicio().plusMonths(1));
        return emprestimoRepository.save(emprestimo);
    }

    public Optional<Emprestimo> findById(Long idEmprestimo) {
        return emprestimoRepository.findById(idEmprestimo);
    }

    public void deleteById(Long idEmprestimo) {
        emprestimoRepository.deleteById(idEmprestimo);
    }

    public void alterById(Long idEmprestimo, Emprestimo emprestimo) {
        emprestimo.setIdEmprestimo(idEmprestimo);
        emprestimoRepository.save(emprestimo);
    }
}
