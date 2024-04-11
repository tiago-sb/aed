package aed_unidade1.deque.dequeEncadeada;

public interface IDeque<T> {
	public void fazVazia();

	public boolean estaVazia();

	public T getPrimeiro() throws Exception;

	public T getUltimo() throws Exception;

	public void enfileirarInicio(T itemEscolhido);

	public void enfileirarFim(T itemEscolhido);

	public T desenfileirarInicio() throws Exception;

	public T desenfileirarFim() throws Exception;
}
