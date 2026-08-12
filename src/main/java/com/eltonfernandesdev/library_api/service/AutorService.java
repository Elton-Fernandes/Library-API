package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.dto.AutorRequestDTO;
import com.eltonfernandesdev.library_api.dto.AutorResponseDTO;
import com.eltonfernandesdev.library_api.mapper.AutorMapper;
import com.eltonfernandesdev.library_api.model.Autor;
import com.eltonfernandesdev.library_api.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private AutorRepository autorRepository;
    private AutorMapper autorMapper;

    public AutorService(AutorRepository autorRepository, AutorMapper autorMapper) {this.autorRepository = autorRepository; this.autorMapper = autorMapper;}

    public AutorResponseDTO salvar(AutorRequestDTO dto) {
        Autor autor = autorMapper.toEntity(dto);

        System.out.println("Autor Salvo! " + autor);
        Autor autorSalvo = autorRepository.save(autor);
        return autorMapper.toResponseDTO(autorSalvo);
    }

    public Optional<AutorResponseDTO> findById(Long idAutor) {
        return autorRepository.findById(idAutor).map(autorMapper::toResponseDTO);
    }

    public void deleteById(Long idAutor) {
        autorRepository.deleteById(idAutor);
    }

    public AutorResponseDTO alterById(Long idAutor, AutorRequestDTO dto) {
        Autor autor = autorRepository.findById(idAutor)
                .orElseThrow(()-> new RuntimeException("Autor não encontrado!"));

        autor.setNome(dto.getNome());
        autor.setNacionalidade(dto.getNacionalidade());
        autor.setDataNascimento(dto.getDataNascimento());

        Autor autorAtualizado = autorRepository.save(autor);
        return autorMapper.toResponseDTO(autorAtualizado);

    }

    public List<AutorResponseDTO> findByFiltro(String nome, String nacionalidade) {

        List<Autor> autores;

        if (nome != null && !nome.isEmpty()) {
            autores = autorRepository.findByNome(nome);
        } else if (nacionalidade != null && !nacionalidade.isEmpty()) {
            autores = autorRepository.findByNacionalidade(nacionalidade);
        } else {
            autores = autorRepository.findAll();
        }

        return autores.stream()
                .map(autorMapper::toResponseDTO)
                .toList();
    }
}
