package Avaliativos.Lista07.Cinema

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    private final CinemaService service;

    public CinemaController(CinemaService service) {
        this.service = service;
    }

    // Filmes
    @GetMapping("/filmes")
    public ResponseEntity<List<Filme>> listarFilmes() {
        return ResponseEntity.ok(service.listarFilmes());
    }

    @PostMapping("/filmes")
    public ResponseEntity<Filme> criarFilme(@RequestParam String titulo,
                                            @RequestParam String genero,
                                            @RequestParam int capacidade) {
        return ResponseEntity.ok(service.criarFilme(titulo, genero, capacidade));
    }

    @PatchMapping("/filmes/{id}")
    public ResponseEntity<?> atualizarFilme(@PathVariable UUID id,
                                            @RequestParam(required = false) String titulo,
                                            @RequestParam(required = false) String genero,
                                            @RequestParam(required = false) Integer capacidade) {
        return service.atualizarFilme(id, titulo, genero, capacidade)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body("Filme não encontrado"));
    }

    @DeleteMapping("/filmes/{id}")
    public ResponseEntity<?> removerFilme(@PathVariable UUID id) {
        boolean removido = service.removerFilme(id);
        return removido
                ? ResponseEntity.ok("Filme removido com sucesso")
                : ResponseEntity.status(404).body("Filme não encontrado");
    }

    // Ingressos
    @PostMapping("/filmes/{id}/ingressos")
    public ResponseEntity<?> comprarIngresso(@PathVariable UUID id) {
        return service.comprarIngresso(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(400).body("Capacidade esgotada ou filme não encontrado"));
    }

    @DeleteMapping("/filmes/{id}/ingressos/{ingressoId}")
    public ResponseEntity<?> devolverIngresso(@PathVariable UUID id,
                                              @PathVariable UUID ingressoId) {
        boolean devolvido = service.devolverIngresso(id, ingressoId);
        return devolvido
                ? ResponseEntity.ok("Ingresso devolvido com sucesso")
                : ResponseEntity.status(404).body("Ingresso não encontrado");
    }
}

