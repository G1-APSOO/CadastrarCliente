package excessoes;

public class ExcessaoTelefoneInvalido extends RuntimeException {
	public ExcessaoTelefoneInvalido() {
		super("O telefone não está no formato brasileiro.");
	}
}
