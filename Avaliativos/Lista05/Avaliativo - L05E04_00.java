package Avaliativos.Lista05;

import java.util.Scanner;

interface PlataformaSocial {

    void compartilharPostagem(Postagem postagem) throws Exception;

    void compartilharImagem(Postagem postagem) throws Exception;

    void compartilharVideo(Postagem postagem) throws Exception;
}

class Postagem {

    String titulo;
    String descricao;
    String tipo; // texto, imagem, video

    Postagem(String titulo, String descricao, String tipo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
    }
}

class CompartilhamentoNaoSuportadoException extends Exception {

    CompartilhamentoNaoSuportadoException(String mensagem) {
        super(mensagem);
    }
}

class MyBook implements PlataformaSocial {

    @Override
    public void compartilharPostagem(Postagem postagem) {
        System.out.println("MyBook: Compartilhando postagem '" + postagem.titulo + "' - " + postagem.descricao);
    }

    @Override
    public void compartilharImagem(Postagem postagem) {
        System.out.println("MyBook: Compartilhando imagem '" + postagem.titulo + "' - " + postagem.descricao);
    }

    @Override
    public void compartilharVideo(Postagem postagem) {
        System.out.println("MyBook: Compartilhando vídeo '" + postagem.titulo + "' - " + postagem.descricao);
    }
}

class Fotogram implements PlataformaSocial {

    @Override
    public void compartilharPostagem(Postagem postagem) throws Exception {
        throw new CompartilhamentoNaoSuportadoException("Fotogram não suporta compartilhamento de postagens de texto.");
    }

    @Override
    public void compartilharImagem(Postagem postagem) {
        System.out.println("Fotogram: Compartilhando imagem '" + postagem.titulo + "' - " + postagem.descricao);
    }

    @Override
    public void compartilharVideo(Postagem postagem) {
        System.out.println("Fotogram: Compartilhando vídeo '" + postagem.titulo + "' - " + postagem.descricao);
    }
}

class AnyTube implements PlataformaSocial {

    @Override
    public void compartilharPostagem(Postagem postagem) {
        System.out.println("AnyTube: Compartilhando postagem '" + postagem.titulo + "' - " + postagem.descricao);
    }

    @Override
    public void compartilharImagem(Postagem postagem) throws Exception {
        throw new CompartilhamentoNaoSuportadoException("AnyTube não suporta compartilhamento de imagens.");
    }

    @Override
    public void compartilharVideo(Postagem postagem) {
        System.out.println("AnyTube: Compartilhando vídeo '" + postagem.titulo + "' - " + postagem.descricao);
    }
}

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada do usuário
        System.out.print("Digite o título da postagem: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite a descrição da postagem: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite o tipo da postagem (texto, imagem, video): ");
        String tipo = scanner.nextLine().toLowerCase();

        Postagem postagem = new Postagem(titulo, descricao, tipo);

        MyBook myBook = new MyBook();
        try {
            myBook.compartilharPostagem(postagem);
        } catch (Exception e) {
            System.out.println("Erro MyBook: " + e.getMessage());
        }

        Fotogram fotogram = new Fotogram();
        try {
            fotogram.compartilharImagem(postagem);
        } catch (Exception e) {
            System.out.println("Erro Fotogram: " + e.getMessage());
        }

        AnyTube anyTube = new AnyTube();
        try {
            anyTube.compartilharVideo(postagem);
        } catch (Exception e) {
            System.out.println("Erro AnyTube: " + e.getMessage());
        }

        scanner.close();
    }
}
