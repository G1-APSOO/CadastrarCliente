package excecoes;

public class ExcecaoAtributoVazio extends Exception{
	public ExcecaoAtributoVazio(String atributo) {
		super("O atributo " + atributo + " está atualmente vazio.");
	}
}
