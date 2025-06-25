package GranTurismoJava;

public class Reserva {
    private static int contador = 0;
    private int codigoReserva;
    private Cliente cliente;
    private PacoteTuristico pacote;
    private MetodoPagamento metodoPagamento;

    public Reserva(Cliente cliente, PacoteTuristico pacote, MetodoPagamento metodoPagamento) {
        this.codigoReserva = ++contador;
        this.cliente = cliente;
        this.pacote = pacote;
        this.metodoPagamento = metodoPagamento;
    }

    public void confirmarReserva() {
        double valor = pacote.getPrecoTotal();
        if (metodoPagamento.processarPagamento(valor)) {
            System.out.println("Reserva #" + codigoReserva + " confirmada para " + cliente.getNome());
            System.out.println("Total pago: R$ " + valor);
        } else {
            System.out.println("Falha ao processar pagamento.");
        }
    }

    public String getResumoReserva() {
        return "Reserva #" + codigoReserva + "\n" + pacote.getDescricaoPacote();
    }
}
