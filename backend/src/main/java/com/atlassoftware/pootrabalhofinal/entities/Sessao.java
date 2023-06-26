package com.atlassoftware.pootrabalhofinal.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sessao")
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSessao")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "profissao")
    private String profissao;
    @Column(name = "vida")
    private Integer vida;
    @Column(name = "ataque")
    private Integer ataque;
    @Column(name = "defesa")
    private Integer defesa;
    @Column(name = "nivel")
    private Integer nivel;

    protected Sessao() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public Integer getVida() {
        return vida;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public Integer getNivel() {
        return nivel;
    }

    public static class SessaoBuilder {
        private String nome;
        private String profissao;
        private Integer vida;
        private Integer ataque;
        private Integer defesa;
        private Integer nivel;

        public SessaoBuilder() {}

        public SessaoBuilder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public SessaoBuilder setProfissao(String profissao) {
            this.profissao = profissao;
            return this;
        }

        public SessaoBuilder setVida(Integer vida) {
            this.vida = vida;
            return this;
        }

        public SessaoBuilder setAtaque(Integer ataque) {
            this.ataque = ataque;
            return this;
        }

        public SessaoBuilder setDefesa(Integer defesa) {
            this.defesa = defesa;
            return this;
        }

        public SessaoBuilder setNivel(Integer nivel) {
            this.nivel = nivel;
            return this;
        }

        public Sessao build() {
            Sessao sessao = new Sessao();
            sessao.nome = this.nome;
            sessao.profissao = this.profissao;
            sessao.vida = this.vida;
            sessao.ataque = this.ataque;
            sessao.defesa = this.defesa;
            sessao.nivel = this.nivel;
            return sessao;
        }
    }
}
