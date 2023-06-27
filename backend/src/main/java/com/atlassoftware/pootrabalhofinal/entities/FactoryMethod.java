package com.atlassoftware.pootrabalhofinal.entities;

// Interface criada para o padrão Factory Method
public interface FactoryMethod<T> {
    Skills create(String profissao);
}
