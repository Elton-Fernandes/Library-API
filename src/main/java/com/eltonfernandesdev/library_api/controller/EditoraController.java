package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.model.Editora;
import com.eltonfernandesdev.library_api.service.EditoraService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/library/editora")
public class EditoraController {

    private EditoraService editoraService;

    public EditoraController(EditoraService editoraService) {this.editoraService = editoraService;}

    @PostMapping
    public Editora save(@RequestBody Editora editora) {
        return editoraService.save(editora);
    }

    @GetMapping("/{id}")
    public Optional<Editora> findById(@PathVariable("id") Long idEditora) {
        return editoraService.findById(idEditora);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long idEditora) {
        editoraService.deleteById(idEditora);
    }

    @PutMapping("/{id}")
    public void alterById(@PathVariable("id") Long idEditora, @RequestBody Editora editora) {
        editoraService.alterById(idEditora, editora);
    }
}
