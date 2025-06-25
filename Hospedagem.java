package GranTurismoJava;

public class Hospedagem implements ServicoContratavel {
    private String nomeHotel;
    private int diarias;
    private double precoPorNoite;

    public Hospedagem(String nomeHotel, int diarias, double precoPorNoite) {
        this.nomeHotel = nomeHotel;
        this.diarias = diarias;
        this.precoPorNoite = precoPorNoite;
    }

    @Override
    public String getDescricaoServico() {
        return "Hospedagem em " + nomeHotel + " por " + diarias + " noites";
    }

    @Override
    public double getPreco() {
        return diarias * precoPorNoite;
    }
}
