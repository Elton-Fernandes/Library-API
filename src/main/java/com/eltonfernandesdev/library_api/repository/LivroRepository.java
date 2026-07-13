package com.eltonfernandesdev.library_api.repository;

import com.eltonfernandesdev.library_api.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
