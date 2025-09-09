package com.example.Gerador.de.Jogador;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/jogador")
public class GeradorDeJogadorController {

    private static final List<String> lNome = List.of("Ronaldo", "Pelé", "Neymar", "Romário", "Zico");
    private static final List<String> lSobrenome = List.of("Topete", "Rei", "Craque 10", "Artilheiro", "Mengo");

    private final Random random = new Random();

    @GetMapping("/{time}/{posicao}")
    public Jogador gerarJogador(@PathVariable String time, @PathVariable String posicao) {
        String nome = lNome.get(random.nextInt(lNome.size()));
        String sobrenome = lSobrenome.get(random.nextInt(lSobrenome.size()));
        int idade = 18 + random.nextInt(23); // idade entre 18 e 40

        return new Jogador(nome, sobrenome, idade, posicao, time);
    }

    static class Jogador {
        private String nome;
        private String sobrenome;
        private int idade;
        private String posicao;
        private String time;

        public Jogador(String nome, String sobrenome, int idade, String posicao, String time) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.idade = idade;
            this.posicao = posicao;
            this.time = time;
        }

        public String getNome() { return nome; }
        public String getSobrenome() { return sobrenome; }
        public int getIdade() { return idade; }
        public String getPosicao() { return posicao; }
        public String getTime() { return time; }
    }
}
