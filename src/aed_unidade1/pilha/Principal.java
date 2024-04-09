package aed_unidade1.pilha;

import aed_unidade1.pilha.pilhaEncadeada.PilhaEncadeada;

/**
 * Classe Principal de toda a aplicacao que 
 * contem o metodo main e testa os metodos
 * da pilha implementada
 * @author Tiago Santos Bela
 * @since 03.04.2024
 */
public class Principal {
	/**
	 * metodo main
	 * @param args : Vetor de argumentos
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// cria uma pilha de nomes do tipo String
		PilhaEncadeada<String> pilhaNomes = new PilhaEncadeada<String>();
		// metodo para empurrar uma String para a pilha encadeada
		pilhaNomes.push("tiago");
		// metodo para imprimir o item que se encontra no topo da pilha
		System.out.println(pilhaNomes.getTop());
		
		// metodo para empurrar uma String para a pilha encadeada
		pilhaNomes.push("jose");
		// metodo para imprimir o item que se encontra no topo da pilha
		System.out.println(pilhaNomes.getTop());

		// metodo para retirar uma String para a pilha encadeada		
		String nomeTirado = pilhaNomes.pop();
		// metodo para imprimir o numero de itens que se encontram na pilha
		System.out.println(pilhaNomes.getTamanho());
		// metodo para imprimir o item que se encontra no topo da pilha
		System.out.println(pilhaNomes.getTop());
	}
}
