public class Pessoa {
    private String cpf;
    private String nome;
    private String dataNascimento;

    // Métodos get e set
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void exibirInfo(){
        System.out.println("Nome: "+ nome);
        System.out.println("CPF: "+ cpf);
        System.out.println("Data de Nascimento: "+ dataNascimento);
    }
}