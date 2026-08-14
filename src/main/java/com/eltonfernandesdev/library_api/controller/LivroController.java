package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.dto.LivroRequestDTO;
import com.eltonfernandesdev.library_api.dto.LivroResponseDTO;
import com.eltonfernandesdev.library_api.model.Livro;
import com.eltonfernandesdev.library_api.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/library/livro")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService) {this.livroService = livroService;}

    @PostMapping
    public LivroResponseDTO salvar(@RequestBody LivroRequestDTO dto){
        return livroService.salvar(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> findById(@PathVariable("id") Long idLivro) {
        return livroService.findById(idLivro)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idLivro) {
        livroService.deleteById(idLivro);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> alterById(@PathVariable("id") Long idLivro, @RequestBody LivroRequestDTO dto) {

        return ResponseEntity.ok(livroService.alterById(dto, idLivro));
    }
}
