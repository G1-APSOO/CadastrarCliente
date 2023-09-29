package excecoes;

public class ExcecaoEmailInvalido extends RuntimeException {
	public ExcecaoEmailInvalido() {
		super("O email informado está inválido!");
	}
}
