package com.atlassoftware.pootrabalhofinal.entities;

import java.io.Serial;
import java.io.Serializable;

// Classe Habilidade usada pelo Factory Method
public class Habilidade implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String nomeHab;
    private Double forca;
    private String tipo;

    public Habilidade() {}

    public Habilidade(String nomeHab, Double forca, String tipo) {
        this.nomeHab = nomeHab;
        this.forca = forca;
        this.tipo = tipo;
    }

    public String getNomeHab() {
        return nomeHab;
    }

    public void setNomeHab(String nomeHab) {
        this.nomeHab = nomeHab;
    }

    public Double getForca() {
        return forca;
    }

    public void setForca(Double forca) {
        this.forca = forca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
