package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.model.Emprestimo;
import com.eltonfernandesdev.library_api.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/library/emprestimo")
public class EmprestimoController {

    private EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {this.emprestimoService = emprestimoService;}

    @PostMapping
    public Emprestimo save(@RequestBody Emprestimo emprestimo) {
        return emprestimoService.save(emprestimo);
    }

    @GetMapping("/{id}")
    public Optional<Emprestimo> findById(@PathVariable("id") Long idEmprestimo) {
        return emprestimoService.findById(idEmprestimo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long idEmprestimo) {
        emprestimoService.deleteById(idEmprestimo);
    }

    @PutMapping("/{id}")
    public void alterById(@PathVariable("id") Long idEmprestimo, @RequestBody Emprestimo emprestimo) {
        emprestimoService.alterById(idEmprestimo, emprestimo);
    }
}
