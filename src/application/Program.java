package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Exceptions.ExcecaoDominio;
import model.entities.Reserva;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do Quarto: ");
			int numero = sc.nextInt();
	
			System.out.print("Data de Entrada (dd/MM/yyyy): ");
			Date entrada = dataFormatada.parse(sc.next());
	
			System.out.print("Data de Saida (dd/MM/yyyy): ");
			Date saida = dataFormatada.parse(sc.next());
	
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("Reserva: " + reserva);
	
			System.out.println();
			System.out.println("Digite a data para atualizar a reserva: ");
	
			System.out.print("Data de Entrada (dd/MM/yyyy): ");
			entrada = dataFormatada.parse(sc.next());
	
			System.out.print("Data de Saida (dd/MM/yyyy): ");
			saida = dataFormatada.parse(sc.next());
	
			reserva.atualizarDatas(entrada, saida);
			System.out.println("Reserva: " + reserva);

		} 
		catch (ParseException e) {
			System.out.println("Data no formato invalido");
		
		} 
		
		catch (ExcecaoDominio e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		sc.close();
	}
}
