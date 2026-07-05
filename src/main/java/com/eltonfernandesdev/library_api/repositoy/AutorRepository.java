package com.eltonfernandesdev.library_api.repositoy;

import com.eltonfernandesdev.library_api.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, String> {
}
