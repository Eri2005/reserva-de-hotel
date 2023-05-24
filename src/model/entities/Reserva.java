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
	
	
	// Agora delegar a logica de validação da reserva para a classe Reserva
	
	public Reserva(Integer numeroQuarto, Date entrada, Date saida) {
		
		/*
		 *  Colocando o tratamento de excecao no construtor caso a data de "saida" for depois da date de "entrada"
		 *  Isso se chama programação Defensiva (boa prática)
		 *  Vai da o mesmo erro de de lancamento de excecao
		 *  É só adicionar no construtor
		 *  
		 *  public Reserva(Integer numeroQuarto, Date entrada, Date saida) {
		 *  public Reserva(Integer numeroQuarto, Date entrada, Date saida) throws ExcecaoDominio {
		 *  
		 *  Esse erro é ocasionado por causa que na classe ExcecaoDominio
		 *  Foi dado como extends "Exception"
		 *  
		 *  Se usar o "RunTimeException" não será necessario declarar "throws ExcecaoDominio"
		 *  Colocarei com RunTimexception
		 */
		
		
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
	
	// Esse método estara usando uma formula do Java 7 para calculo diferenças entre Datas
	// Depois mudar conforme o Java 8 (LocaDate, LocalDateTime, Instant)
	public long duracao() {
		// Vai trazer a diferenca entre as datas em milisegundos
		long  diferenca = saida.getTime() - entrada.getTime();
		
		// Convertendo o milisegundos em dias
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}

	public void atualizarDatas(Date entrada, Date saida) {
		
		// Verificar o momento de atualizar as datas se estao no Passado (anterior a data atual)
		Date agora = new Date();
		if (entrada.before(agora) || saida.before(agora)) {
			
			/*
			 * Agora para lança uma execeção caso a condição ocorra
			 * Tem que colocar a palavra throw 
			 * E na frente tem que instanciar uma exceção
			 * IllegalArgumentException => É uma classe do Java de quando os argumentos passado para o método são Invalidos
			 *  Vai mostrar um erro ExcecaoDominio
			 *  Para resolver tenho que colocar ele na chamada desse método "throws ExcecaoDominio"
			 *  public void atualizarDatas(Date entrada, Date saida) {
			 *  public void atualizarDatas(Date entrada, Date saida) throws ExcecaoDominio {
			 *  
			 *  Assim esse método pode lançar uma Exceção
			 */
			throw new ExcecaoDominio("As datas da reserva para atualização devem ser datas futuras");
			
		// Verificando se a data de entrada não e posterior a data de saida
		} 
		if (!saida.after(entrada)) {
			throw new ExcecaoDominio("Error na Reserva: data de saida deve ser posterior a data de entrada");
			
		}
		
		// Passando pelo o dois IF's
		// Ela vai cair nessa logica de atualizar as datas
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
