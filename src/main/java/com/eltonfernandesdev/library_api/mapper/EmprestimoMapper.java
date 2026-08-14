package com.eltonfernandesdev.library_api.mapper;

import com.eltonfernandesdev.library_api.dto.EmprestimoRequestDTO;
import com.eltonfernandesdev.library_api.dto.EmprestimoResponseDTO;
import com.eltonfernandesdev.library_api.model.Emprestimo;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoMapper {

    public Emprestimo toEntity(EmprestimoRequestDTO dto){

        Emprestimo emprestimo = new Emprestimo();

        emprestimo.setDevolvido(dto.isDevolvido());
        emprestimo.setPago(dto.isPago());
        emprestimo.setValor(dto.getValor());

        return emprestimo;
    }

    public EmprestimoResponseDTO toResponseDTO (Emprestimo emprestimo) {

        EmprestimoResponseDTO dto = new EmprestimoResponseDTO();

        dto.setIdEmprestimo(emprestimo.getIdEmprestimo());
        dto.setDataInicio(emprestimo.getDataInicio());
        dto.setDataFim(emprestimo.getDataFim());
        dto.setDevolvido(emprestimo.isDevolvido());
        dto.setPago(emprestimo.isPago());
        dto.setValor(emprestimo.getValor());
        dto.setIdLivro(emprestimo.getLivro().getIdLivro());
        dto.setIdCliente(emprestimo.getCliente().getIdCliente());

        return dto;
    }
}
