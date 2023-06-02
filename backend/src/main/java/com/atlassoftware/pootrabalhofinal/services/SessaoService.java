package com.atlassoftware.pootrabalhofinal.services;

import com.atlassoftware.pootrabalhofinal.entities.Requisicao;
import com.atlassoftware.pootrabalhofinal.entities.Sessao;
import com.atlassoftware.pootrabalhofinal.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessaoService {
    @Autowired
    private SessaoRepository sessaoRepository;

    public void criarNovaSessao(Requisicao requisicao) {
        Sessao sessao = new Sessao.SessaoBuilder()
                .setNome(requisicao.getNomeReq())
                .setProfissao(requisicao.getProfissao())
                .setVida(requisicao.getVida())
                .setAtaque(requisicao.getAtaque())
                .setDefesa(requisicao.getDefesa())
                .setNivel(1)
                .build();
        sessaoRepository.save(sessao);
    }
}
