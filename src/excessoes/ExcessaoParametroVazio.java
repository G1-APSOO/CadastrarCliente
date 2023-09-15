package excessoes;

public class ExcessaoParametroVazio extends RuntimeException {
	public ExcessaoParametroVazio(String msg) {
		super("O parametro " + msg + " foi enviado vazio.");
	}
}
