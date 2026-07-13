package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.repository.EditoraRepository;

public class EditoraService {

    private EditoraRepository editoraRepository;

    public EditoraService(EditoraRepository editoraRepository) {this.editoraRepository = editoraRepository;}
}
