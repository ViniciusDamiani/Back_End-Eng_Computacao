package Avaliativos.Lista05;

import java.util.ArrayList;
import java.util.Scanner;

// Classe Cliente (POJO)
class Cliente {

    private String nome;
    private int idade;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

// Classe Filme
class Filme {

    private String nome;
    private double preco;
    private int idadeMinima;

    public Filme(String nome, double preco, int idadeMinima) {
        this.nome = nome;
        this.preco = preco;
        this.idadeMinima = idadeMinima;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }
}

// Classe Ingresso
class Ingresso {

    private Cliente cliente;
    private Filme filme;
    private String assento;

    public Ingresso(Cliente cliente, Filme filme, String assento) {
        this.cliente = cliente;
        this.filme = filme;
        this.assento = assento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Filme getFilme() {
        return filme;
    }

    public String getAssento() {
        return assento;
    }
}

// Exceção para assento indisponível
class AssentoIndisponivelException extends Exception {

    public AssentoIndisponivelException(String message) {
        super(message);
    }
}

// Exceção para idade insuficiente
class IdadeInsuficienteException extends Exception {

    public IdadeInsuficienteException(String message) {
        super(message);
    }
}

// Classe Cinema
class Cinema {

    private ArrayList<Filme> filmesDisponiveis = new ArrayList<>();
    private ArrayList<Ingresso> ingressosVendidos = new ArrayList<>();

    public void adicionarFilme(Filme filme) {
        filmesDisponiveis.add(filme);
    }

    public Filme buscarFilmePorNome(String nome) {
        for (Filme f : filmesDisponiveis) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                return f;
            }
        }
        return null;
    }

    public boolean assentoDisponivel(String assento) {
        for (Ingresso i : ingressosVendidos) {
            if (i.getAssento().equalsIgnoreCase(assento)) {
                return false;
            }
        }
        return true;
    }

    public void venderIngresso(Cliente cliente, Filme filme, String assento) throws AssentoIndisponivelException, IdadeInsuficienteException {
        // Verifica idade do cliente
        if (cliente.getIdade() < filme.getIdadeMinima()) {
            throw new IdadeInsuficienteException("Cliente não tem idade suficiente para assistir ao filme \"" + filme.getNome() + "\".");
        }
        // Verifica se assento está disponível
        if (!assentoDisponivel(assento)) {
            throw new AssentoIndisponivelException("Assento " + assento + " já está ocupado.");
        }
        // Se tudo ok, vende ingresso
        Ingresso ingresso = new Ingresso(cliente, filme, assento);
        ingressosVendidos.add(ingresso);
    }
}

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cinema cinema = new Cinema();

        // Adicionando filmes
        cinema.adicionarFilme(new Filme("Matrix", 20.0, 16));
        cinema.adicionarFilme(new Filme("Toy Story", 15.0, 0));
        cinema.adicionarFilme(new Filme("John Wick", 25.0, 18));
        cinema.adicionarFilme(new Filme("Vingadores", 22.0, 12));
        cinema.adicionarFilme(new Filme("Coraline", 18.0, 10));

        System.out.println("Bem-vindo ao Cinema!");

        boolean continuar = true;

        while (continuar) {
            System.out.print("\nDigite o nome do cliente: ");
            String nomeCliente = scanner.nextLine();

            System.out.print("Digite a idade do cliente: ");
            int idadeCliente = Integer.parseInt(scanner.nextLine());

            Cliente cliente = new Cliente(nomeCliente, idadeCliente);

            System.out.print("Digite o nome do filme: ");
            String nomeFilme = scanner.nextLine();

            Filme filmeEscolhido = cinema.buscarFilmePorNome(nomeFilme);
            if (filmeEscolhido == null) {
                System.out.println("Filme não encontrado. Tente novamente.");
                continue;
            }

            System.out.print("Digite o assento desejado (A1 a F5): ");
            String assento = scanner.nextLine().toUpperCase();

            // Validar formato básico do assento
            if (!assento.matches("[A-F][1-5]")) {
                System.out.println("Assento inválido. Deve estar entre A1 e F5.");
                continue;
            }

            // Tentar vender ingresso
            cinema.venderIngresso(cliente, filmeEscolhido, assento);
            System.out.println("Ingresso vendido com sucesso para " + cliente.getNome() + " no filme \"" + filmeEscolhido.getNome() + "\" no assento " + assento + ".");

            System.out.print("Deseja comprar outro ingresso? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        System.out.println("\nObrigado por usar o sistema do Cinema!");
        scanner.close();
    }
}
