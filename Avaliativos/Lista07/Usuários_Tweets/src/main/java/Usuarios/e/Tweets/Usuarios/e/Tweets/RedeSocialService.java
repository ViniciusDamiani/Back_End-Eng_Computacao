package Avaliativos.Lista07.Usuários_Tweets

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RedeSocialService {

    private final List<Usuario> usuarios = new ArrayList<>();

    public RedeSocialService() {
        // Inicializa com alguns usuários
        usuarios.add(new Usuario("João", "joao@email.com"));
        usuarios.add(new Usuario("Maria", "maria@email.com"));
        usuarios.add(new Usuario("Pedro", "pedro@email.com"));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Optional<Usuario> getUsuario(UUID id) {
        return usuarios.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    public Optional<Tweet> criarTweet(UUID usuarioId, String mensagem) {
        return getUsuario(usuarioId).map(usuario -> {
            Tweet tweet = new Tweet(mensagem);
            usuario.getTweets().add(tweet);
            return tweet;
        });
    }

    public Optional<Tweet> atualizarTweet(UUID usuarioId, UUID tweetId, String novaMensagem) {
        return getUsuario(usuarioId).flatMap(usuario ->
                usuario.getTweets().stream()
                        .filter(t -> t.getTweetId().equals(tweetId))
                        .findFirst()
                        .map(tweet -> {
                            tweet.setMensagem(novaMensagem);
                            tweet.setEditado(true);
                            return tweet;
                        })
        );
    }

    public boolean removerTweet(UUID usuarioId, UUID tweetId) {
        return getUsuario(usuarioId).map(usuario ->
                usuario.getTweets().removeIf(t -> t.getTweetId().equals(tweetId))
        ).orElse(false);
    }
}
