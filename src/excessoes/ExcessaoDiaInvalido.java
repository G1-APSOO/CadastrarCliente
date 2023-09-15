package excessoes;

public class ExcessaoDiaInvalido extends RuntimeException {
    public ExcessaoDiaInvalido() {
        super("Ao registrar uma data, foi verificado que o dia está invalido");
    }
}