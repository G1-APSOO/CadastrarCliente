package excecoes;

public class ExcecaoAnoInvalido extends RuntimeException {
    public ExcecaoAnoInvalido(String msg) {
        super("Ao registrar uma data, foi verificado que o usuário é " + msg + ".");
    }
}