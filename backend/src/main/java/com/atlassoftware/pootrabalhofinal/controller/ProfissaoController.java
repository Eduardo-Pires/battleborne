package com.atlassoftware.pootrabalhofinal.controller;

import com.atlassoftware.pootrabalhofinal.entities.Profissao;
import com.atlassoftware.pootrabalhofinal.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/job")
public class ProfissaoController {
    @Autowired
    private ProfissaoRepository profissaoRepository;
    @GetMapping("/ping")
    public String ping() {
        return "Pong!";
    }

    @GetMapping
    public ResponseEntity<List<Profissao>> findAll() {
        return ResponseEntity.ok(profissaoRepository.findAll());
    }
}
