package com.atlassoftware.pootrabalhofinal.services;

import com.atlassoftware.pootrabalhofinal.entities.Requisicao;
import com.atlassoftware.pootrabalhofinal.entities.Sessao;
import com.atlassoftware.pootrabalhofinal.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Camada de Serviço de Sessão
@Service
public class SessaoService {
    @Autowired
    private SessaoRepository sessaoRepository;

    // Cria nova sessão e envia os dados para o banco
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

    // Atualiza o atributo nível da sessão no banco
    public Sessao atualizarNivelSessao(String nome, Object valor) {
        Sessao entidade = sessaoRepository.findByNome(nome);
        Sessao entidadeAtualizada = entidade.toBuilder().setNivel((Integer) valor).build();
        sessaoRepository.deleteById(entidade.getId());
        sessaoRepository.save(entidadeAtualizada);

        return entidadeAtualizada;
    }

    // Retorna os dados de sessão com base no nome do personagem
    public Sessao returnExistingSession(String nome) {
        return sessaoRepository.findByNome(nome);
    }
}
