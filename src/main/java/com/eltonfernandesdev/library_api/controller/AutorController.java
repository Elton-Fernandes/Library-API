package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.model.Autor;
import com.eltonfernandesdev.library_api.repositoy.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library/autor")
public class AutorController {

    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {this.autorRepository = autorRepository;}

    @PostMapping
    public Autor salvar(@RequestBody Autor autor) {

        System.out.println("Autor salvo!" + autor);

        autorRepository.save(autor);
        return autor;
    }

    @GetMapping("/{id}")
    public Optional<Autor> findById(@PathVariable("id") long idAutor) {
        return autorRepository.findById(idAutor);


    }

}
