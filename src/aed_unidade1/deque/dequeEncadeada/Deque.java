package aed_unidade1.deque.dequeEncadeada;

import aed_unidade1.deque.dequeEncadeada.lista_simples.ListaSimples;

public class Deque<T> implements IDeque<T>{
	private ListaSimples<T> fila;
	private int numeroElementos;
	
	public Deque() {
		fila = new ListaSimples<T>();
		this.numeroElementos = 0;
	}
	
	public void fazVazia() {
		fila.fazVazia();
		this.numeroElementos = 0;
	}

	public boolean estaVazia() {
		return fila.estaVazia();
	}

	public T getPrimeiro() throws Exception {
		if(fila.estaVazia()) {
			throw new Exception();
		}
		
		return fila.getHeadValue();
	}

	public T getUltimo() throws Exception {
		if(fila.estaVazia()) {
			throw new Exception();
		}
		
		return fila.getTailValue();
	}

	public void enfileirarInicio(T itemEscolhido) {
		fila.inserirInicio(itemEscolhido);
		this.numeroElementos = this.numeroElementos + 1;
	}

	public void enfileirarFim(T itemEscolhido) {
		fila.inserirFim(itemEscolhido);
		this.numeroElementos = this.numeroElementos + 1;
	}

	public T desenfileirarInicio() throws Exception {
		T primeiroElemento = getPrimeiro();
		fila.extrair(primeiroElemento);
		
		this.numeroElementos = this.numeroElementos - 1;
		
		return primeiroElemento;
	}

	public T desenfileirarFim() throws Exception {
		T ultimoElemento = getUltimo();
		fila.extrair(ultimoElemento);
		
		this.numeroElementos = this.numeroElementos - 1;
		
		return ultimoElemento;
	}
	
	public void imprimir() {
		fila.imprimirLista();
	}
}
