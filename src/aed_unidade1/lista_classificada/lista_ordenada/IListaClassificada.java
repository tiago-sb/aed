package aed_unidade1.lista_classificada.lista_ordenada;

public interface IListaClassificada<T> {
	public T get (int i);

	public Cursor<T> procurarPosicao (T objetoEscolhido) throws Exception;

	public boolean eMembro(T objetoEscolhido);

	public void inserir (T objetoEscolhido) throws Exception;

	public void remover (T objetoEscolhido) throws Exception;

	public T procurar (T objetoEscolhido);
}
