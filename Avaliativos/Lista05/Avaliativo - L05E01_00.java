package Avaliativos.Lista05;

import java.util.Random;

class Personagem  {

    String sNome;
    int iVida;
    int iAtaque;

    public Personagem(String nome, int vida, int ataque) {
        this.sNome = nome;
        this.iVida = vida;
        this.iAtaque = ataque;
    }

    public void pubReceberDano(int kiSubtraiVida)
    {
        if (this.iVida <= 0)
        {
            System.out.println("Você foi derrotado!");
            return;
        }
        
        this.iVida -= kiSubtraiVida;
    }

    public void pubAtacar(Personagem pAlvo) {

        if (pAlvo.iVida <= 0) {
            System.out.println("O ataque de " + sNome + " falhou! " + pAlvo.sNome + " já está derrotado.");
            return;
        }

        System.out.println(sNome + " atacou " + pAlvo.sNome + " causando " + iAtaque + " de dano.");

        pAlvo.pubReceberDano(this.iAtaque);
    }
}

class Main {
    
    public static void main(String[] args) {

        Personagem[] soInimigos = {
            new Personagem("Gabriel Barbosa", 60, 5),
            new Personagem("P. Diddy", 200, 150),
            new Personagem("Goleiro Bruno", 80, 90)
        };

        Personagem pJogador = new Personagem("Bolsonaro", 999, 120);
    
        for (int i = 0; i < soInimigos.length; i++) 
        {
            Random rGerador = new Random();
            int iAlvo = rGerador.nextInt(soInimigos.length);  

            pJogador.pubAtacar(soInimigos[iAlvo]);
        }

    }
}
