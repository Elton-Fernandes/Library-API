package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.model.Emprestimo;
import com.eltonfernandesdev.library_api.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmprestimoService {

    private EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {this.emprestimoRepository = emprestimoRepository;}

    public Emprestimo save(Emprestimo emprestimo) {
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
