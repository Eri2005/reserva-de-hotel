package model.Exceptions;

/*
 * Essa classe é uma exceção lançada 
 * Por algum erro na entidade de Dominio 
 * Que é o Reserva
 * 
 * Por ser uma entidade de Dominio que pode lançar um erro
 * Por isso o nome de "ExcecaoDominio"
 * 
 * Essa classe vai extender da classe 
 * 	- Exception => É um tipo de excecao que o compilador obriga a voce tratar
 * 		- Igual a ParseException quando mostrar que a um erro.
 * 		- É o compilador reclamando que tem a tratar
 * 		- E ele é serializable (serializado)
 * 
 * 	- RuntimeException => É um tipo de excecao que o compilador não obriga a voce tratar
 * 
 * public class ExcecaoDominio extends RuntimeException
 * - Vai esta reclamando por causa que essa classe "ExcecaoDominio" é serializable (serializado)
 * - E ela precisa ter um numero de versão
 * - Então irei adicionar "serial verion ID"
 * 		- private static final long serialVersionUID = 1L;
 */
public class ExcecaoDominio extends RuntimeException {

	// Declarada a versao de uma classe serializable
	private static final long serialVersionUID = 1L;
	
	/*
	 * Acrescentando um construtor que recebe uma String como argumento
	 * Foi criada para que possa ser instanciada "ExcecaoDominio" 
	 * Passando uma mensagem para ela
	 */
	public ExcecaoDominio(String msg) {
		// Repassando essa mensagem para o construtor da Superclasse
		super(msg);
	}
	
}
