package excecoes;

public class ExcecaoDiaInvalido extends RuntimeException {
    public ExcecaoDiaInvalido() {
        super("Ao registrar uma data, foi verificado que o dia está invalido");
    }
}