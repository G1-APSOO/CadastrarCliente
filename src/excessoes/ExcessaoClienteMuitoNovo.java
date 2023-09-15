package excessoes;

public class ExcessaoClienteMuitoNovo extends RuntimeException {
    public ExcessaoClienteMuitoNovo() {
        super("Ao registrar uma data, foi verificado que o usuário é muito novo para o nosso sistema o usuário deve ter no minimo 18 anos.");
    }
}