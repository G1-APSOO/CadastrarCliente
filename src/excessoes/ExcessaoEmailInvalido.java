package excessoes;

public class ExcessaoEmailInvalido extends RuntimeException {
	public ExcessaoEmailInvalido() {
		super("O email informado não é valido.");
	}
}
