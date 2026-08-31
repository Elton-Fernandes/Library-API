package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.dto.AutorRequestDTO;
import com.eltonfernandesdev.library_api.dto.AutorResponseDTO;
import com.eltonfernandesdev.library_api.model.Autor;
import com.eltonfernandesdev.library_api.repository.AutorRepository;
import com.eltonfernandesdev.library_api.service.AutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library/autor")
@Tag(name = "Autores")
public class AutorController {

    private AutorService autorService;

    public AutorController(AutorService autorService) {this.autorService = autorService;}

    @PostMapping
    @Operation(summary = "Salvar autores", description = "Cadastra novos autores")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cadastrado com sucesso.")
    })
    public AutorResponseDTO salvar(@Valid @RequestBody AutorRequestDTO dto) {
        return autorService.salvar(dto);
    }

    @Operation(summary = "Buscar autores", description = "Busca autores pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Autor encontrado."),
            @ApiResponse(responseCode = "404", description = "Autor não encontrado.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> findById(@PathVariable("id") Long idAutor) {
        return autorService.findById(idAutor)
                .map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());

    }

    @Operation(summary = "Deletar autores", description = "Deleta autores")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Autor deletado.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idAutor) {
        autorService.deleteById(idAutor);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Alterar autores", description = "Altera o cadastro de autores")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Autor alterado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Autor não encontrado.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> alterById(@PathVariable("id") Long idAutor, @Valid @RequestBody AutorRequestDTO dto) {
        return ResponseEntity.ok(autorService.alterById(idAutor, dto));

    }

    @Operation(summary = "Buscar autores", description = "Busca autores pelo nome e/ou nacionalidade")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Autor(es) encontrado(s).")
    })
    @GetMapping
    public ResponseEntity<List<AutorResponseDTO>> findByFiltro(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String nacionalidade) {

            return ResponseEntity.ok(autorService.findByFiltro(nome, nacionalidade));
    }


}
