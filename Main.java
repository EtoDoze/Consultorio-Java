package GranTurismoJava;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa1;
        Cliente cliente1 = null;
        MetodoPagamento pagamento = null;
        Reserva reserva = null;

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

        // Criar destino e serviços turísticos
        Destino destino = new Destino(null, null);
        destino = null;

        Voo voo = new Voo("Air France", "São Paulo", "Paris", 3200.00);
        Hospedagem hospedagem = new Hospedagem("Hotel Eiffel", 5, 450.00);
        Passeio passeio = new Passeio("Tour pela Torre Eiffel", 300.00);

        List<ServicoContratavel> servicos = Arrays.asList(voo, hospedagem, passeio);
        PacoteTuristico pacote = new PacoteTuristico(destino, servicos);

        // Criar reserva
        reserva = new Reserva(cliente1, pacote, pagamento);

        // Menu
        while (true) {
            System.out.println("\nOpções:");
            System.out.println("[1] Exibir Informações");
            if (destino != null) {
                System.out.println("[4] Seu Destino");
            }
            //if(){System.out.println("[2] Confirmar Reserva");}
            
            System.out.println("[3] Inserir Destino");
            System.out.println("[0] Sair");

            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                System.out.println("--------------------------------------------------");
                System.out.println("Cliente: " + cliente1.getNome());
                System.out.println("Email: " + cliente1.getEmail());
                System.out.println("CPF: " + cliente1.getCpf());
                System.out.println("Pagamento: " + pagamento.getDescricao());
                System.out.println("Pacote Turístico:");
                System.out.println(pacote.getDescricaoPacote());
                System.out.println("Preço total: R$ " + pacote.getPrecoTotal());
                System.out.println("--------------------------------------------------");

            } else if (opcao.equals("2")) {
                reserva.confirmarReserva();
            } else if (opcao.equals("3") || opcao.equals("Inserir Destino")) {
                System.out.println("Qual país você quer ir?");
                String pais = scanner.nextLine();
                System.out.println("Qual cidade de "+ pais + " você quer ir?");
                String cidade = scanner.nextLine();
                Destino destiny = new Destino(cidade, pais);
                
            }
            else if ((opcao.equals("4") || opcao.equals("Seu Destino")) && destino != null) {
                destino.getDescricao();
                
            }

            else if (opcao.equals("0")) {
                System.out.println("Encerrando...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
