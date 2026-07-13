package com.eltonfernandesdev.library_api.repository;

import com.eltonfernandesdev.library_api.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByNome(String nome);
    List<Autor> findByNacionalidade(String nacionalidade);

}
