package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.repository.EditoraRepository;
import com.eltonfernandesdev.library_api.service.EditoraService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/editora")
public class EditoraController {

    private EditoraService editoraService;

    public EditoraController(EditoraService editoraService) {this.editoraService = editoraService;}

}
