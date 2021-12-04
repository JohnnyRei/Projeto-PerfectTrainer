package com.trabalhoFinal.perfectTrainer.repository;

import com.trabalhoFinal.perfectTrainer.domain.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepositoryJPA extends JpaRepository<Personal, Long> {
}
