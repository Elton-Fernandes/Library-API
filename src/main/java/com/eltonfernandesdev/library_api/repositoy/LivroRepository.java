package com.eltonfernandesdev.library_api.repositoy;

import com.eltonfernandesdev.library_api.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
