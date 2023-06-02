package com.atlassoftware.pootrabalhofinal.controller;

import com.atlassoftware.pootrabalhofinal.entities.Personagem;
import com.atlassoftware.pootrabalhofinal.entities.Profissao;
import com.atlassoftware.pootrabalhofinal.entities.Requisicao;
import com.atlassoftware.pootrabalhofinal.repository.PersonagemRepository;
import com.atlassoftware.pootrabalhofinal.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/character")
public class PersonagemController {
    @Autowired
    private ProfissaoRepository profissaoRepository;
    @Autowired
    private PersonagemRepository personagemRepository;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Hello from Character");
    }

    /*@PostMapping
    public ResponseEntity<Personagem> createNew(@RequestBody Requisicao req) {
        Optional<Profissao> profissao = profissaoRepository.findById(req.getProfissao());
        Personagem personagem = new Personagem.PersonagemBuilder()
                .setNome(req.getNomeReq())
                .setProfissao(profissao.get())
                .setNivel(1)
                .build();
        personagemRepository.save(personagem);
        return ResponseEntity.ok(personagem);
    }*/
}
