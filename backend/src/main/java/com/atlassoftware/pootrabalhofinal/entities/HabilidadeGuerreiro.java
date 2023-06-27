package com.atlassoftware.pootrabalhofinal.entities;

import java.util.ArrayList;
import java.util.List;


// Habilidade Guerreiro gerada para Factory Method
public class HabilidadeGuerreiro implements Skills {

    @Override
    public List<Habilidade> returnSkills() {
        List<Habilidade> habilidades = new ArrayList<>();

        habilidades.add(new Habilidade("Giro de Espada", 5.0, "Ataque"));
        habilidades.add(new Habilidade("Esgrima", 7.5, "Ataque"));
        habilidades.add(new Habilidade("Guilhotina", 10.0, "Ataque"));
        habilidades.add(new Habilidade("Bloqueio", 5.0, "Buff-defesa"));

        return habilidades;
    }
}
