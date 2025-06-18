package GranTurismoJava;

public class TransferenciaBancaria implements MetodoPagamento {
    private String chavePix;

    public TransferenciaBancaria(String chavePix) {
        this.chavePix = chavePix;
    }

    public boolean processarPagamento(double valor) {
        return true;
    }

    public String getDescricao() {
        return "Transferência PIX: " + chavePix;
    }
}
