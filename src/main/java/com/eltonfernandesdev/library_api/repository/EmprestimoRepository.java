package com.eltonfernandesdev.library_api.repository;

import com.eltonfernandesdev.library_api.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    List<Emprestimo> findByLivroIdLivro(Long idLivro);
}
