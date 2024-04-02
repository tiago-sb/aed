package aed_unidade1.lista_duplamente_encadeada;

public class Principal {
	public static void main(String[] args) {
		ListaDuplamenteEncadeada<String> nomes = new ListaDuplamenteEncadeada<String>();
		nomes.inserirInicio("tiago");
		nomes.inserirFim("joao");
		nomes.inserirFim("paulo");
		System.out.println(nomes.estaVazia());
		nomes.imprimirLista();
		
		ListaDuplamenteEncadeada<Integer> numeros = new ListaDuplamenteEncadeada<Integer>();
		numeros.inserirInicio(1);
		numeros.inserirFim(2);
		System.out.println();
		numeros.imprimirLista();
	}
}
