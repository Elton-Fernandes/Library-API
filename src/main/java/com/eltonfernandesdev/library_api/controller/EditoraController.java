package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.dto.EditoraRequestDTO;
import com.eltonfernandesdev.library_api.dto.EditoraResponseDTO;
import com.eltonfernandesdev.library_api.model.Editora;
import com.eltonfernandesdev.library_api.service.EditoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/library/editora")
public class EditoraController {

    private EditoraService editoraService;

    public EditoraController(EditoraService editoraService) {this.editoraService = editoraService;}

    @PostMapping
    public EditoraResponseDTO save(@RequestBody EditoraRequestDTO dto) {
        return editoraService.save(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditoraResponseDTO> findById(@PathVariable("id") Long idEditora) {
        return editoraService.findById(idEditora)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idEditora) {

        editoraService.deleteById(idEditora);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditoraResponseDTO> alterById(@PathVariable("id") Long idEditora, @RequestBody EditoraRequestDTO dto) {
        return ResponseEntity.ok(editoraService.alterById(idEditora, dto));
    }
}
