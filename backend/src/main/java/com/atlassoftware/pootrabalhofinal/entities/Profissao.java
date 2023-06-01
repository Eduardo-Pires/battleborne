package com.atlassoftware.pootrabalhofinal.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "profissao")
public class Profissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfissao")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "vida")
    private Integer vida;

    @Column(name = "ataque")
    private Integer ataque;

    @Column(name = "defesa")
    private Integer defesa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }
}
