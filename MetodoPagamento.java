package GranTurismo;

public interface MetodoPagamento {
    boolean processarPagamento(double valor);
    String getDescricao();
}
