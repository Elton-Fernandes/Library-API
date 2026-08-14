package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.dto.EmprestimoRequestDTO;
import com.eltonfernandesdev.library_api.dto.EmprestimoResponseDTO;
import com.eltonfernandesdev.library_api.model.Emprestimo;
import com.eltonfernandesdev.library_api.service.EmprestimoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/library/emprestimo")
public class EmprestimoController {

    private EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {this.emprestimoService = emprestimoService;}

    @PostMapping
    public EmprestimoResponseDTO save(@RequestBody EmprestimoRequestDTO dto) {
        return emprestimoService.save(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoResponseDTO> findById(@PathVariable("id") Long idEmprestimo) {
        return emprestimoService.findById(idEmprestimo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idEmprestimo) {
        emprestimoService.deleteById(idEmprestimo);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmprestimoResponseDTO> alterById(@PathVariable("id") Long idEmprestimo, @RequestBody EmprestimoRequestDTO dto) {
        return ResponseEntity.ok(emprestimoService.alterById(idEmprestimo, dto));
    }
}
