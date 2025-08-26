package Avaliativos.Lista05;

import java.util.ArrayList;

class Barco{
    String sNome;
    int iTamanho; 

    Barco(String nome, int tamanho) {
        this.sNome = nome;
        this.iTamanho = tamanho;
    }   
}

class BasePorto{

    String sNome;
    ArrayList<Barco> soBarcosAtracados = new ArrayList<>();

    public void pubAtracarBarco(Barco bBarco) {
        soBarcosAtracados.add(bBarco);
        System.out.println("Barco atracado no porto base: " + bBarco.sNome);
    }

    public void pubDesatracarBarco(Barco bBarco) {
        soBarcosAtracados.remove(bBarco);
        System.out.println("Barco desatracado do porto: " + bBarco.sNome);
    }
}

class PortoPequeno extends BasePorto {
    public void pubAtracarBarco(Barco bBarco) {
        if (bBarco.iTamanho <= 10) {
            soBarcosAtracados.add(bBarco);
            System.out.println("Barco pequeno atracado: " + bBarco.sNome);
        } else {
            System.out.println("Barco muito grande para este porto pequeno: " + bBarco.sNome);
        }
    }
}

class PortoGrande extends BasePorto {

    public void pubAtracarBarco(Barco bBarco) {
        if (bBarco.iTamanho >= 10) {
            soBarcosAtracados.add(bBarco);
            System.out.println("Barco grande atracado: " + bBarco.sNome);
        } else {
            System.out.println("Barco pequeno demais para este porto grande: " + bBarco.sNome);
        }
    }
}

class Main
{
    public static void main(String[] args) {
    // Crie uma lista contendo 5 barcos com diferentes tamanhos e dois portos (um pequeno e um grande);
    // Percorra a lista de barcos e use o método atracarBarco para atracar cada barco em um dos portos;
    // Os barcos devem tentar ser atracados primeiramente no porto pequeno e, se não puderem, devem ser atracados no porto grande.

    ArrayList<Barco> abBarcos = new ArrayList<>();
     
    abBarcos.add(new Barco("Barco 1", 5));
    abBarcos.add(new Barco("Barco 2", 12));
    abBarcos.add(new Barco("Barco 3", 10));
    abBarcos.add(new Barco("Barco 4", 8));
    abBarcos.add(new Barco("Barco 5", 15));

    PortoPequeno pPequeno = new PortoPequeno();
    PortoGrande pGrande = new PortoGrande();

    for (Barco barco : abBarcos) {
         System.out.println("Tentando atracar o " + barco.sNome + " (tamanho " + barco.iTamanho + "):");
         
        pPequeno.pubAtracarBarco(barco);
         
        if (!pPequeno.soBarcosAtracados.contains(barco)) {
            pGrande.pubAtracarBarco(barco);
        }
         
        System.out.println();
     }

    }
}