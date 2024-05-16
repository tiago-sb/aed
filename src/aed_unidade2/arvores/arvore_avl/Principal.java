package aed_unidade2.arvores.arvore_avl;

import aed_unidade2.arvores.arvore_avl.avl.AVL;
public class Principal {

	public static void main(String[] args) {
		 // 5, 10, 0, 15, 8, 4
	    AVL<String> arvoreDeNumeros = new AVL<String>("005");
	    arvoreDeNumeros = arvoreDeNumeros.InsereOrdenado("010", new AVL<String>("001"));
	    arvoreDeNumeros = arvoreDeNumeros.InsereOrdenado("000", new AVL<String>("005"));
	    arvoreDeNumeros = arvoreDeNumeros.InsereOrdenado("015", new AVL<String>("010"));
	    arvoreDeNumeros = arvoreDeNumeros.InsereOrdenado("008", new AVL<String>("010"));
	    arvoreDeNumeros = arvoreDeNumeros.InsereOrdenado("004", new AVL<String>("000"));

	    // impresao de elementos da arvore
	    arvoreDeNumeros.imprimeEmLargura();
	    System.out.println();
	    
	    arvoreDeNumeros.imprimeInOrdem();
	    System.out.println();

	    // remocao de valores da arvore balanceada
	    arvoreDeNumeros = arvoreDeNumeros.removerNode("010", new AVL<String>("005"));
	    arvoreDeNumeros.imprimeEmLargura();
	    System.out.println();
	}
}
