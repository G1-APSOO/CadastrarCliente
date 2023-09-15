package excecoes;

public class ExcecaoSomenteLetrasPermitidas extends RuntimeException{
	public ExcecaoSomenteLetrasPermitidas() {
		super("Neste campo não é permitido caracteres especiais ou números, somente letras");
	}
}
