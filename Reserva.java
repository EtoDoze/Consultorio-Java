package GranTurismo;

public class Reserva implements MetodoPagamento {
    private int codigoReserva;
    private MetodoPagamento metodoPagamento;

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public Reserva(int codigoReserva, MetodoPagamento metodoPagamento) {
        this.codigoReserva = codigoReserva;
        this.metodoPagamento = metodoPagamento;
    }

    public void confirmarReserva() {
        System.out.println("Reserva " + codigoReserva + " confirmada com sucesso.");
    }

    // Usa o metodoPagamento associado para processar o pagamento
    public boolean realizarPagamento(double valor) {
        return metodoPagamento.processarPagamento(valor);
    }

    // Retorna a descrição do método de pagamento associado
    public String getDescricaoMetodoPagamento() {
        return metodoPagamento.getDescricao();
    }

    // Implementação obrigatória da interface MetodoPagamento
    @Override
    public boolean processarPagamento(double valor) {
        return metodoPagamento.processarPagamento(valor);
    }

    @Override
    public String getDescricao() {
        return "Pagamento de Reserva";
    }
}
