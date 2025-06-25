package GranTurismoJava;

public class Passeio implements ServicoContratavel {
    private String nomePasseio;
    private double precoPasseio;

    public Passeio(String nomePasseio, double precoPasseio) {
        this.nomePasseio = nomePasseio;
        this.precoPasseio = precoPasseio;
    }

    @Override
    public String getDescricaoServico() {
        return "Passeio: " + nomePasseio;
    }

    @Override
    public double getPreco() {
        return precoPasseio;
    }
}
