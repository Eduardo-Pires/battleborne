package com.atlassoftware.pootrabalhofinal.controller;

import com.atlassoftware.pootrabalhofinal.entities.Habilidade;
import com.atlassoftware.pootrabalhofinal.services.HabilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/habilities")
public class HabilidadeController {
    @Autowired
    private HabilidadeService habilidadeService;

    @GetMapping
    public ResponseEntity<List<Habilidade>> listAllHabilities(@RequestParam String profissao) {
        return ResponseEntity.ok(habilidadeService.listAllHabilities(profissao));
    }
}
