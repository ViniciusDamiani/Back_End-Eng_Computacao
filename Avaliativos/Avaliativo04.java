import java.util.Random;

public class GeradorSenha {
    public static void main(String[] args) {
        char[] listaCaracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

        int tamanhoSenha = 8; // conforme pedido
        Random gerador = new Random();
        StringBuilder senha = new StringBuilder();

        //monta a seha sorteando 1 caractere por vez
        for (int i = 0; i < tamanhoSenha; i++) {
            int indice = gerador.nextInt(listaCaracteres.length);
            senha.append(listaCaracteres[indice]);
        }

        System.out.println("Senha gerada: " + senha.toString());
    }
}
