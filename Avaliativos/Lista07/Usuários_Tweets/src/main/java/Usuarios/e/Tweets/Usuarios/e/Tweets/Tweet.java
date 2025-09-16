package Avaliativos.Lista07.Usuários_Tweets

import java.time.LocalDateTime;
import java.util.UUID;

public class Tweet {
    private UUID tweetId;
    private String mensagem;
    private boolean editado;
    private LocalDateTime dataCriacao;

    public Tweet() {}

    public Tweet(String mensagem) {
        this.tweetId = UUID.randomUUID();
        this.mensagem = mensagem;
        this.editado = false;
        this.dataCriacao = LocalDateTime.now();
    }

    public UUID getTweetId() { return tweetId; }
    public void setTweetId(UUID tweetId) { this.tweetId = tweetId; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public boolean isEditado() { return editado; }
    public void setEditado(boolean editado) { this.editado = editado; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}
