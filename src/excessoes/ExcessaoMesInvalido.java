package excessoes;

public class ExcessaoMesInvalido extends RuntimeException {
    public ExcessaoMesInvalido() {
        super("Ao registrar uma data, foi verificado que o mês está inválido.");
    }

}