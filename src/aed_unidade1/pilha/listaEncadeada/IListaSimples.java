package aed_unidade1.pilha.listaEncadeada;

public interface IListaSimples<T> {
	public T getHeadValue() throws Exception;
	
	public T getTailValue() throws Exception;
	
	public boolean estaVazia();
	
	public int tamanhoLista();
	
	public void inserirInicio(T itemEscolhido);
	
	public void extrair(T itemEscolhido) throws Exception;
	
	public void atribuir(ListaEncadeada<T> novaLista);
	
	public void imprimirLista();
}

