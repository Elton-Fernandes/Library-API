package com.eltonfernandesdev.library_api.service;

import com.eltonfernandesdev.library_api.dto.EditoraRequestDTO;
import com.eltonfernandesdev.library_api.dto.EditoraResponseDTO;
import com.eltonfernandesdev.library_api.mapper.EditoraMapper;
import com.eltonfernandesdev.library_api.model.Editora;
import com.eltonfernandesdev.library_api.repository.EditoraRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditoraService {

    private EditoraRepository editoraRepository;
    private EditoraMapper editoraMapper;

    public EditoraService(EditoraRepository editoraRepository, EditoraMapper editoraMapper) {this.editoraRepository = editoraRepository; this.editoraMapper = editoraMapper;}

    public EditoraResponseDTO save(EditoraRequestDTO dto){

        Editora editora = editoraMapper.toEntity(dto);

        System.out.println("Editora salva: " + editora);
        Editora editoraSalvo = editoraRepository.save(editora);

        return editoraMapper.toResponseDTO(editoraSalvo);
    }

    public Optional<EditoraResponseDTO> findById(Long idEditora) {
        return editoraRepository.findById(idEditora).map(editoraMapper::toResponseDTO);
    }

    public void deleteById(Long idEditora) {
        editoraRepository.deleteById(idEditora);
    }

    public EditoraResponseDTO alterById(Long idEditora, EditoraRequestDTO dto) {

        Editora editora = editoraRepository.findById(idEditora)
                .orElseThrow(()-> new RuntimeException("Editora não encontrada"));

        editora.setNome(dto.getNome());
        editora.setTelefone(dto.getTelefone());
        editora.setCnpj(dto.getCnpj());
        editora.setEmail(dto.getEmail());

        Editora editoraAtualizada = editoraRepository.save(editora);

        return editoraMapper.toResponseDTO(editoraAtualizada);
    }
}
