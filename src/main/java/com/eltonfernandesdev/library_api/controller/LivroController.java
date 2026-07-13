package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.repository.LivroRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/livro")
public class LivroController {

    private LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {this.livroRepository = livroRepository;}
}
