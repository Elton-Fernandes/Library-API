package com.eltonfernandesdev.library_api.repositoy;

import com.eltonfernandesdev.library_api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
