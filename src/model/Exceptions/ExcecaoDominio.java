package model.Exceptions;

/*
 * Essa classe � uma exce��o lan�ada 
 * Por algum erro na entidade de Dominio 
 * Que � o Reserva
 * 
 * Por ser uma entidade de Dominio que pode lan�ar um erro
 * Por isso o nome de "ExcecaoDominio"
 * 
 * Essa classe vai extender da classe 
 * 	- Exception => � um tipo de excecao que o compilador obriga a voce tratar
 * 		- Igual a ParseException quando mostrar que a um erro.
 * 		- � o compilador reclamando que tem a tratar
 * 		- E ele � serializable (serializado)
 * 
 * 	- RuntimeException => � um tipo de excecao que o compilador n�o obriga a voce tratar
 * 
 * public class ExcecaoDominio extends RuntimeException
 * - Vai esta reclamando por causa que essa classe "ExcecaoDominio" � serializable (serializado)
 * - E ela precisa ter um numero de vers�o
 * - Ent�o irei adicionar "serial verion ID"
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
