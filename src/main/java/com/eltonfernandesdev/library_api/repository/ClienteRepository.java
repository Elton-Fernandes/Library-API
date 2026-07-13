package com.eltonfernandesdev.library_api.repository;

import com.eltonfernandesdev.library_api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
