package aed_unidade1.deque.dequeEncadeada.lista_simples;

public interface IListaSimples<T> {
	public T getHeadValue() throws Exception;
	
	public T getTailValue() throws Exception;
	
	public boolean estaVazia();
	
	public int tamanhoLista();
	
	public void inserirInicio(T itemEscolhido);
	
	public void extrair(T itemEscolhido) throws Exception;
	
	public void atribuir(ListaSimples<T> novaLista);
	
	public void imprimirLista();
}
