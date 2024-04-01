package aed_unidade1.tipo_generico;

/**
 * Classe principal da aplicacao que contem o metodo main
 * @since 01.04.2024
 * @author Tiago Santos Bela
 */
public class Principal {
	/**
	 * Metodo main:
	 * Metodo principal de toda a aplicacao
	 * @param args vetor de argumentos
	 */
	public static void main(String[] args) {
		// instanciando um objeto do tipo String utilizando a estrutura dos tipos genericos
		Generico<String> exemplo01 = new Generico<String>("Tiago");
		// metodo para imprimir uma string contendo o valor do Generico
		System.out.println(exemplo01.valorDoGenerico());

		// instanciando um objeto do tipo Integer utilizando a estrutura dos tipos genericos
		Generico<Integer> exemplo02 = new Generico<Integer>(12);
		// metodo para imprimir uma string contendo o valor do Generico
		System.out.println(exemplo02.valorDoGenerico());
		
		// instanciando um objeto do tipo Boolean utilizando a estrutura dos tipos genericos
		Generico<Boolean> exemplo03 = new Generico<Boolean>(false);
		// metodo para imprimir uma string contendo o valor do Generico
		System.out.println(exemplo03.valorDoGenerico());
	}
}
