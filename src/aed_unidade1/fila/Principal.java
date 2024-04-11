package aed_unidade1.fila;

import aed_unidade1.fila.filaArray.FilaArray;
import aed_unidade1.fila.filaEncadeada.FilaEncadeada;

public class Principal {
	public static void main(String[] args) throws Exception {
		
		// teste para fila usando arrays
		FilaArray<String> nomes = new FilaArray<String>(3);
		
		nomes.enfileirar("tiago");
		nomes.enfileirar("anna joana");
		nomes.enfileirar("paulo antonio");
		
		nomes.imprimirFila();
		System.out.println(nomes.getPrimeiro());
		
		String nomeTirado = nomes.desenfileirar();
		// primeiro nome da lista
		System.out.println(nomeTirado);
		
		// teste para fila usando lista encadeada
		FilaEncadeada<String> nomeUsuarios = new FilaEncadeada<String>();
		
		nomeUsuarios.enfileirar("joao neto");
		nomeUsuarios.enfileirar("joana");
		nomeUsuarios.enfileirar("paula");
		nomeUsuarios.enfileirar("jonas filho");
		
		nomeUsuarios.imprimir();
	}
}
