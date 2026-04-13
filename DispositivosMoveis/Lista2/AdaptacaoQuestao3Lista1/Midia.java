package com.example.lista2_l1q3;

public abstract class Midia {
    protected String titulo;
    protected int ano;

    public Midia(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public abstract String reproduzir();
    public abstract String exibirDetalhes();
}