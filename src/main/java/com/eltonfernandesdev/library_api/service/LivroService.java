package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.model.Livro;
import com.eltonfernandesdev.library_api.repository.LivroRepository;

public class LivroService {

    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {this.livroRepository = livroRepository;}
}
