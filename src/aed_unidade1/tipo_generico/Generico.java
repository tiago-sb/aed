package aed_unidade1.tipo_generico;

/**
 * Classe para representar os tipos genericos
 * @param <Tipo>
 * @author Tiago Bela
 */
public class Generico<Tipo> {
	public Tipo data;
	
	/**
	 * Metodo Construtor para inicializar a Classe
	 * @param data: O novo valor da variavel 
	 */
	public Generico(Tipo data) {
		this.data = data;
	}
	
	/**
	 * Metodo Construtor para inicializar a Classe
	 * @param  vazio
	 */
	public Generico() {
		this.data = null;
	}
	
	/**
	 * Metodo para retornar o valor contido no objeto atualmente
	 * @param vazio
	 */
	public Tipo getData() {
		return this.data;
	}
	
	/**
	 * Metodo para trocar o valor contido no objeto atualmente
	 * @param data: O novo valor da variavel 
	 */
	public void setData(Tipo data) {
		this.data = data;
	}
	
	/**
	 * Metodo para retornar uma String com o valor da variavel data atualmente
	 * @param vazio
	 */
	public String valorDoGenerico() {
		return "O generico agora tem valor " + this.data;
	}
}
