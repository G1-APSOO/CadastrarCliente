package excecoes;

public class ExcecaoMesInvalido extends RuntimeException {
    public ExcecaoMesInvalido() {
        super("Ao registrar uma data, foi verificado que o mês está inválido.");
    }

}