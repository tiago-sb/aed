package aed_unidade1.lista_encadeada;

import aed_unidade1.lista_encadeada.lista_simples.ListaEncadeada;

/**
 * Classe para testes do pacote lista encadeada
 * @author Tiago Santos Bela
 * @since 08.04.2024
 */
public class Principal {
	public static void main(String[] args) throws Exception {
		ListaEncadeada<String> lista = new ListaEncadeada<String>();
		
		// adicionar tiago e anna na lista
		lista.inserirInicio("tiago");
		lista.inserirFim("anna");
		
		// testar se a lista esta vazia ou nao
		// caso esteja, o resultado esperado eh true, caso nao, o resultado esperado eh false
		System.out.println(lista.estaVazia());
		
		// metodo para buscar o elemento que se encontra no head da lista
		System.out.println(lista.getHeadValue());
		
		// metodo para buscar o elemento que se encontra na calda da lista
		System.out.println(lista.getTailValue());
		
		// extrair o nome anna da lista
		lista.extrair("anna");
		
		System.out.println(lista.getTailValue());
		
		lista.inserirFim("paulo");
		lista.inserirFim("lucio");
		lista.inserirFim("andre");
		lista.inserirFim("marcos paulo");
		
		// metodo para imprimir os elementos presentes na lista
		lista.imprimirLista();
		// extrair o nome andre da lista
		lista.extrair("andre");
		
		// metodo para imprimir os elementos presentes na lista
		lista.imprimirLista();
	}
}
