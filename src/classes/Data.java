package classes;
import excessoes.ExcessaoClienteMuitoAntigo;
import excessoes.ExcessaoClienteMuitoNovo;
import excessoes.ExcessaoDiaInvalido;
import excessoes.ExcessaoMesInvalido;
import excessoes.ExcessaoParametroVazio;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano)  
    throws ExcessaoParametroVazio,
    	ExcessaoDiaInvalido,
    	ExcessaoMesInvalido,
        ExcessaoClienteMuitoAntigo,
        ExcessaoClienteMuitoNovo {

        setAno(ano);
        setMes(mes);
        setDia(dia);
    }

    private void setDia(int dia) throws ExcessaoParametroVazio, ExcessaoDiaInvalido {
    	
    	if (dia <= 0) {
    		throw new ExcessaoParametroVazio("dia");
    	}

        verificaDia(dia, this.mes, this.ano);

        this.dia = dia;
    }

    private void setMes(int mes) throws ExcessaoMesInvalido {
    	
        if (mes > 12 || mes < 0) {
            throw new ExcessaoMesInvalido();
        }

        this.mes = mes;
    }

    private void setAno(int ano) 
    throws ExcessaoParametroVazio,
    	ExcessaoClienteMuitoNovo, 
    	ExcessaoClienteMuitoAntigo {
    	
    	if (ano <= 0) {
    		throw new ExcessaoParametroVazio("ano");
    	}

        int anoAtual = LocalDate.now().getYear();

        // Condição: 
        // 1: Ter + de 18 anos
        // 2: Ter - de 100 anos (Evitando umas loucuras tipo nasci em 1800)
        if (ano > (anoAtual-18)) throw new ExcessaoClienteMuitoNovo();
        else if ((anoAtual-100) < ano) throw new ExcessaoClienteMuitoAntigo();
        
        this.ano = ano;
    }

    private void verificaDia(int dia, int mes, int ano) throws ExcessaoDiaInvalido {

        GregorianCalendar calendario = new GregorianCalendar();
        calendario.set(Calendar.YEAR, ano);
        calendario.set(Calendar.MONTH, mes);

        if (dia > calendario.getActualMaximum(Calendar.DAY_OF_MONTH)) throw new ExcessaoDiaInvalido();

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