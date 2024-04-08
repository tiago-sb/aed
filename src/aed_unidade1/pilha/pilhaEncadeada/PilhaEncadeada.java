package aed_unidade1.pilha.pilhaEncadeada;

import aed_unidade1.pilha.listaEncadeada.ListaEncadeada;

public class PilhaEncadeada<Tipo> implements IPilha<Tipo> {
	private ListaEncadeada<Tipo> lista;
	private int numeroItens;
	
	public PilhaEncadeada() {
		lista = new ListaEncadeada<Tipo>();
		this.numeroItens = 0;
	}
	
	public void fazVazia () {
		lista.fazVazia();
		this.numeroItens = 0;
	}

	public boolean estaVazia() {
		return numeroItens == 0;
	}
	
	public Tipo getTop() throws Exception {
		if(numeroItens == 0) {
			throw new Exception();
		}		
		
		return lista.getHeadValue();
	}

	public int getTamanho() {
		return this.numeroItens;
	}
	
	public void push(Tipo item) {
		this.numeroItens = this.numeroItens + 1;
		lista.inserirInicio(item);
	}

	public Tipo pop() throws Exception {
		if(this.numeroItens == 0) {
			throw new Exception();
		}
		
		lista.extrair(lista.getHeadValue());
		this.numeroItens = this.numeroItens - 1;
		return lista.getHeadValue();
	}

	public void extrair(Tipo item) throws Exception {
		this.numeroItens = this.numeroItens - 1;
		lista.extrair(item);
	}
}
