import java.util.ArrayList;

class ReferenciaJava {

    // Estrutura do programa
    public static void main(String[] args) {
        // Instanciando a classe Carro
        Carro meuCarro = new Carro();
        meuCarro.modelo = "Fusca";
        meuCarro.ano = 1970;
        meuCarro.ligar();
        meuCarro.buzinar();

        // Teste de encapsulamento
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João");
        pessoa.setIdade(30);
        System.out.println("Nome: " + pessoa.getNome() + ", Idade: " + pessoa.getIdade());

        // Exemplo de polimorfismo
        Animal animal = new Animal();
        animal.fazerSom();
        Cachorro cachorro = new Cachorro();
        cachorro.fazerSom();

        // Exemplo de exceção
        try {
            int resultado = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Erro: Divisão por zero");
        }

        // Testando coleção (ArrayList)
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("Python");
        System.out.println("Lista de linguagens: " + lista);
    }

    // Classe Carro
    static class Carro {
        String modelo;
        int ano;

        public void ligar() {
            System.out.println("Carro ligado");
        }

        public void buzinar() {
            System.out.println("Buzinando...");
        }
    }

    // Classe Pessoa (Encapsulamento)
    static class Pessoa {
        private String nome;
        private int idade;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }
    }

    // Classe Animal (Polimorfismo)
    static class Animal {
        public void fazerSom() {
            System.out.println("Som do animal");
        }
    }

    // Classe Cachorro (Polimorfismo)
    static class Cachorro extends Animal {
        @Override
        public void fazerSom() {
            System.out.println("Latindo...");
        }
    }

    // Classe abstrata Veiculo (Abstração)
    static abstract class Veiculo {
        public abstract void mover();
    }

    // Classe Carro que herda de Veiculo (Herança)
    static class Carro2 extends Veiculo {
        @Override
        public void mover() {
            System.out.println("Carro se movendo");
        }
    }

    // Interface Veiculo (Interface)
    interface VeiculoInterface {
        void mover();
    }

    // Classe Carro que implementa a interface VeiculoInterface
    static class Carro3 implements VeiculoInterface {
        @Override
        public void mover() {
            System.out.println("Carro se movendo");
        }
    }
}
