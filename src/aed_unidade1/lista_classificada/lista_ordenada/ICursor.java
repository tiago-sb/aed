package aed_unidade1.lista_classificada.lista_ordenada;

public interface ICursor<T> {
	public T getDado();
	
	public ListaClassificada<T>.Element<T> getElemento();
}
