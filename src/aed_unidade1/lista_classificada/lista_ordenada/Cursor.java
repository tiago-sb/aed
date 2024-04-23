package aed_unidade1.lista_classificada.lista_ordenada;

public class Cursor<T> implements ICursor<T>{
	
	ListaClassificada<T>.Element<T> elemento;
	
	public Cursor(ListaClassificada<T>.Element<T> elemento){	
		this.elemento = elemento;
	}
	
	public Cursor() {}
	
	public T getDado() {
		return elemento.getData();
	}
	
	public ListaClassificada<T>.Element<T> getElemento(){
		return this.elemento;
	}
}