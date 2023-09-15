package excessoes;

public class ExcessaoCPFInvalido extends RuntimeException {
	public ExcessaoCPFInvalido() {
		super("O CPF é inválido, para prosseguir coloque um CPF válido");
	}
}
