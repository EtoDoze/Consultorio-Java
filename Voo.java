package GranTurismoJava;

// classe do voo com os atributos e métodos
public class Voo {
    String companhiaAerea; // nome da cia
    String origem; // de onde sai
    String destinoVoo; // pra onde vai
    double precoPassagem; // preço

    public Voo(String companhiaAerea, String origem, String destinoVoo, double precoPassagem) {
        this.companhiaAerea = companhiaAerea;
        this.origem = origem;
        this.destinoVoo = destinoVoo;
        this.precoPassagem = precoPassagem;
    }

    public String getDescricaoServico() {
        // yan, isso retorna uma string com a descrição do serviço do voo
        return "Voo de " + origem + " para " + destinoVoo + " pela " + companhiaAerea;
    }

    public double getPreco() {
        return precoPassagem; // só retorna
    }
}