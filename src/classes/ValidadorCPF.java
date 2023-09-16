package classes;

public class ValidadorCPF {
    public static boolean isCPF(String CPF) {
	    // considera-se erro CPF's formados por uma sequencia de numeros iguais
	    if (CPF.equals("00000000000") || CPF.equals("11111111111") || 
	    	CPF.equals("22222222222") || CPF.equals("33333333333") || 
	    	CPF.equals("44444444444") || CPF.equals("55555555555") ||
	        CPF.equals("66666666666") || CPF.equals("77777777777") ||
	        CPF.equals("88888888888") || CPF.equals("99999999999") ||
	        CPF.length() != 11) return(false);
	
	    char digitoDez, digitoOnze;
	    int soma, resto, auxiliar, peso;
	
	    // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
	    try {
		    // Calculo do 1o. Digito Verificador
	        soma = 0;
	        peso = 10;
	        for (int i=0; i<9; i++) {
			    // converte o i-esimo caractere do CPF em um numero:
			    // por exemplo, transforma o caractere '0' no inteiro 0
			    // (48 eh a posicao de '0' na tabela ASCII)
		        auxiliar = (int)(CPF.charAt(i) - 48);
		        soma = soma + (auxiliar * peso);
		        peso = peso - 1;
	        }
	
	        resto = 11 - (soma % 11);
	        if ((resto == 10) || (resto == 11))
	            digitoDez = '0';
	        
	        else digitoDez = (char)(resto + 48); // converte no respectivo caractere numerico
	
	        // Calculo do 2o. Digito Verificador
	        soma = 0;
	        peso = 11;
	        for(int i=0; i<10; i++) {
		        auxiliar = (int)(CPF.charAt(i) - 48);
		        soma = soma + (auxiliar * peso);
		        peso = peso - 1;
	        }
	
	        resto = 11 - (soma % 11);
	        if ((resto == 10) || (resto == 11))
	             digitoOnze = '0';
	        else digitoOnze = (char)(resto + 48);
	
	        // Verifica se os digitos calculados conferem com os digitos informados.
	        if ((digitoDez == CPF.charAt(9)) && (digitoOnze == CPF.charAt(10)))
	             return(true);
	        
	        else return(false);
	        
        } catch (Exception erro) {
			return(false);
        }
    }
}