package aed_unidade1.fila.filaEncadeada;

import aed_unidade1.fila.filaArray.IFila;
import aed_unidade1.fila.filaEncadeada.lista_simples.ListaEncadeada;

public class FilaEncadeada<T> implements IFila<T> {
	private ListaEncadeada<T> lista;
	private int numeroElementos;

	public FilaEncadeada() {
		lista = new ListaEncadeada<T>();
		this.numeroElementos = 0;
	}
	
	public void fazVazia() {
		lista.fazVazia();
		this.numeroElementos = 0;
	}
	
	public boolean estaVazia() {
		return lista.estaVazia();
	}
	
	public T getPrimeiro () throws Exception {
		if (lista.estaVazia()) {
			throw new Exception();
		}
		
		return lista.getHeadValue();
	}
	
	public void enfileirar (T novoItem) {
		lista.inserirFim(novoItem);
		this.numeroElementos = this.numeroElementos + 1;
	}
	
	public T desenfileirar() throws Exception {
		if (lista.estaVazia()) {
			throw new Exception();
		}
		
		T resultado = lista.getHeadValue();
		lista.extrair(resultado);

		this.numeroElementos = this.numeroElementos - 1;

		return resultado;
	}
	
	public void imprimir() {
		lista.imprimirLista();
	}
}
