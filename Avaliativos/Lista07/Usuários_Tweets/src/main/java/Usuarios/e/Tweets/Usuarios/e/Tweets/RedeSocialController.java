package Avaliativos.Lista07.Usuários_Tweets

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.*;

@RestController
@RequestMapping("/rede")
public class RedeSocialController {

    private final RedeSocialService service;

    public RedeSocialController(RedeSocialService service) {
        this.service = service;
    }

    // Lista todos os usuários
    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(service.getUsuarios());
    }

    // Lista todos os tweets de um usuário
    @GetMapping("/usuarios/{id}/tweets")
public ResponseEntity<?> listarTweets(@PathVariable UUID id) {
    Optional<Usuario> usuarioOpt = service.getUsuario(id);

    if (usuarioOpt.isPresent()) {
        Usuario usuario = usuarioOpt.get();
        return ResponseEntity.ok(usuario.getTweets());
    } else {
        return ResponseEntity.status(404).body("Usuário não encontrado");
    }
}





    // Cria um tweet para um usuário
    @PostMapping("/usuarios/{id}/tweets")
    public ResponseEntity<?> criarTweet(@PathVariable UUID id,
                                        @RequestParam String mensagem) {
        return service.criarTweet(id, mensagem)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body("Usuário não encontrado"));
    }

    // Atualiza a mensagem de um tweet
    @PatchMapping("/usuarios/{id}/tweets/{tweetId}")
    public ResponseEntity<?> atualizarTweet(@PathVariable UUID id,
                                            @PathVariable UUID tweetId,
                                            @RequestParam String mensagem) {
        return service.atualizarTweet(id, tweetId, mensagem)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body("Tweet não encontrado"));
    }

    // Remove um tweet de um usuário
    @DeleteMapping("/usuarios/{id}/tweets/{tweetId}")
    public ResponseEntity<?> removerTweet(@PathVariable UUID id,
                                          @PathVariable UUID tweetId) {
        boolean removido = service.removerTweet(id, tweetId);
        return removido
                ? ResponseEntity.ok("Tweet removido com sucesso")
                : ResponseEntity.status(404).body("Tweet não encontrado");
    }
}
