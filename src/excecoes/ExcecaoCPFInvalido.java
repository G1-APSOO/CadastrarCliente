package excecoes;

public class ExcecaoCPFInvalido extends RuntimeException {
	public ExcecaoCPFInvalido() {
		super("O CPF está inválido.");
	}
}
