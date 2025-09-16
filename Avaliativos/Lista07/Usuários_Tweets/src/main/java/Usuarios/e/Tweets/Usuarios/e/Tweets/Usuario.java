package Avaliativos.Lista07.Usuários_Tweets

import java.util.*;

public class Usuario {
    private UUID id;
    private String nome;
    private String email;
    private List<Tweet> tweets = new ArrayList<>();

    public Usuario() {}

    public Usuario(String nome, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Tweet> getTweets() { return tweets; }
    public void setTweets(List<Tweet> tweets) { this.tweets = tweets; }
}
