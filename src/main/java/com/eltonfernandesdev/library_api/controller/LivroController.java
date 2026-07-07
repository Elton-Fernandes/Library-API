package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.repositoy.LivroRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {

    private LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {this.livroRepository = livroRepository;}
}
