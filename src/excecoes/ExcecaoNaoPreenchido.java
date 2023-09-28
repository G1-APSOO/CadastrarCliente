package excecoes;

public class ExcecaoNaoPreenchido extends RuntimeException {
	public ExcecaoNaoPreenchido(String msg) {
		super(msg + "!");
	}
}
