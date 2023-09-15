package excessoes;

public class ExcessaoSomenteLetrasPermitidas extends RuntimeException{
	public ExcessaoSomenteLetrasPermitidas() {
		super("Neste campo não é permitido caracteres especiais ou números, somente letras");
	}
}
