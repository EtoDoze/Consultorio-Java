package GranTurismo;

public class Pessoa {
    private String nome;
    private String email;

    // Métodos get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Pessoa(String nome, String email){
        this.nome = nome;
        this.email = email;

    }

    public void exibirInfo(){
        System.out.println("Nome: "+ nome);
        System.out.println("Email: "+ email);
    }
}