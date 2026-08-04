package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.model.Editora;
import com.eltonfernandesdev.library_api.repository.EditoraRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditoraService {

    private EditoraRepository editoraRepository;

    public EditoraService(EditoraRepository editoraRepository) {this.editoraRepository = editoraRepository;}

    public Editora save(Editora editora){
        return editoraRepository.save(editora);
    }

    public Optional<Editora> findById(Long idEditora) {
        return editoraRepository.findById(idEditora);
    }

    public void deleteById(Long idEditora) {
        editoraRepository.deleteById(idEditora);
    }

    public void alterById(Long idEditora, Editora editora) {
        editora.setIdEditora(idEditora);
        editoraRepository.save(editora);
    }
}
