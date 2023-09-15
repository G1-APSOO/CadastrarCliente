package excecoes;

public class ExcecaoSomenteNumerosPositivosPermitidos extends RuntimeException {
	public ExcecaoSomenteNumerosPositivosPermitidos() {
		super("Somente numeros positivos são aceitos.");
	}
}
