package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.model.Autor;
import com.eltonfernandesdev.library_api.repository.AutorRepository;
import com.eltonfernandesdev.library_api.service.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library/autor")
public class AutorController {

    private AutorService autorService;

    public AutorController(AutorService autorService) {this.autorService = autorService;}

    @PostMapping
    public Autor salvar(@RequestBody Autor autor) {
        return autorService.salvar(autor);
    }


    @GetMapping("/{id}")
    public Optional<Autor> findById(@PathVariable("id") Long idAutor) {
        return autorService.findById(idAutor);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long idAutor) {
        autorService.deleteById(idAutor);
    }

    @PutMapping("/{id}")
    public void alterById(@PathVariable("id") Long idAutor, @RequestBody Autor autor) {
        autorService.alterById(idAutor, autor);
    }


    @GetMapping
    public List<Autor> findByFiltro(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String nacionalidade) {

        return autorService.findByFiltro(nome, nacionalidade);
    }


}
