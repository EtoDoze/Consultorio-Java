package GranTurismo;

public class ServicoContratavel {
    public interface ServicoContratavel {
        void contratar();
        void cancelar();
        double calcularPreco();
    }
}
