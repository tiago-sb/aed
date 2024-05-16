package aed_unidade2.arvores.arvore_binaria;

import aed_unidade2.arvores.arvore_binaria.node.Node;

public class Principal {
	public static void main(String[] args) {
		// teste para numeros inteiros
		Node<Integer> arvoreNumeros = new Node<>(500);
		arvoreNumeros.inserirOrdenado(300); arvoreNumeros.inserirOrdenado(150);
		arvoreNumeros.inserirOrdenado(700); arvoreNumeros.inserirOrdenado(400);
		
		arvoreNumeros.imprimeInOrdem();
		System.out.println();
		
		arvoreNumeros.imprimeEmPreordem();
		System.out.println();
		
		arvoreNumeros.imprimeEmPosordem();
		System.out.println();
		
		arvoreNumeros.imprimeEmLargura(); // 500 [0] | 300 e 700 [1] | 150 e 400 [2]
		System.out.println();

		
		// teste para caracteres
		Node<Character> arvoreLetras = new Node<>('C');
		arvoreLetras.inserirOrdenado('B'); arvoreLetras.inserirOrdenado('E');
		arvoreLetras.inserirOrdenado('A'); arvoreLetras.inserirOrdenado('I');
		arvoreLetras.inserirOrdenado('D');
		
		arvoreLetras.imprimeInOrdem();
		System.out.println();
		
		arvoreLetras.imprimeEmPreordem();
		System.out.println();
		
		arvoreLetras.imprimeEmPosordem();
		System.out.println();
		
		arvoreLetras.imprimeEmLargura(); // C [0] | B e E [1] | A e D e I [2]
		System.out.println();
	}
}
