package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Exceptions.ExcecaoDominio;
import model.entities.Reserva;

public class Program {

	public static void main(String[] args) {

		/*
		 * Criar métodos de tratamento de execeções retornando uma String 
		 * É a forma ainda errada de tratar erros ou execeçoes 
		 * Considerada o método Ruim 
		 * Agora delegar a logica de validação da reserva para a classe Reserva
		 */

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do Quarto: ");
			int numero = sc.nextInt();
	
			System.out.print("Data de Entrada (dd/MM/yyyy): ");
			Date entrada = dataFormatada.parse(sc.next());
	
			System.out.print("Data de Saida (dd/MM/yyyy): ");
			Date saida = dataFormatada.parse(sc.next());
	
			
			/*
			 *  Instanciando
			 *  Legal que o construtor esta dentro do bloco Try
			 *  Se acontencer uma excecao no construtor 
			 *  Da mesma forma o bloco try vai ser interrompido
			 *  E vai cair no bloco catch
			 */
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("Reserva: " + reserva);
	
			System.out.println();
			System.out.println("Digite a data para atualizar a reserva: ");
	
			System.out.print("Data de Entrada (dd/MM/yyyy): ");
			entrada = dataFormatada.parse(sc.next());
	
			System.out.print("Data de Saida (dd/MM/yyyy): ");
			saida = dataFormatada.parse(sc.next());
	
			
			/*
			 *  Agora aqui vai mostrar um erro
			 *  Alertando que tem uma exceção que noa foi tratada
			 *  É só alterar o tipo de  Excecao no catch logo abaixo
			 *  
			 *  catch (IllegalArgumentException e) {
			 *  catch (ExcecaoDominio e) {
			 *  
			 */
			reserva.atualizarDatas(entrada, saida);
			System.out.println("Reserva: " + reserva);

		} 
		catch (ParseException e) {
			System.out.println("Data no formato invalido");
		
		} 
		// Acrescentando outro bloco capturando o tipo de exceção que esta na classe Reserva
		catch (ExcecaoDominio e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		// Esse tipo de erro é generico
		// Para que fazer o UPCASTING para RuntimeException
		// E mostrar a mensagem de erro
		// Posso colocar qualquer informação de erro
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		sc.close();
	}
}
