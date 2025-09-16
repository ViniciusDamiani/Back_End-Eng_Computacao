package Avaliativos.Lista07.Biblioteca

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {

    private final BibliotecaService service;

    public BibliotecaController(BibliotecaService service) {
        this.service = service;
    }

    @GetMapping("/livros")
    public ResponseEntity<List<Livro>> listarLivros() {
        return ResponseEntity.ok(service.getLivrosDisponiveis());
    }

    @GetMapping("/emprestados")
    public ResponseEntity<List<Emprestimo>> listarEmprestimos() {
        return ResponseEntity.ok(service.getEmprestimos());
    }

    @PostMapping("/emprestados")
    public ResponseEntity<?> criarEmprestimo(@RequestParam UUID livroId,
                                             @RequestParam String usuarioId) {
        return service.criarEmprestimo(livroId, usuarioId)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body("Livro não disponível para empréstimo"));
    }

    @DeleteMapping("/emprestados/{emprestimoId}")
    public ResponseEntity<?> removerEmprestimo(@PathVariable UUID emprestimoId) {
        return service.devolverEmprestimo(emprestimoId)
                .<ResponseEntity<?>>map(l -> ResponseEntity.ok("Livro devolvido com sucesso"))
                .orElseGet(() -> ResponseEntity.status(404).body("Empréstimo não encontrado"));
    }
}
