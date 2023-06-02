package com.atlassoftware.pootrabalhofinal.controller;

import com.atlassoftware.pootrabalhofinal.entities.Requisicao;
import com.atlassoftware.pootrabalhofinal.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
@CrossOrigin
public class SessaoController {
    @Autowired
    private SessaoService sessaoService;

    @GetMapping
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Pong!");
    }

    @PostMapping
    public ResponseEntity<String> createNew(@RequestBody Requisicao requisicao) {
        sessaoService.criarNovaSessao(requisicao);
        return ResponseEntity.ok("Deu Atlético");
    }
}