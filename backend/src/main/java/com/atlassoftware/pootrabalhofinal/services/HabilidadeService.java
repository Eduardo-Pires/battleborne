package com.atlassoftware.pootrabalhofinal.services;

import com.atlassoftware.pootrabalhofinal.entities.Habilidade;
import com.atlassoftware.pootrabalhofinal.entities.HabilidadeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadeService {
    private HabilidadeFactory habilidadeFactory = new HabilidadeFactory();

    public List<Habilidade> listAllHabilities(String profissao) {
        return habilidadeFactory.create(profissao).returnSkills();
    }
}
