package com.atlassoftware.pootrabalhofinal.entities;

public class HabilidadeFactory implements FactoryMethod<Habilidade> {

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
