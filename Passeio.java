package GranTurismoJava;

// classe do passeio
public class Passeio {
    String nomePasseio; // nome do passeio
    double precoPasseio; // preço

    public Passeio(String nomePasseio, double precoPasseio) {
        this.nomePasseio = nomePasseio;
        this.precoPasseio = precoPasseio;
    }

    public String getDescricaoServico() {
        // descrição simples
        return "Passeio: " + nomePasseio;
    }

    public double getPreco() {
        return precoPasseio; // retorna o preço
    }
}