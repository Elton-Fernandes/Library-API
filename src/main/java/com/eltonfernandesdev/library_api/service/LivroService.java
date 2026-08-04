package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.model.Livro;
import com.eltonfernandesdev.library_api.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {this.livroRepository = livroRepository;}

    public Livro salvar(Livro livro){
        System.out.println("Livro salvo: " + livro);
        return livroRepository.save(livro);
    }

    public Optional<Livro> findById(Long idLivro) {
        return livroRepository.findById(idLivro);
    }

    public void deleteById(Long idLivro) {
        livroRepository.deleteById(idLivro);
    }

    public void alterById(Livro livro, Long idLivro) {
        livro.setIdLivro(idLivro);
        livroRepository.save(livro);
    }
}
