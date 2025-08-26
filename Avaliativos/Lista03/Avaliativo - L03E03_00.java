package Avaliativos.Lista03;

import java.util.Random;

class Senha {
    String valor;

    public Senha(int tamanho) {
        this.valor = gerarSenha(tamanho);
    }

    private String gerarSenha(int tamanho) {
        char[] listaCaracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        Random gerador = new Random();
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            int indice = gerador.nextInt(listaCaracteres.length);
            senha.append(listaCaracteres[indice]);
        }

        return senha.toString();
    }

    public void exibir() {
        System.out.println("Senha gerada: " + valor);
    }
}

class GeradorSenha {
    public static void main(String[] args) {
        System.out.println("===== Senhas Geradas =====");
        for (int i = 0; i < 10; i++) {
            Senha senha = new Senha(8);
            senha.exibir();
        }
    }
}
