package com.example.lista2_l1q3;

public class Podcast extends Midia {
    private String anfitriao;
    private int episodio;

    public Podcast(String titulo, int ano, String anfitriao, int episodio) {
        super(titulo, ano);
        this.anfitriao = anfitriao;
        this.episodio = episodio;
    }

    @Override
    public String reproduzir() {
        return "Tocando podcast: Episódio " + episodio +
                " de " + titulo + " com " + anfitriao;
    }

    @Override
    public String exibirDetalhes() {
        return "Podcast\nTítulo: " + titulo +
                "\nAno: " + ano +
                "\nAnfitrião: " + anfitriao +
                "\nEpisódio: " + episodio;
    }
}