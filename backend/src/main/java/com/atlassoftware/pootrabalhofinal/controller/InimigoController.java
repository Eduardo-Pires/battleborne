package com.atlassoftware.pootrabalhofinal.controller;

import com.atlassoftware.pootrabalhofinal.entities.*;
import com.atlassoftware.pootrabalhofinal.services.InimigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controlador que irá retornar todos os dados de inimigos para a UI baseado no nível atual do jogador
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
    public ResponseEntity<InimigoBase> returnGoblinType(@PathVariable Integer nivel) {
        return ResponseEntity.ok(inimigoService.returnGoblinType(nivel));
    }
}
