package com.atlassoftware.pootrabalhofinal.services;

import com.atlassoftware.pootrabalhofinal.entities.Goblin;
import com.atlassoftware.pootrabalhofinal.entities.HobGoblin;
import com.atlassoftware.pootrabalhofinal.entities.InimigoBase;
import com.atlassoftware.pootrabalhofinal.entities.KingGoblin;
import org.springframework.stereotype.Service;

// Camada de serviço do Inimigo
@Service
public class InimigoService {

    // Retorna o tipo de inimigo com base no nível em que o jogador está
    public InimigoBase returnGoblinType(Integer nivel) {
        return switch (nivel) {
            case 1 -> new Goblin();
            case 2 -> new HobGoblin();
            case 3 -> new KingGoblin();
            default -> null;
        };
    }
}
