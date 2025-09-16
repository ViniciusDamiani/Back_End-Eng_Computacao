package Avaliativos.Lista07.Cinema

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CinemaService {

    private final List<Filme> filmes = new ArrayList<>();

    // CRUD de filmes
    public List<Filme> listarFilmes() {
        return filmes;
    }

    public Filme criarFilme(String titulo, String genero, int capacidade) {
        Filme filme = new Filme(titulo, genero, capacidade);
        filmes.add(filme);
        return filme;
    }

    public Optional<Filme> atualizarFilme(UUID id, String titulo, String genero, Integer capacidade) {
        return filmes.stream().filter(f -> f.getId().equals(id)).findFirst().map(filme -> {
            if (titulo != null) filme.setTitulo(titulo);
            if (genero != null) filme.setGenero(genero);
            if (capacidade != null) filme.setCapacidade(capacidade);
            return filme;
        });
    }

    public boolean removerFilme(UUID id) {
        return filmes.removeIf(f -> f.getId().equals(id));
    }

    // Ingressos
    public Optional<Ingresso> comprarIngresso(UUID filmeId) {
        Optional<Filme> filmeOpt = filmes.stream().filter(f -> f.getId().equals(filmeId)).findFirst();

        if (filmeOpt.isPresent()) {
            Filme filme = filmeOpt.get();

            if (filme.getAssentosOcupados() < filme.getCapacidade()) {
                int assentoNumero = filme.getAssentosOcupados() + 1;
                Ingresso ingresso = new Ingresso(filme.getId(), assentoNumero);

                filme.getIngressos().add(ingresso);
                filme.setAssentosOcupados(filme.getAssentosOcupados() + 1);

                return Optional.of(ingresso);
            }
        }
        return Optional.empty();
    }

    public boolean devolverIngresso(UUID filmeId, UUID ingressoId) {
        Optional<Filme> filmeOpt = filmes.stream().filter(f -> f.getId().equals(filmeId)).findFirst();

        if (filmeOpt.isPresent()) {
            Filme filme = filmeOpt.get();
            Optional<Ingresso> ingressoOpt = filme.getIngressos().stream()
                    .filter(i -> i.getIngressoId().equals(ingressoId))
                    .findFirst();

            if (ingressoOpt.isPresent()) {
                filme.getIngressos().remove(ingressoOpt.get());
                filme.setAssentosOcupados(filme.getAssentosOcupados() - 1);
                return true;
            }
        }
        return false;
    }
}

