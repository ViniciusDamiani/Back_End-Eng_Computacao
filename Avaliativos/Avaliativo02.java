import java.util.Random;

public class GeradorJogador {
    public static void main(String[] args) {
        //listas solicitadas
        String[] nomes = {"Cássio", "Vinícius", "Gabriel", "Thiago", "Lucas", "Pedro", "Rafael", "André", "Felipe", "Bruno"};
        String[] sobrenomes = {"Ramos", "Silva", "Souza", "Oliveira", "Santos", "Pereira", "Costa", "Ferreira", "Almeida", "Gomes"};
        String[] posicoes = {"goleiro", "zagueiro", "lateral", "volante", "meia", "atacante"};
        String[] times = {"Corinthians", "Palmeiras", "São Paulo", "Santos", "Flamengo", "Fluminense", "Vasco", "Botafogo", "Grêmio", "Internacional"};

        Random gerador = new Random();

        //sorteios
        String nome = nomes[gerador.nextInt(nomes.length)];
        String sobrenome = sobrenomes[gerador.nextInt(sobrenomes.length)];
        String posicao = posicoes[gerador.nextInt(posicoes.length)];
        String time = times[gerador.nextInt(times.length)];
        int idade = 16 + gerador.nextInt(25); // idade entre 16 e 40

        //saída
        System.out.println(nome + " " + sobrenome + " tem " + idade + " anos, atua como " + posicao + " e atualmente defende o " + time + ".");
    }
}
