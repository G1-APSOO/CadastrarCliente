package excecoes;

public class ExcecaoParametroVazio extends RuntimeException {
	public ExcecaoParametroVazio(String msg) {
		super("O parâmetro " + msg + " foi enviado vazio.");
	}
}
