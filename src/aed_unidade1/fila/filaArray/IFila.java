package aed_unidade1.fila.filaArray;

public interface IFila<T> {
	public void fazVazia();
	
	public boolean estaVazia();
	
	public T getPrimeiro() throws Exception;
	
	public void enfileirar(T itemEscolhido) throws Exception;
	
	public T desenfileirar() throws Exception;
}
