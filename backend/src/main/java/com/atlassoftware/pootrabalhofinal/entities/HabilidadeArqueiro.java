package com.atlassoftware.pootrabalhofinal.entities;

import java.util.ArrayList;
import java.util.List;

public class HabilidadeArqueiro implements Skills {

    @Override
    public List<Habilidade> returnSkills() {
        List<Habilidade> habilidades = new ArrayList<>();

        habilidades.add(new Habilidade("Tiro", 5.0, "Ataque"));
        habilidades.add(new Habilidade("Muitos tiros", 7.5, "Ataque"));
        habilidades.add(new Habilidade("Chuva de tiro", 10.0, "Ataque"));
        habilidades.add(new Habilidade("Aumentar ataque", 0.0, "Buff"));

        return habilidades;
    }
}
