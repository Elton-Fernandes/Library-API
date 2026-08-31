package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.dto.EditoraRequestDTO;
import com.eltonfernandesdev.library_api.dto.EditoraResponseDTO;
import com.eltonfernandesdev.library_api.service.EditoraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/library/editora")
@Tag(name = "Editoras")
public class EditoraController {

    private EditoraService editoraService;

    public EditoraController(EditoraService editoraService) {this.editoraService = editoraService;}

    @Operation(summary = "Salvar editoras", description = "Cadastra editoras")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Editora cadastrada."),
            @ApiResponse(responseCode = "400", description = "CNPJ inválido.")
    })
    @PostMapping
    public EditoraResponseDTO save(@Valid @RequestBody EditoraRequestDTO dto) {
        return editoraService.save(dto);
    }

    @Operation(summary = "Buscar editoras", description = "Busca editoras pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Editora encontrada."),
            @ApiResponse(responseCode = "404", description = "Editora não encontrada.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EditoraResponseDTO> findById(@PathVariable("id") Long idEditora) {
        return editoraService.findById(idEditora)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deletar editoras", description = "Deleta editoras pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Editora deletada.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idEditora) {

        editoraService.deleteById(idEditora);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Alterar editoras", description = "Altera o cadastro de uma editora")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Editora alterada."),
            @ApiResponse(responseCode = "404", description = "Editora não encontrada."),
            @ApiResponse(responseCode = "400", description = "CNPJ inválido.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EditoraResponseDTO> alterById(@PathVariable("id") Long idEditora, @Valid @RequestBody EditoraRequestDTO dto) {
        return ResponseEntity.ok(editoraService.alterById(idEditora, dto));
    }
}
