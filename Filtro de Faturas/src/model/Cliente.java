package model;

import java.util.Date;

public class Cliente {
    String nome;
    Date dataDeInclusao;
    Estado estado;

    public Cliente(String nome, Date dataDeInclusao, Estado estado) {
        this.nome = nome;
        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException();
        }
        this.dataDeInclusao = dataDeInclusao;
        this.estado = estado;
    }
}
