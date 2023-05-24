package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {

		/*
		 * Criar métodos de tratamento de execeções retornando uma String 
		 * É a forma ainda errada de tratar erros ou execeçoes 
		 * Considerada o método Ruim 
		 * Agora delegar a logica de validação da reserva para a classe Reserva
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

			// Criando uma variavel do tipo String para receber o "reserva.atualizarDatas"
			// E essa String vai retornar se houve um erro ou nao
			String erro = reserva.atualizarDatas(entrada, saida);

			// Criando uma logica para comparar se veio alguma String contendo Erro
			if (erro != null) {
				System.out.println("Error na Reserva: " + erro);
			} else {
				System.out.println("Reserva: " + reserva);
			}
		}

		sc.close();
	}
}
