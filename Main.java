package GranTurismoJava;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Um único scanner usado o tempo todo

        System.out.println("Qual seu nome?:");
        String nome = scanner.nextLine();

        System.out.println("Qual seu email?:");
        String email = scanner.nextLine();

        Pessoa teste = new Pessoa(nome, email);

        while (true) {
            System.out.println("\nOpções:");
            System.out.println("Exibir Informações");
            System.out.println("Exit");

            String select = scanner.nextLine(); // Usa o scanner que ainda está aberto

            if (select.equalsIgnoreCase("exibir informações")) {
              System.out.println("------------------------------------------------------------");
                teste.exibirInfo();
                System.out.println("------------------------------------------------------------");
            } else if (select.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        // Demonstração do pagamento
        MetodoPagamento pagamento = new CartaoCredito("1234-5678-9012-3456", "João Silva");
        System.out.println(pagamento.getDescricao());
        boolean aprovado = pagamento.processarPagamento(100.0);
        System.out.println("Pagamento aprovado? " + aprovado);

        scanner.close(); // Fecha o scanner no final do programa
    }
}
