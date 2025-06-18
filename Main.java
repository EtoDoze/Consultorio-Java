package GranTurismoJava;

public class Main {
    public static void main(String[] args) {
        Pessoa teste = new Pessoa("Rodrigo","rogberto@gmail.com");
        teste.exibirInfo();


          // Cria um objeto CartaoCredito usando a interface MetodoPagamento
        MetodoPagamento pagamento = new CartaoCredito("1234-5678-9012-3456", "João Silva");

        // Usa os métodos definidos pela interface
        System.out.println(pagamento.getDescricao());

        boolean aprovado = pagamento.processarPagamento(100.0);
        System.out.println("Pagamento aprovado? " + aprovado);
    }

}
