package Avaliativos.Lista05;

import java.util.ArrayList;
import java.util.Scanner;

// Classe Musica
class Musica {

    String titulo;
    String artista;

    Musica(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "\"" + titulo + "\" - " + artista;
    }
}

// Classe Playlist
class Playlist {

    String nome;
    ArrayList<Musica> musicas = new ArrayList<>();

    Playlist(String nome) {
        this.nome = nome;
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void imprimirPlaylist() {
        System.out.println("Playlist: " + nome);
        if (musicas.isEmpty()) {
            System.out.println("Nenhuma música na playlist.");
        } else {
            for (Musica m : musicas) {
                System.out.println(m);
            }
        }
    }
}

// Classe MusicCloud
class MusicCloud {

    ArrayList<Musica> musicasDisponiveis = new ArrayList<>();

    public void adicionarMusica(Musica musica) {
        musicasDisponiveis.add(musica);
    }

    // Método para pesquisar música pelo título (case insensitive)
    public Musica pesquisarMusica(String titulo) throws Exception {
        for (Musica m : musicasDisponiveis) {
            if (m.titulo.equalsIgnoreCase(titulo)) {
                return m;
            }
        }
        throw new Exception("Música \"" + titulo + "\" não encontrada.");
    }

    public void listarMusicas() {
        System.out.println("Músicas disponíveis:");
        for (Musica m : musicasDisponiveis) {
            System.out.println(m);
        }
    }
}

// Classe principal para testes
class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MusicCloud musicCloud = new MusicCloud();

        musicCloud.adicionarMusica(new Musica("Imagine", "John Lennon"));
        musicCloud.adicionarMusica(new Musica("Bohemian Rhapsody", "Queen"));
        musicCloud.adicionarMusica(new Musica("Thriller", "Michael Jackson"));
        musicCloud.adicionarMusica(new Musica("Like a Rolling Stone", "Bob Dylan"));
        musicCloud.adicionarMusica(new Musica("Billie Jean", "Michael Jackson"));

        System.out.println("Bem-vindo ao MusicCloud!");
        musicCloud.listarMusicas();

        System.out.print("\nDigite o nome da sua playlist: ");
        String nomePlaylist = scanner.nextLine();
        Playlist playlist = new Playlist(nomePlaylist);

        boolean continuar = true;
        while (continuar) {
            System.out.print("Digite o nome da música que deseja adicionar: ");
            String nomeMusica = scanner.nextLine();

            Musica musica = musicCloud.pesquisarMusica(nomeMusica);
            playlist.adicionarMusica(musica);
            System.out.println("Música adicionada: " + musica);

            System.out.print("Deseja adicionar outra música? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        System.out.println();
        playlist.imprimirPlaylist();

        scanner.close();
    }
}
