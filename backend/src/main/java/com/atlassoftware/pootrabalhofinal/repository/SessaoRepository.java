package com.atlassoftware.pootrabalhofinal.repository;

import com.atlassoftware.pootrabalhofinal.entities.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {
    Sessao findByNome(String nome);
}
