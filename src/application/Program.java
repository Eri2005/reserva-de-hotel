package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		/*
		 * Os métodos de tratamento de execeções sendo tratadas no progrma principal
		 * É a forma errada de tratar erros ou execeçoes
		 * Considerada o método Muito Ruim
		 * Onde nao esta tendo o tratamento de delegação de tratamento
		 * Para saber os detalhes da reserva é para ser a classe Reserva e nao outra classe
		 */
		
		Scanner sc = new Scanner(System.in);		
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do Quarto: ");
		int numero = sc.nextInt();
		
		System.out.print("Data de Entrada (dd/MM/yyyy): ");
		Date entrada = dataFormatada.parse(sc.next());
		
		System.out.print("Data de Saida (dd/MM/yyyy): ");
		Date saida = dataFormatada.parse(sc.next());
		
		// Verificando se a dat de entrada não e posterior a data de saida
		if (!saida.after(entrada)) {
			System.out.println("Error na Reserva: data de saida deve ser posterior a data de entrada");
			
		} else {
			// Instanciando
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Digite a data para atualizar a reserva: ");
			
			System.out.print("Data de Entrada (dd/MM/yyyy): ");
			entrada = dataFormatada.parse(sc.next());
			
			System.out.print("Data de Saida (dd/MM/yyyy): ");
			saida = dataFormatada.parse(sc.next());
			
			// Verificar o momento de atualizar as datas se estao no Passado (anterior a data atual)
			Date agora = new Date();
			if (entrada.before(agora) || saida.before(agora)) {
				System.out.println("Error na Reserva: as datas da reserva para atualização devem ser datas futuras");
				
			// Verificando se a data de entrada não e posterior a data de saida
			} else if (!saida.after(entrada)) {
				System.out.println("Error na Reserva: data de saida deve ser posterior a data de entrada");
				
			} else {
			
				reserva.atualizarDatas(entrada, saida);
				System.out.println("Reserva: " + reserva);
			}
		}
		
		
		sc.close();
	}

}
