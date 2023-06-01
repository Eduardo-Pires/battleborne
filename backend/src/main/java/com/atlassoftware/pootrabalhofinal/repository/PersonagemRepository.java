package com.atlassoftware.pootrabalhofinal.repository;

import com.atlassoftware.pootrabalhofinal.entities.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}
