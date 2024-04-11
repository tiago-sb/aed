package aed_unidade1.fila.filaArray;

public class FilaArray<T> implements IFila<T> {
	private T[] array;
	private int head;
	private int tail;
	private int numeroElementos;

	@SuppressWarnings("unchecked")
	public FilaArray (int tamanhoFila){
		array = (T[]) new Object[tamanhoFila];
		head = 0;
		tail = tamanhoFila - 1;
		numeroElementos = 0;
	}
	
	/**
	 * metodo para retirar todos elementos do vetor
	 * e redimencionar as variaveis head e numeroElementos
	 * para zero
	 */
	public void fazVazia() {
		while (this.numeroElementos > 0) {
			array[head] = null;
			
			this.head = this.head + 1;
			if (head == array.length) {
				this.head = 0;
			}
			this.numeroElementos = this.numeroElementos - 1;
		}
	}
	
	/**
	 * metodo para testar se a fila contem elementos
	 */
	public boolean estaVazia() {
		return this.numeroElementos == 0;
	}
	
	/**
	 * metodo que retorna o elemento que esta na cabeca da fila
	 */
	public T getPrimeiro() throws Exception {
		if(numeroElementos == 0) {
			throw new Exception(); // implementar depois a excecao ContainerExceptionException
		}
		
		return array[head];
	}
	
	/**
	 * metodo para inserir novo elemento no fim da fila
	 */
	public void enfileirar(T itemEscolhido) throws Exception {
		if (this.numeroElementos == array.length) {
			throw new Exception(); // implementar depois a excecao ContainerExceptionException
		}
		
		this.tail = this.tail + 1;
		if (tail == array.length) {
			tail = 0;
		}
		
		array [tail] = itemEscolhido;

		this.numeroElementos = this.numeroElementos + 1;
	}
	
	public T desenfileirar() throws Exception {
		if (this.numeroElementos == 0) {
			throw new Exception();
		}
		
		T resultado = array[head];
		array[head] = null;

		this.head = this.head + 1;
		if (head == array.length) {
			this.head = 0;	
		}
		
		this.numeroElementos = this.numeroElementos - 1;
		
		return resultado;
	}
	
	public void imprimirFila() {
		for(int indice = 0; indice < array.length; indice++) {
			if(this.array[indice] != null) {
				if(this.array[indice].equals(this.array[tail])) {
					System.out.println(array[indice] + ".");
				}
				if(!this.array[indice].equals(this.array[tail])) {
					System.out.print(array[indice] + ", ");
				}	
			}
		}
	}
}