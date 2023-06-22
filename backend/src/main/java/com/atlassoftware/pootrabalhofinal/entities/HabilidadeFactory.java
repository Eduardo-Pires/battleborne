package com.atlassoftware.pootrabalhofinal.entities;

import java.util.ArrayList;
import java.util.List;

public class HabilidadeFactory implements AbstractFactory<Habilidade> {

    @Override
    public Skills create(String profissao) {
        return switch (profissao) {
            case "Guerreiro" -> new HabilidadeGuerreiro();
            case "Arqueiro" -> new HabilidadeArqueiro();
            case "Mago" -> new HabilidadeMago();
            default -> null;
        };
    }
}
