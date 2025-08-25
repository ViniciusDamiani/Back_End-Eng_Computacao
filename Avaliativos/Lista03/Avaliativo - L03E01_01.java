package Avaliativos.Lista03;

class Jogador {
    private String nome, sobrenome, posicao, time;
    private int idade;

    public Jogador(String nome, String sobrenome, String posicao, String time, int idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.posicao = posicao;
        this.time = time;
        this.idade = idade;
    }

    public String DadosJogador() {
        return nome + " " + sobrenome + " tem " + idade + " anos, atua como " + posicao + " e atualmente defende o " + time + ".";
    }
}
 