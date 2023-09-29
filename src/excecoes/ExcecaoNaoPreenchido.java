package excecoes;

public class ExcecaoNaoPreenchido extends RuntimeException {
	public ExcecaoNaoPreenchido(String msg) {
		super("O campo "+ msg + " não está preenchido!");
	}
}
