package excessoes;

public class ExcessaoSomenteNumerosPositivosPermitidos extends RuntimeException {
	public ExcessaoSomenteNumerosPositivosPermitidos() {
		super("Somente numeros positivos são aceitos.");
	}
}
