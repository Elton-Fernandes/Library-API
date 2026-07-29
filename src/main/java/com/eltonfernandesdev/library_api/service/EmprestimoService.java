package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {

    private EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {this.emprestimoRepository = emprestimoRepository;}
}
