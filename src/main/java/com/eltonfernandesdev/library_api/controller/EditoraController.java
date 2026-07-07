package com.eltonfernandesdev.library_api.controller;

import com.eltonfernandesdev.library_api.repositoy.EditoraRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/editora")
public class EditoraController {

    private EditoraRepository editoraRepository;

    public EditoraController(EditoraRepository editoraRepository) {this.editoraRepository = editoraRepository;}

}
