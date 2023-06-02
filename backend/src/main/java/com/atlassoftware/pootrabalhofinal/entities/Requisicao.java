package com.atlassoftware.pootrabalhofinal.entities;

public class Requisicao {
    private String nomeReq;
    private String profissao;
    private Integer ataque;
    private Integer vida;
    private Integer defesa;

    public String getNomeReq() {
        return nomeReq;
    }

    public void setNomeReq(String nome) {
        this.nomeReq = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }
}
