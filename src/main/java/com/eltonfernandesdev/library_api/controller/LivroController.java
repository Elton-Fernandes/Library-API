package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.model.Livro;
import com.eltonfernandesdev.library_api.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/library/livro")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService) {this.livroService = livroService;}

    @PostMapping
    public Livro salvar(@RequestBody Livro livro){
        return livroService.salvar(livro);
    }

    @GetMapping("/{id}")
    public Optional<Livro> findById(@PathVariable("id") Long idLivro) {
        return livroService.findById(idLivro);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long idLivro) {
        livroService.deleteById(idLivro);
    }

    @PutMapping("/{id}")
    public void alterById(@PathVariable("id") Long idLivro, @RequestBody Livro livro) {
        livroService.alterById(livro, idLivro);
    }
}
