package Avaliativos.Lista04;

class Fatura {
    private String numero;
    private String descricao;
    private int quantidade;
    private double precoPorItem;

    // Construtor
    public Fatura(String numero, String descricao, int quantidade, double precoPorItem) {
        this.numero = numero;
        this.descricao = descricao;
        setQuantidade(quantidade);     // usa o setter para validar
        setPrecoPorItem(precoPorItem); // usa o setter para validar
    }

    // Getters e Setters
    public String getNumero() {
        return numero;
    } 

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            this.quantidade = 0;
        } else {
            this.quantidade = quantidade;
        }
    }

    public double getPrecoPorItem() {
        return precoPorItem;
    }

    public void setPrecoPorItem(double precoPorItem) {
        if (precoPorItem < 0) {
            this.precoPorItem = 0.0;
        } else {
            this.precoPorItem = precoPorItem;
        }
    }

    // Método para calcular o total da fatura
    public double getTotalFatura() {
        return quantidade * precoPorItem;
    }

    @Override
    public String toString() {
        return "Fatura [Número: " + numero +
                ", Descrição: " + descricao +
                ", Quantidade: " + quantidade +
                ", Preço por Item: R$ " + precoPorItem +
                ", Total: R$ " + getTotalFatura() + "]";
    }
}
