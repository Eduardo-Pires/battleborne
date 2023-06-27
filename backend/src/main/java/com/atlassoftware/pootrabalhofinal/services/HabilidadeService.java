package com.atlassoftware.pootrabalhofinal.services;

import com.atlassoftware.pootrabalhofinal.entities.Habilidade;
import com.atlassoftware.pootrabalhofinal.entities.HabilidadeFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadeService {
    private HabilidadeFactory habilidadeFactory = new HabilidadeFactory();

    // Retorna a lista de habilidades do jogador com base no nome da profissão do personagem
    public List<Habilidade> listAllHabilities(String profissao) {
        return habilidadeFactory.create(profissao).returnSkills();
    }
}
