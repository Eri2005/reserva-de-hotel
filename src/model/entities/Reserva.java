package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.Exceptions.ExcecaoDominio;

public class Reserva {

	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;

	private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date entrada, Date saida) {
		if (!saida.after(entrada)) {
			throw new ExcecaoDominio("Error na Reserva: data de saida deve ser posterior a data de entrada");
			
		}
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
	
	public long duracao() {
		// Vai trazer a diferenca entre as datas em milisegundos
		long  diferenca = saida.getTime() - entrada.getTime();

		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}

	public void atualizarDatas(Date entrada, Date saida) {

		Date agora = new Date();
		if (entrada.before(agora) || saida.before(agora)) {
			
			throw new ExcecaoDominio("As datas da reserva para atualização devem ser datas futuras");

		} 
		if (!saida.after(entrada)) {
			throw new ExcecaoDominio("Error na Reserva: data de saida deve ser posterior a data de entrada");
			
		}
		
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
