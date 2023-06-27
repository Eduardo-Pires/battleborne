package com.atlassoftware.pootrabalhofinal.entities;

// Factory usada para gerar os inimigos que serão mostrados nas fases
public class HabilidadeFactory implements FactoryMethod<Habilidade> {

    // Retorna o objeto requisitado com base no nível do jogador
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
