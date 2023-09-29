package excecoes;

public class ExcecaoSomenteNumerosPositivosPermitidos extends RuntimeException {
	public ExcecaoSomenteNumerosPositivosPermitidos() {
		super("Somente números positivos são aceitos.");
	}
}
