package com.atlassoftware.pootrabalhofinal.entities;

import java.util.ArrayList;
import java.util.List;


// Habilidade Mago gerada para Factory Method
public class HabilidadeMago implements Skills {

    @Override
    public List<Habilidade> returnSkills() {
        List<Habilidade> habilidades = new ArrayList<>();

        habilidades.add(new Habilidade("Magia", 5.0, "Ataque"));
        habilidades.add(new Habilidade("Mais magia", 7.5, "Ataque"));
        habilidades.add(new Habilidade("MAAAAAGIIIIIAAAAA", 10.0, "Ataque"));
        habilidades.add(new Habilidade("Cura", 5.0, "Buff-cura"));

        return habilidades;
    }
}
