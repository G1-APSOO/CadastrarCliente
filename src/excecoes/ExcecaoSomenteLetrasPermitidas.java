package excecoes;

public class ExcecaoSomenteLetrasPermitidas extends RuntimeException{
	public ExcecaoSomenteLetrasPermitidas(String campo) {
		super("No campo " + campo + " não são permitidos caracteres especiais ou números, somente letras.");
	}
}
