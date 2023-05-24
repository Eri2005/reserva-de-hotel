package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;

	private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date entrada, Date saida) {
		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}
	
	// Esse método estara usando uma formula do Java 7 para calculo diferenças entre Datas
	// Depois mudar conforme o Java 8 (LocaDate, LocalDateTime, Instant)
	public long duracao() {
		// Vai trazer a diferenca entre as datas em milisegundos
		long  diferenca = saida.getTime() - entrada.getTime();
		
		// Convertendo o milisegundos em dias
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}

	public void atualizarDatas(Date entrada, Date saida) {
		this.entrada = entrada;
		this.saida = saida;
	}
	
	@Override
	public String toString() {
		return "Quarto " 
				+ numeroQuarto
				+ ", entrada: "
				+ dataFormatada.format(entrada)
				+ ", saida: "
				+ dataFormatada.format(saida)
				+ ", "
				+ duracao()
				+ " noites";
	}
}
