package com.atlassoftware.pootrabalhofinal.entities;

public class Requisicao {
    private String nomeReq;
    private Long idProfissao;
    private Integer ataque;
    private Integer vida;
    private Integer defesa;

    public String getNomeReq() {
        return nomeReq;
    }

    public void setNomeReq(String nome) {
        this.nomeReq = nome;
    }

    public Long getIdProfissao() {
        return idProfissao;
    }

    public void setIdProfissao(Long idProfissao) {
        this.idProfissao = idProfissao;
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
