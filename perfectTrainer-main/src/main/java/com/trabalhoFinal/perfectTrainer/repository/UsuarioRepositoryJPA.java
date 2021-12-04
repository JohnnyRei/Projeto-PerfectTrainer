package com.trabalhoFinal.perfectTrainer.repository;

import com.trabalhoFinal.perfectTrainer.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositoryJPA extends JpaRepository<Usuario, Long> {
}
