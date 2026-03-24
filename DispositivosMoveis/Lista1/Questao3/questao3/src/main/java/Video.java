class Video extends Midia {
    private String diretor;
    private int duracao;

    public Video(String titulo, int ano, String diretor, int duracao) {
        super(titulo, ano);
        this.diretor = diretor;
        this.duracao = duracao;
    }

    @Override
    public void reproduzir() {
        javax.swing.JOptionPane.showMessageDialog(null,
            "Reproduzindo vídeo: " + titulo + " dirigido por " + diretor);
    }

    @Override
    public String exibirDetalhes() {
        return "Vídeo\nTítulo: " + titulo +
               "\nAno: " + ano +
               "\nDiretor: " + diretor +
               "\nDuração: " + duracao + " min";
    }
}