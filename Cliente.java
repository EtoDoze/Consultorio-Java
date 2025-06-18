package GranTurismoJava;

public class Cliente extends Pessoa {
    private String cpf;

    public Cliente(String nome, String email, String cpf) {
        super(nome, email);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
