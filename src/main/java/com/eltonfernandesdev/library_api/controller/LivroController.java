package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.repository.LivroRepository;
import com.eltonfernandesdev.library_api.service.LivroService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/livro")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService) {this.livroService = livroService;}
}
