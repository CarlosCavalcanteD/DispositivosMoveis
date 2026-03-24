class Musica extends Midia {
    private String artista;
    private String album;

    public Musica(String titulo, int ano, String artista, String album) {
        super(titulo, ano);
        this.artista = artista;
        this.album = album;
    }

    @Override
    public void reproduzir() {
        javax.swing.JOptionPane.showMessageDialog(null,
            "Tocando música: " + titulo + " de " + artista);
    }

    @Override
    public String exibirDetalhes() {
        return "Música\nTítulo: " + titulo +
               "\nAno: " + ano +
               "\nArtista: " + artista +
               "\nÁlbum: " + album;
    }
}