package GranTurismo;

public class servicoContratavel {
    public interface ServicoContratavel {
        void contratar();
        void cancelar();
        double calcularPreco();
    }
}
