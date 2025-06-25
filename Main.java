package GranTurismoJava;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa1;
        Cliente cliente1 = null;
        MetodoPagamento pagamento = null;

        // Informações básicas
        System.out.println("Qual seu nome?:");
        String nome = scanner.nextLine();

        System.out.println("Qual seu email?:");
        String email = scanner.nextLine();

        pessoa1 = new Pessoa(nome, email);

        // CPF
        while (cliente1 == null) {
            System.out.println("Olá " + pessoa1.getNome() + ", dono(a) do email: " + pessoa1.getEmail() + ". Deseja virar cliente usando seu CPF?");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("s")) {
                System.out.println("Qual seu CPF?:");
                String cpf = scanner.nextLine();
                cliente1 = new Cliente(pessoa1.getNome(), pessoa1.getEmail(), cpf);
            } else {
                System.out.println("Você precisa informar um CPF para criar um cliente.");
            }
        }

        // Pagamento
        while (pagamento == null) {
            System.out.println("Falta pouco! Agora registre sua chave pix ou seu cartão.");
            System.out.println("Chave Pix[1] \nCartão de Crédito[2]");
            String tipoconta = scanner.nextLine();

            if (tipoconta.equalsIgnoreCase("1") || tipoconta.equalsIgnoreCase("Chave Pix")) {
                System.out.println("Chave pix:");
                String chavepix = scanner.nextLine();
                pagamento = new TransferenciaBancaria(chavepix);
            } else if (tipoconta.equalsIgnoreCase("2") || tipoconta.equalsIgnoreCase("Cartão de Crédito")) {
                System.out.println("Número do cartão:");
                String numero = scanner.nextLine();
                System.out.println("Nome do titular:");
                String titular = scanner.nextLine();
                pagamento = new CartaoCredito(numero, titular);
            } else {
                System.out.println("Opção inválida.");
            }
        }

        // Pacote turístico fictício
        Destino destino = new Destino("Salvador", "Brasil");
        ServicoContratavel voo = new Voo("Azul", "São Paulo", "Salvador", 450.0);
        ServicoContratavel hospedagem = new Hospedagem("Hotel Sol", 5, 180.0);
        ServicoContratavel passeio = new Passeio("Pelourinho Tour", 90.0);

        PacoteTuristico pacote = new PacoteTuristico(destino, Arrays.asList(voo, hospedagem, passeio));

        Reserva reserva = new Reserva(cliente1, pacote, pagamento);

        // Menu
        while (true) {
            System.out.println("\nOpções:");
            System.out.println("[1] Exibir Informações");
            System.out.println("[2] Confirmar Reserva");
            System.out.println("[0] Sair");

            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                System.out.println("--------------------------------------------------");
                System.out.println("Cliente: " + cliente1.getNome());
                System.out.println("Email: " + cliente1.getEmail());
                System.out.println("CPF: " + cliente1.getCpf());
                System.out.println("Pagamento: " + pagamento.getDescricao());
                System.out.println("--------------------------------------------------");
            } else if (opcao.equals("2")) {
                reserva.confirmarReserva();
            } else if (opcao.equals("0")) {
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
