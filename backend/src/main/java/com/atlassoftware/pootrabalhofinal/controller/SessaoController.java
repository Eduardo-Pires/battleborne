package com.atlassoftware.pootrabalhofinal.controller;

import com.atlassoftware.pootrabalhofinal.entities.Requisicao;
import com.atlassoftware.pootrabalhofinal.entities.Sessao;
import com.atlassoftware.pootrabalhofinal.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controlador responsável pela entidade Sessao

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

    // Cria uma nova sessão
    @PostMapping
    public ResponseEntity<String> createNew(@RequestBody Requisicao requisicao) {
        sessaoService.criarNovaSessao(requisicao);
        return ResponseEntity.ok("Deu Atlético");
    }

    // Recupera dados de uma sessão já existente
    @GetMapping("/search")
    public ResponseEntity<Sessao> returnExistingSession(@RequestParam String nome) {
        Sessao sessao = sessaoService.returnExistingSession(nome);
        return ResponseEntity.ok(sessao);
    }

    // Atualiza o nível do jogador assim que ele passa de fase
    @PutMapping("/update-level")
    public ResponseEntity<Sessao> updateSessionLevel(@RequestParam String nome, @RequestParam Integer nivel) {
        Sessao sessaoAtualizada = sessaoService.atualizarNivelSessao(nome, nivel);
        return ResponseEntity.ok(sessaoAtualizada);
    }
}
