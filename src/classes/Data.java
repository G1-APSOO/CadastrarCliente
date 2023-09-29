package classes;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;


import excecoes.ExcecaoAnoInvalido;
import excecoes.ExcecaoDiaInvalido;
import excecoes.ExcecaoMesInvalido;
import excecoes.ExcecaoParametroVazio;

public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano)  
    throws ExcecaoParametroVazio,
    	ExcecaoDiaInvalido,
    	ExcecaoMesInvalido,
        ExcecaoAnoInvalido {
        setAno(ano);
        setMes(mes);
        setDia(dia);
    }

    private void setDia(int dia) throws ExcecaoParametroVazio, ExcecaoDiaInvalido {
    	
    	if (dia <= 0) {
    		throw new ExcecaoParametroVazio("dia");
    	}

        verificaDia(dia, this.mes, this.ano);

        this.dia = dia;
    }

    private void setMes(int mes) throws ExcecaoMesInvalido {
    	
        if (mes > 12 || mes < 0) {
            throw new ExcecaoMesInvalido();
        }

        this.mes = mes;
    }

    private void setAno(int ano) 
    throws ExcecaoParametroVazio,
    	ExcecaoAnoInvalido {
    	
    	if (ano <= 0) {
    		throw new ExcecaoParametroVazio("ano");
    	}

        int anoAtual = LocalDate.now().getYear();

        // Condição: 
        // 1: Ter + de 18 anos
        // 2: Ter - de 100 anos (Evitando umas loucuras tipo nasci em 1800)
        if (ano > (anoAtual-18)) throw new ExcecaoAnoInvalido("menor de 18 anos");
        else if ((anoAtual-100) < ano) throw new ExcecaoAnoInvalido("maior de 100 anos");
        
        this.ano = ano;
    }

    private void verificaDia(int dia, int mes, int ano) throws ExcecaoDiaInvalido {

        GregorianCalendar calendario = new GregorianCalendar();
        calendario.set(Calendar.YEAR, ano);
        calendario.set(Calendar.MONTH, mes);

        if (dia > calendario.getActualMaximum(Calendar.DAY_OF_MONTH)) throw new ExcecaoDiaInvalido();


        this.dia = dia;

    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }
    
    public String getData() {
		
    	String diaString, mesString, anoString;
    	
    	if (dia < 10) diaString = "0" + Integer.toString(dia);
    	else diaString = Integer.toString(dia);
    	
    	if (mes < 10) mesString = "0" + Integer.toString(mes);
    	else mesString = Integer.toString(mes);
    	
    	anoString = Integer.toString(ano);
    	
    	return diaString + "/" + mesString + "/" + anoString;
	}

}