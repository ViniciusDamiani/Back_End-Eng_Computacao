package org.example;
import java.util.Locale;
import java.util.Scanner;

public class App {
    //scanner Ãºnico para todo o programa
    private static final Scanner entrada = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        System.out.println("=== Sistema de Exercícios ===");
        pessoal();
        produto();
        descontoCompra();
        categoriaEtaria();
        notasEMedia();
        imcComPesoFixo();
        analiseDeNome();

        entrada.close();
    }

    //ex2: dados pessoais bÃ¡sicos
    private static void pessoal() {
        String nome = "Vinicius Damiani";
        String cargo = "Programador de Software V";
        float salario = 5000.00f;

        System.out.println("\n--Pessoal--");
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salário: R$ " + salario);
    }

    //ex3: produto e flags
    private static void produto() {
        String nomeProduto = "Teclado";
        int codigo = 12345;
        double preco = 99.90;
        boolean emPromocao = true;

        System.out.println("\n--Produto--");
        System.out.println("Produto: " + nomeProduto);
        System.out.println("Código: " + codigo);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Promoção: " + emPromocao);
    }

    //ex4: aplica 10% se passar de 100
    private static void descontoCompra() {
        System.out.print("\nInforme o valor total da compra (R$): ");
        double valorCompra = lerDoubleSeguro();
        double valorFinal = (valorCompra > 100.0) ? valorCompra * 0.90 : valorCompra; //aplica 10%

        System.out.printf("Valor final: R$ %.2f%n", valorFinal);
    }

    //ex5: classifica idade
    private static void categoriaEtaria() {
        System.out.print("\nInforme a idade: ");
        int idade = lerIntSeguro();

        String categoria = (idade < 12) ? "Infantil"
                          : (idade <= 17) ? "Adolescente"
                          : "Adulto";

        System.out.println("Categoria: " + categoria);
    }

    //ex6: notas e mÃ©dia
    private static void notasEMedia() {
        int[] notas = {6, 7, 9, 8, 3};
        int soma = 0;

        System.out.print("\nNotas: ");
        for (int n : notas) {
            System.out.print(n + " ");
            soma += n;
        }
        double media = (double) soma / notas.length;
        System.out.printf("%nMédia: %.1f%n", media);
    }

    //ex7: IMC com peso fixo 85 e altura informada
    private static void imcComPesoFixo() {
        double peso = 85.0; //peso fixo solicitado
        System.out.print("\nInforme sua altura (m): ");
        double altura = lerDoubleSeguro();

        if (altura <= 0) {
            System.out.println("Altura inválida.");
            return;
        }

        double imc = peso / (altura * altura);
        System.out.printf("IMC de Vinicius Damiani: %.2f%n", imc);
    }

    //ex8: anÃ¡lise de nome completo
    private static void analiseDeNome() {
        System.out.print("\nDigite o nome completo: ");
        String nomeCompleto = entrada.nextLine();

        //remove espaÃ§os para a contagem
        String semEspacos = nomeCompleto.replace(" ", "");
        int quantidadeCaracteres = semEspacos.length();

        //maiusculas/minusculas e busca
        String emMaiusculas = nomeCompleto.toUpperCase();
        boolean contemSilva = nomeCompleto.toLowerCase().contains("silva");

        System.out.println("Número de caracteres (sem espaÃ§os): " + quantidadeCaracteres);
        System.out.println("Maiúsculas: " + emMaiusculas);
        System.out.println("Contém \"Silva\": " + contemSilva);
    }

    //helpers de leitura
    private static int lerIntSeguro() {
        while (!entrada.hasNextInt()) {
            entrada.next(); //descarta
            System.out.print("Valor inválido. Informe um número inteiro: ");
        }
        int val = entrada.nextInt();
        entrada.nextLine(); //consome quebra de linha
        return val;
    }

    private static double lerDoubleSeguro() {
        while (!entrada.hasNextDouble()) {
            entrada.next();
            System.out.print("Valor inválido. Informe um número decimal: ");
        }
        double val = entrada.nextDouble();
        entrada.nextLine();
        return val;
    }
}