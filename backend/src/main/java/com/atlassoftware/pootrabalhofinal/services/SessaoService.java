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

    public void atualizarDadoSessao(Requisicao requisicao, String dado, Object valor) {
        Sessao.SessaoBuilder builder = new Sessao.SessaoBuilder()
                .setNome(requisicao.getNomeReq())
                .setProfissao(requisicao.getProfissao())
                .setVida(requisicao.getVida())
                .setAtaque(requisicao.getAtaque())
                .setDefesa(requisicao.getDefesa())
                .setNivel(requisicao.getNivel());

        switch (dado) {
            case "nome" -> builder.setNome((String) valor);
            case "profissao" -> builder.setProfissao((String) valor);
            case "vida" -> builder.setVida((Integer) valor);
            case "ataque" -> builder.setAtaque((Integer) valor);
            case "defesa" -> builder.setDefesa((Integer) valor);
            case "nivel" -> builder.setNivel((Integer) valor);
            default -> throw new IllegalArgumentException();
        }

        Sessao sessao = builder.build();
        sessaoRepository.save(sessao);
    }



    public Sessao returnExistingSession(String nome) {
        return sessaoRepository.findByNome(nome);
    }
}
