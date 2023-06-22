package com.atlassoftware.pootrabalhofinal.entities;

import java.util.List;

public interface AbstractFactory<T> {
    Skills create(String profissao);
}
