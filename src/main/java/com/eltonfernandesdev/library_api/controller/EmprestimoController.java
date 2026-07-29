package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.service.EmprestimoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/emprestimo")
public class EmprestimoController {

    private EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {this.emprestimoService = emprestimoService;}
}
