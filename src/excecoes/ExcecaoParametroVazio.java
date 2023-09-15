package excecoes;

public class ExcecaoParametroVazio extends RuntimeException {
	public ExcecaoParametroVazio(String msg) {
		super("O parametro " + msg + " foi enviado vazio.");
	}
}
