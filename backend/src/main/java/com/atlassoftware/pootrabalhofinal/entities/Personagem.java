package com.atlassoftware.pootrabalhofinal.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "personagem")
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersonagem")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nivel")
    private Integer nivel;
    @ManyToOne
    @JoinColumn(name = "Profissao_idProfissao")
    private Profissao profissao;

    private Personagem() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNivel() {
        return nivel;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    // Padrão Builder
    public static class PersonagemBuilder {
        private String nome;
        private Integer nivel;
        private Profissao profissao;

        public PersonagemBuilder() {
        }

        public PersonagemBuilder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public PersonagemBuilder setNivel(Integer nivel) {
            this.nivel = nivel;
            return this;
        }

        public PersonagemBuilder setProfissao(Profissao profissao) {
            this.profissao = profissao;
            return this;
        }

        public Personagem build() {
            Personagem personagem = new Personagem();
            personagem.nome = this.nome;
            personagem.nivel = this.nivel;
            personagem.profissao = this.profissao;
            return personagem;
        }
    }
}
