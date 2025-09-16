package Avaliativos.Lista07.Jogador

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeService {

    private final List<Jogador> jogadoresTitulares = new ArrayList<>();
    private final List<Jogador> jogadoresReservas = new ArrayList<>();

    public TimeService() {
        // Inicializa titulares (0 a 10 → 11 jogadores)
        for (int i = 0; i < 11; i++) {
            jogadoresTitulares.add(new Jogador("Titular " + i, "Posição " + i, 20 + i));
        }

        // Inicializa reservas (11 a 15 → 5 jogadores)
        for (int i = 11; i < 16; i++) {
            jogadoresReservas.add(new Jogador("Reserva " + i, "Posição " + i, 18 + i));
        }
    }

    public List<Jogador> getTitulares() {
        return jogadoresTitulares;
    }

    public List<Jogador> getReservas() {
        return jogadoresReservas;
    }

    public String substituirJogador(int posicao, int indiceReserva) {
        if (posicao < 0 || posicao >= jogadoresTitulares.size()) {
            return "Posição inválida";
        }
        if (indiceReserva < 0 || indiceReserva >= jogadoresReservas.size()) {
            return "Índice de reserva inválido";
        }

        // Troca efetiva
        Jogador titularSubstituido = jogadoresTitulares.get(posicao);
        Jogador reservaEntrando = jogadoresReservas.get(indiceReserva);

        jogadoresTitulares.set(posicao, reservaEntrando);

        // Jogador substituído vira reserva
        jogadoresReservas.set(indiceReserva, titularSubstituido);

        return "Substituição realizada: " + titularSubstituido.getNome()
                + " saiu, " + reservaEntrando.getNome() + " entrou.";
    }
}
