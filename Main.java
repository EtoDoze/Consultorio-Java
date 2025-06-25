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
        Destino destino = null;
        PacoteTuristico pacote = null;

        // Cadastro básico
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
            String tipoConta = scanner.nextLine();

            if (tipoConta.equalsIgnoreCase("1") || tipoConta.equalsIgnoreCase("Chave Pix")) {
                System.out.println("Chave pix:");
                String chavepix = scanner.nextLine();
                pagamento = new TransferenciaBancaria(chavepix);
            } else if (tipoConta.equalsIgnoreCase("2") || tipoConta.equalsIgnoreCase("Cartão de Crédito")) {
                System.out.println("Número do cartão:");
                String numero = scanner.nextLine();
                System.out.println("Nome do titular:");
                String titular = scanner.nextLine();
                pagamento = new CartaoCredito(numero, titular);
            } else {
                System.out.println("Opção inválida.");
            }
        }

        // Menu principal
        while (true) {
            System.out.println("\nOpções:");
            System.out.println("[1] Exibir Informações");

            if (destino == null) {
                System.out.println("[3] Inserir Destino e Serviços");
            } else {
                System.out.println("[4] Ver Seu Destino");
                System.out.println("[2] Confirmar Reserva");
            }

            System.out.println("[0] Sair");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("-".repeat(50));
                    System.out.println("Cliente: " + cliente1.getNome());
                    System.out.println("Email: " + cliente1.getEmail());
                    System.out.println("CPF: " + cliente1.getCpf());
                    System.out.println("Pagamento: " + pagamento.getDescricao());
                    if (destino != null && pacote != null) {
                        System.out.println("-".repeat(50));
                        System.out.println("Destino: " + destino.getDescricao());
                        System.out.println("Pacote Turístico:");
                        System.out.println(pacote.getDescricaoPacote());
                        System.out.println("Preço total: R$ " + pacote.getPrecoTotal());
                    }
                    System.out.println("-".repeat(50));
                    break;

                case "2":
                    if (reserva != null) {
                        reserva.confirmarReserva();
                    } else {
                        System.out.println("Você precisa definir o destino antes de confirmar a reserva.");
                    }
                    break;

                case "3":
                    if (destino == null) {
                        System.out.println("Qual país você quer ir?");
                        String pais = scanner.nextLine();
                        System.out.println("Qual cidade de " + pais + " você quer ir?");
                        String cidade = scanner.nextLine();

                        destino = new Destino(cidade, pais);

                        System.out.println("Qual companhia aérea?");
                        String companhia = scanner.nextLine();
                        System.out.println("Origem do voo:");
                        String origem = scanner.nextLine();
                        double precoVoo = 500;
                        System.out.println("Preço da passagem: "+precoVoo+"R$");

                        System.out.println("Qual hotel:");
                        String nomeHotel = scanner.nextLine();
                        System.out.println("Quantas diárias?");
                        int diarias = Integer.parseInt(scanner.nextLine());
                        double precoNoite = 50;
                        System.out.println("Preço por noite: "+precoNoite+"R$");

                        System.out.println("Nome do passeio:");
                        String nomePasseio = scanner.nextLine();
                        double precoPasseio = 70;
                        System.out.println("Preço do passeio: "+precoPasseio+"R$");

                        Voo voo = new Voo(companhia, origem, cidade, precoVoo);
                        Hospedagem hospedagem = new Hospedagem(nomeHotel, diarias, precoNoite);
                        Passeio passeio = new Passeio(nomePasseio, precoPasseio);

                        List<ServicoContratavel> servicos = Arrays.asList(voo, hospedagem, passeio);

                        pacote = new PacoteTuristico(destino, servicos);
                        reserva = new Reserva(cliente1, pacote, pagamento);

                        System.out.println("Destino e pacote registrados com sucesso!");
                        System.out.println("-".repeat(50));
                    } else {
                        System.out.println("Destino já foi definido.");
                    }
                    break;

                case "4":
                    if (destino != null) {
                        System.out.println("-".repeat(50));
                        System.out.println("Destino selecionado: " + destino.getDescricao());
                        System.out.println("-".repeat(50));
                    }
                    break;

                case "0":
                    System.out.println("Encerrando...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
