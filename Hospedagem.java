package GranTurismoJava;

// classe de hospedagem
public class Hospedagem {
    String nomeHotel; // nome do hotel
    int diarias; // quantas noites
    double precoPorNoite; // preço unitário

    public Hospedagem(String nomeHotel, int diarias, double precoPorNoite) {
        this.nomeHotel = nomeHotel;
        this.diarias = diarias;
        this.precoPorNoite = precoPorNoite;
    }

    public String getDescricaoServico() {
        // descrição meio improvisada
        return diarias + " noites no hotel " + nomeHotel;
    }

    public double getPreco() {
        return diarias * precoPorNoite; // calcula o total
    }
}