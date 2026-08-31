package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.dto.EmprestimoRequestDTO;
import com.eltonfernandesdev.library_api.dto.EmprestimoResponseDTO;
import com.eltonfernandesdev.library_api.model.Emprestimo;
import com.eltonfernandesdev.library_api.service.EmprestimoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/library/emprestimo")
@Tag(name = "Empréstimos")
public class EmprestimoController {

    private EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {this.emprestimoService = emprestimoService;}

    @Operation(summary = "Salvar empréstimos", description = "Cadastra empréstimos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empréstimo cadastrado."),
            @ApiResponse(responseCode = "404", description = "Cliente ou livro não encontrado."),
            @ApiResponse(responseCode = "400", description = "O valor não pode ser negativo.")
    })
    @PostMapping
    public EmprestimoResponseDTO save(@Valid @RequestBody EmprestimoRequestDTO dto) {
        return emprestimoService.save(dto);
    }

    @Operation(summary = "Buscar empréstimos", description = "Busca empréstimos pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empréstimo encontrado."),
            @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoResponseDTO> findById(@PathVariable("id") Long idEmprestimo) {
        return emprestimoService.findById(idEmprestimo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deletar empréstimos", description = "Deleta empréstimos pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empréstimo deletado.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idEmprestimo) {
        emprestimoService.deleteById(idEmprestimo);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Alterar empréstimos", description = "Altera o cadastro de um empréstimo")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empréstimo alterado."),
            @ApiResponse(responseCode = "404", description = "Cliente ou livro não encontrado."),
            @ApiResponse(responseCode = "400", description = "O valor não pode ser negativo.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EmprestimoResponseDTO> alterById(@PathVariable("id") Long idEmprestimo, @Valid @RequestBody EmprestimoRequestDTO dto) {
        return ResponseEntity.ok(emprestimoService.alterById(idEmprestimo, dto));
    }
}
