package com.atlassoftware.pootrabalhofinal.controller;

import com.atlassoftware.pootrabalhofinal.entities.*;
import com.atlassoftware.pootrabalhofinal.repository.InimigoRepository;
import com.atlassoftware.pootrabalhofinal.repository.PersonagemRepository;
import com.atlassoftware.pootrabalhofinal.repository.ProfissaoRepository;
import com.atlassoftware.pootrabalhofinal.services.InimigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enemy")
public class InimigoController {
    @Autowired
    private InimigoService inimigoService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Hello from Enemy");
    }

    @GetMapping("/{nivel}")
    public ResponseEntity<InimigoBase> createNew(@PathVariable Integer nivel) {
        return ResponseEntity.ok(inimigoService.returnGoblinType(nivel));
    }
}
