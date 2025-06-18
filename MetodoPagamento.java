package GranTurismoJava;

public interface MetodoPagamento {
    boolean processarPagamento(double valor);
    String getDescricao();
}
