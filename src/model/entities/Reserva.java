package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;

	private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
	
	
	// Agora delegar a logica de validação da reserva para a classe Reserva
	
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

	public String atualizarDatas(Date entrada, Date saida) {
		
		// Verificar o momento de atualizar as datas se estao no Passado (anterior a data atual)
		Date agora = new Date();
		if (entrada.before(agora) || saida.before(agora)) {
			return "As datas da reserva para atualização devem ser datas futuras";
			
		// Verificando se a data de entrada não e posterior a data de saida
		} 
		if (!saida.after(entrada)) {
			return "Error na Reserva: data de saida deve ser posterior a data de entrada";
			
		}
		
		this.entrada = entrada;
		this.saida = saida;
		
		// Esse return é o criterio de quando a logica nao retornar nenhum erro
		// Se de algum erro vai ficar na logica acima
		return null;
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
