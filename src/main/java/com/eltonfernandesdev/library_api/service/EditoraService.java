package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.repository.EditoraRepository;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {

    private EditoraRepository editoraRepository;

    public EditoraService(EditoraRepository editoraRepository) {this.editoraRepository = editoraRepository;}
}
