package excecoes;

public class ExcecaoTelefoneInvalido extends RuntimeException {
	public ExcecaoTelefoneInvalido() {
		super("O telefone não está no formato brasileiro.");
	}
}
