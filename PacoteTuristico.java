package GranTurismoJava;

import java.util.List;

public class PacoteTuristico {
    private Destino destino;
    private List<ServicoContratavel> servicos;

    public PacoteTuristico(Destino destino, List<ServicoContratavel> servicos) {
        this.destino = destino;
        this.servicos = servicos;
    }

    public double getPrecoTotal() {
        return servicos.stream().mapToDouble(ServicoContratavel::getPreco).sum();
    }

    public String getDescricaoPacote() {
        StringBuilder sb = new StringBuilder("Destino: " + destino.getDescricao() + "\nServiços:\n");
        for (ServicoContratavel s : servicos) {
            sb.append("- ").append(s.getDescricaoServico()).append(" (R$ ").append(s.getPreco()).append(")\n");
        }
        return sb.toString();
    }
}
