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

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long idAutor) {
        autorRepository.deleteById(idAutor);
    }

    @PutMapping("/{id}")
    public void alterById(@PathVariable("id") long idAutor, @RequestBody Autor autor) {
        autor.setIdAutor(idAutor);
        autorRepository.save(autor);
    }

    @GetMapping
    public List<Autor> findByFiltro(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String nacionalidade) {

        if (nome != null && !nome.isEmpty()) {
            return autorRepository.findByNome(nome);
        }
        if (nacionalidade != null && !nacionalidade.isEmpty()) {
            return autorRepository.findByNacionalidade(nacionalidade);
        }
        return autorRepository.findAll();
    }


}
