import java.util.Random;
import java.util.Scanner;

public class GeradorPokemon {
    public static void main(String[] args) {
        //listas de nomes e tipos
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

        Scanner leitor = new Scanner(System.in);
        Random gerador = new Random();

        System.out.print("Quantos Pokémon deseja gerar? ");
        int quantidade = leitor.nextInt();

        for (int i = 0; i < quantidade; i++) {
            String nome = nomesPokemon[gerador.nextInt(nomesPokemon.length)];
            String tipo = tiposPokemon[gerador.nextInt(tiposPokemon.length)];
            int nivel = 1 + gerador.nextInt(100); // nível entre 1 e 100

            System.out.println(nome + " é um Pokémon do tipo " + tipo + " de nível " + nivel + ".");
        }

        leitor.close();
    }
}
