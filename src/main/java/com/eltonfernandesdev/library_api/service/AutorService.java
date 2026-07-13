package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.model.Autor;
import com.eltonfernandesdev.library_api.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {this.autorRepository = autorRepository;}

    public Autor salvar(Autor autor) {

        System.out.println("Autor Salvo! " + autor);
        return autorRepository.save(autor);
    }

    public Optional<Autor> findById(Long idAutor) {
        return autorRepository.findById(idAutor);
    }

    public void deleteById(Long idAutor) {
        autorRepository.deleteById(idAutor);
    }

    public void alterById(Long idAutor, Autor autor) {
        autor.setIdAutor(idAutor);
        autorRepository.save(autor);
    }

    public List<Autor> findByFiltro(String nome, String nacionalidade) {

        if (nome != null && !nome.isEmpty()) {
            return autorRepository.findByNome(nome);
        }
        if (nacionalidade != null && !nacionalidade.isEmpty()) {
            return autorRepository.findByNacionalidade(nacionalidade);
        }
        return autorRepository.findAll();
    }
}
