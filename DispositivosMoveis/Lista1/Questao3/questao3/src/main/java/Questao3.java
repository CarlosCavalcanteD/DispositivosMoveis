import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Questao3 {
    public static void main(String[] args) {

        ArrayList<Midia> lista = new ArrayList<>();

        while (true) {
            String opcao = JOptionPane.showInputDialog(
                "1 - Cadastrar mídia\n" +
                "2 - Listar mídias\n" +
                "3 - Buscar por título\n" +
                "4 - Reproduzir mídia\n" +
                "5 - Sair"
            );

            if (opcao == null) break;

            switch (opcao) {

                case "1": // Cadastrar
                    String tipo = JOptionPane.showInputDialog(
                        "Escolha o tipo:\n1 - Música\n2 - Vídeo\n3 - Podcast"
                    );

                    String titulo = JOptionPane.showInputDialog("Título:");
                    int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano:"));

                    if (tipo.equals("1")) {
                        String artista = JOptionPane.showInputDialog("Artista:");
                        String album = JOptionPane.showInputDialog("Álbum:");
                        lista.add(new Musica(titulo, ano, artista, album));

                    } else if (tipo.equals("2")) {
                        String diretor = JOptionPane.showInputDialog("Diretor:");
                        int duracao = Integer.parseInt(JOptionPane.showInputDialog("Duração (min):"));
                        lista.add(new Video(titulo, ano, diretor, duracao));

                    } else if (tipo.equals("3")) {
                        String anfitriao = JOptionPane.showInputDialog("Anfitrião:");
                        int episodio = Integer.parseInt(JOptionPane.showInputDialog("Episódio:"));
                        lista.add(new Podcast(titulo, ano, anfitriao, episodio));
                    }

                    break;

                case "2": // Listar
                    if (lista.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhuma mídia cadastrada.");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for (Midia m : lista) {
                            sb.append(m.exibirDetalhes()).append("\n\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                    break;

                case "3": // Buscar
                    String busca = JOptionPane.showInputDialog("Digite o título:");
                    boolean encontrou = false;

                    for (Midia m : lista) {
                        if (m.getTitulo().equalsIgnoreCase(busca)) {
                            JOptionPane.showMessageDialog(null, m.exibirDetalhes());
                            encontrou = true;
                            break;
                        }
                    }

                    if (!encontrou) {
                        JOptionPane.showMessageDialog(null, "Mídia não encontrada.");
                    }
                    break;

                case "4": // Reproduzir
                    String tituloRep = JOptionPane.showInputDialog("Digite o título:");
                    boolean achou = false;

                    for (Midia m : lista) {
                        if (m.getTitulo().equalsIgnoreCase(tituloRep)) {
                            m.reproduzir();
                            achou = true;
                            break;
                        }
                    }

                    if (!achou) {
                        JOptionPane.showMessageDialog(null, "Mídia não encontrada.");
                    }
                    break;

                case "5":
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}