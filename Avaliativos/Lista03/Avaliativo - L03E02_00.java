package Avaliativos.Lista03;

import java.util.Random;

class Pokemon {
    String nome;
    String tipo;
    int nivel;

    public Pokemon(String nome, String tipo, int nivel) {
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public void exibir() {
        System.out.println(nome + " é um Pokémon do tipo " + tipo + " de nível " + nivel + ".");
    }
}

class GeradorPokemon {
    public static void main(String[] args) {
        String[] nomesPokemon = {
            "Pikachu", "Charmander", "Squirtle", "Bulbasaur", "Eevee", "Jigglypuff",
            "Gengar", "Onix", "Snorlax", "Lucario", "Gardevoir", "Dragonite",
            "Chikorita", "Cyndaquil", "Totodile", "Mewtwo"
        };

        String[] tiposPokemon = {
            "Elétrico", "Fogo", "Água", "Planta", "Pedra", "Terra", "Voador",
            "Gelo", "Inseto", "Normal", "Lutador", "Psíquico", "Fantasma",
            "Dragão", "Sombrio", "Fada", "Metal", "Veneno"
        };

        Random gerador = new Random();

        System.out.println("Pokemons Gerados");
        for (int i = 0; i < 6; i++) {
            String nome = nomesPokemon[gerador.nextInt(nomesPokemon.length)];
            String tipo = tiposPokemon[gerador.nextInt(tiposPokemon.length)];
            int nivel = 1 + gerador.nextInt(100);

            Pokemon poke = new Pokemon(nome, tipo, nivel);
            poke.exibir();
        }
    }
}
