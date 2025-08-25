package Avaliativos.Lista03;
 
import java.util.Random;

class GeradorJogador {
    public static void main(String[] args) {
        String[] nomes = {"Cássio", "Vinícius", "Gabriel", "Thiago", "Lucas", "Pedro", "Rafael", "André", "Felipe", "Bruno"};
        String[] sobrenomes = {"Ramos", "Silva", "Souza", "Oliveira", "Santos", "Pereira", "Costa", "Ferreira", "Almeida", "Gomes"};
        String[] posicoes = {"goleiro", "zagueiro", "lateral", "volante", "meia", "atacante"};
        String[] times = {"Corinthians", "Palmeiras", "São Paulo", "Santos", "Flamengo", "Fluminense", "Vasco", "Botafogo", "Grêmio", "Internacional"};

        Random rGerador = new Random();

        for (int i = 0; i < 11; i++) {
            String sNome = nomes[rGerador.nextInt(nomes.length)];
            String sSobrenome = sobrenomes[rGerador.nextInt(sobrenomes.length)];
            String sPosicao = posicoes[rGerador.nextInt(posicoes.length)];
            String sTime = times[rGerador.nextInt(times.length)];
            int iIdade = 16 + rGerador.nextInt(25);

            Jogador jJogador = new Jogador(sNome, sSobrenome, sPosicao, sTime, iIdade);

            System.out.println(jJogador.DadosJogador());
        }
    }
}

