package excecoes;

public class ExcecaoSomenteLetrasPermitidas extends RuntimeException{
	public ExcecaoSomenteLetrasPermitidas() {
		super("Neste campo não são permitidos caracteres especiais ou números, somente letras.");
	}
}
