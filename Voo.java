package GranTurismo;

public class Voo {
    private String CompanhiaAerea;
    private String origem;
    private String destinoVoo;
    private double precoPasagem;

    // Métodos get e set
    public String getCompanhiaAerea() {
        return CompanhiaAerea;
    }

    public void setCompanhiaAerea(String CompanhiaAerea) {
        this.CompanhiaAerea = CompanhiaAerea;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getdestinoVoo() {
        return destinoVoo;
    }

    public void setdestinoVoo(String destinoVoo) {
        this.destinoVoo = destinoVoo;
    }

    public double getPrecoPasagem() {
        return precoPasagem;
    }
    
    public void setPrecoPasagem(double precoPasagem) {
        this.precoPasagem = precoPasagem;
    }

    public Voo(String CompanhiaAerea, String origem, String destinoVoo, double precoPasagem) {
        this.CompanhiaAerea = CompanhiaAerea;
        this.origem = origem;
        this.destinoVoo = destinoVoo;
        this.precoPasagem = precoPasagem;
    }

    public void exibirInfo() {
        System.out.println("Companhia Aérea: " + CompanhiaAerea);
        System.out.println("Origem: " + origem);
        System.out.println("Destino do Voo: " + destinoVoo);
        System.out.println("Preço da Passagem: R$" + precoPasagem);
    }

    public String getDescricaoServico() {
        return "Voo de " + origem + " para " + destinoVoo + " operado por " + CompanhiaAerea + " com preço de R$" + precoPasagem;
    }

    public double getPreco() {
        return precoPasagem;
    }
    
}
