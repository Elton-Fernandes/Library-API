package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.model.Autor;
import com.eltonfernandesdev.library_api.model.Livro;
import com.eltonfernandesdev.library_api.repository.AutorRepository;
import com.eltonfernandesdev.library_api.repository.EditoraRepository;
import com.eltonfernandesdev.library_api.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private LivroRepository livroRepository;
    private EditoraRepository editoraRepository;
    private AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, EditoraRepository editoraRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.editoraRepository = editoraRepository;
        this.autorRepository = autorRepository;
    }

    public Livro salvar(Livro livro){
        Long idEditora = livro.getEditora().getIdEditora();

        if (!editoraRepository.existsById(idEditora)) {
            throw new IllegalArgumentException("Editora não encontrada");
        }

        for (Autor autor : livro.getAutores()) {

            Long idAutor = autor.getIdAutor();

            if (!autorRepository.existsById(idAutor)) {
                throw new IllegalArgumentException("Autor não encontrado: " + autor.getIdAutor());
            }
        }
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
