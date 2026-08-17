package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.dto.AutorRequestDTO;
import com.eltonfernandesdev.library_api.dto.AutorResponseDTO;
import com.eltonfernandesdev.library_api.model.Autor;
import com.eltonfernandesdev.library_api.repository.AutorRepository;
import com.eltonfernandesdev.library_api.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library/autor")
public class AutorController {

    private AutorService autorService;

    public AutorController(AutorService autorService) {this.autorService = autorService;}

    @PostMapping
    public AutorResponseDTO salvar(@Valid @RequestBody AutorRequestDTO dto) {
        return autorService.salvar(dto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> findById(@PathVariable("id") Long idAutor) {
        return autorService.findById(idAutor)
                .map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idAutor) {
        autorService.deleteById(idAutor);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> alterById(@PathVariable("id") Long idAutor, @Valid @RequestBody AutorRequestDTO dto) {
        return ResponseEntity.ok(autorService.alterById(idAutor, dto));

    }


    @GetMapping
    public ResponseEntity<List<AutorResponseDTO>> findByFiltro(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String nacionalidade) {

            return ResponseEntity.ok(autorService.findByFiltro(nome, nacionalidade));
    }


}
