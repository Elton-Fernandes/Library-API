package com.eltonfernandesdev.library_api.repository;

import com.eltonfernandesdev.library_api.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
