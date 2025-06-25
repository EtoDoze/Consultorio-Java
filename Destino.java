package GranTurismoJava;

public class Destino {
    private String nome;
    private String pais;

    public Destino(String nome, String pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    public String getDescricao() {
        return nome + " - " + pais;
    }
}
