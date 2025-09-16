package Avaliativos.Lista07.Cinema

import java.util.UUID;

public class Ingresso {
    private UUID ingressoId;
    private UUID filmeId;
    private int assentoNumero;

    public Ingresso() {}

    public Ingresso(UUID filmeId, int assentoNumero) {
        this.ingressoId = UUID.randomUUID();
        this.filmeId = filmeId;
        this.assentoNumero = assentoNumero;
    }

    public UUID getIngressoId() { return ingressoId; }
    public void setIngressoId(UUID ingressoId) { this.ingressoId = ingressoId; }

    public UUID getFilmeId() { return filmeId; }
    public void setFilmeId(UUID filmeId) { this.filmeId = filmeId; }

    public int getAssentoNumero() { return assentoNumero; }
    public void setAssentoNumero(int assentoNumero) { this.assentoNumero = assentoNumero; }
}

