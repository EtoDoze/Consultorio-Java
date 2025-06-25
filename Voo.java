package GranTurismoJava;

public class Voo implements ServicoContratavel {
    private String companhiaAerea;
    private String origem;
    private String destinoVoo;
    private double precoPassagem;

    public Voo(String companhiaAerea, String origem, String destinoVoo, double precoPassagem) {
        this.companhiaAerea = companhiaAerea;
        this.origem = origem;
        this.destinoVoo = destinoVoo;
        this.precoPassagem = precoPassagem;
    }

    @Override
    public String getDescricaoServico() {
        return "Voo com " + companhiaAerea + " de " + origem + " para " + destinoVoo;
    }

    @Override
    public double getPreco() {
        return precoPassagem;
    }
}
