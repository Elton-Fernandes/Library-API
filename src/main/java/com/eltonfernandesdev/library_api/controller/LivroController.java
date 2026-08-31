package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.dto.LivroRequestDTO;
import com.eltonfernandesdev.library_api.dto.LivroResponseDTO;
import com.eltonfernandesdev.library_api.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/library/livro")
@Tag(name = "Livros")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService) {this.livroService = livroService;}

    @Operation(summary = "Salvar livros", description = "Cadastra livros")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Livro cadastrado."),
            @ApiResponse(responseCode = "404", description = "Editora ou Autor não encontrado."),
            @ApiResponse(responseCode = "400", description = "ISBN inválido.")
    })
    @PostMapping
    public LivroResponseDTO salvar(@Valid @RequestBody LivroRequestDTO dto){
        return livroService.salvar(dto);
    }

    @Operation(summary = "Buscar livros", description = "Busca livros pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Livro encontrado."),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> findById(@PathVariable("id") Long idLivro) {
        return livroService.findById(idLivro)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deletar livros", description = "Deleta livros pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Livro deletado.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idLivro) {
        livroService.deleteById(idLivro);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Alterar livros", description = "Altera o cadastro de um livro")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Livro alterado."),
            @ApiResponse(responseCode = "404", description = "Editora ou Autor não encontrado."),
            @ApiResponse(responseCode = "400", description = "ISBN inválido.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> alterById(@PathVariable("id") Long idLivro, @Valid @RequestBody LivroRequestDTO dto) {

        return ResponseEntity.ok(livroService.alterById(dto, idLivro));
    }
}
