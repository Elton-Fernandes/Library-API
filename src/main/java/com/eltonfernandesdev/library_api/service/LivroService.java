package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.dto.LivroRequestDTO;
import com.eltonfernandesdev.library_api.dto.LivroResponseDTO;
import com.eltonfernandesdev.library_api.mapper.LivroMapper;
import com.eltonfernandesdev.library_api.model.Autor;
import com.eltonfernandesdev.library_api.model.Editora;
import com.eltonfernandesdev.library_api.model.Livro;
import com.eltonfernandesdev.library_api.repository.AutorRepository;
import com.eltonfernandesdev.library_api.repository.EditoraRepository;
import com.eltonfernandesdev.library_api.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private LivroRepository livroRepository;
    private EditoraRepository editoraRepository;
    private AutorRepository autorRepository;
    private LivroMapper livroMapper;

    public LivroService(LivroRepository livroRepository, EditoraRepository editoraRepository, AutorRepository autorRepository, LivroMapper livroMapper) {
        this.livroRepository = livroRepository;
        this.editoraRepository = editoraRepository;
        this.autorRepository = autorRepository;
        this.livroMapper = livroMapper;
    }

    public LivroResponseDTO salvar(LivroRequestDTO dto){



        Livro livro = livroMapper.toEntity(dto);

        Editora editora = editoraRepository.findById(dto.getIdEditora())
                .orElseThrow(()-> new RuntimeException("Editora não encontrada"));

        livro.setEditora(editora);

        List<Autor> autores = dto.getAutores()
                .stream()
                .map(id -> autorRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Autor não encontrado: " + id)))
                .toList();

        livro.setAutores(autores);
        Livro livroSalvo = livroRepository.save(livro);

        System.out.println("Livro salvo: " + livro);
        return livroMapper.toResponseDTO(livroSalvo);
    }

    public Optional<LivroResponseDTO> findById(Long idLivro) {
        return livroRepository.findById(idLivro).map(livroMapper::toResponseDTO);
    }

    public void deleteById(Long idLivro) {
        livroRepository.deleteById(idLivro);
    }

    public LivroResponseDTO alterById(LivroRequestDTO dto, Long idLivro) {
        Livro livro = livroRepository.findById(idLivro)
                .orElseThrow(() -> new RuntimeException("Livro não foi encontrado!"));

        livro.setTitulo(dto.getTitulo());
        livro.setGenero(dto.getGenero());
        livro.setIsbn(dto.getIsbn());
        livro.setNumeroPaginas(dto.getNumeroPaginas());

        Editora editora = editoraRepository.findById(dto.getIdEditora())
                .orElseThrow(()-> new RuntimeException("Editora não encontrada"));

        livro.setEditora(editora);

        List<Autor> autores = dto.getAutores()
                .stream()
                .map(id -> autorRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Autor não encontrado: " + id)))
                .toList();

        livro.setAutores(autores);

        Livro livroAtualizado = livroRepository.save(livro);

        return livroMapper.toResponseDTO(livroAtualizado);
    }
}
