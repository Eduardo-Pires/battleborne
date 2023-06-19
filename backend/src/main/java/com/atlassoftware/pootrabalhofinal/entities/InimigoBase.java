package com.atlassoftware.pootrabalhofinal.entities;

public abstract class InimigoBase {
    protected String nome;
    protected String tipo;
    protected Integer vida;
    protected Integer ataque;

    protected InimigoBase() {
        nome = "";
        tipo = "";
        vida = 0;
        ataque = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getVida() {
        return vida;
    }

    public Integer getAtaque() {
        return ataque;
    }
}
