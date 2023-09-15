package excecoes;

public class ExcecaoClienteMuitoAntigo extends RuntimeException {
    public ExcecaoClienteMuitoAntigo() {
        super("Ao registrar uma data, foi verificado que o ano informado passa de 100 anos atrás, por medidas de segurança recusaremos o registro.");
    }

}