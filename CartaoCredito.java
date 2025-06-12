public class CartaoCredito implements MetodoPagamento {
    private String numeroCartao;
    private String nomeTitular;

    public CartaoCredito(String numeroCartao, String nomeTitular) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
    }

    public boolean processarPagamento(double valor) {
        return true; // Simula aprovação
    }

    public String getDescricao() {
        return "Cartão de Crédito: " + numeroCartao;
    }
}