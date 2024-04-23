package aed_unidade1.lista_classificada;

import aed_unidade1.lista_classificada.lista_ordenada.ListaClassificada;

public class Principal {
	public static void main(String[] args) throws Exception {
		// teste para numeros inteiros
		ListaClassificada<Integer> numeros = new ListaClassificada<>();
		numeros.inserir(16);
		numeros.inserir(23);
		numeros.inserir(13);
		numeros.inserir(5);
		numeros.inserir(1);
		
		numeros.imprimir(); // saida: 1 5 13 16 23
		
		// teste para numeros com ponto flutuante
		ListaClassificada<Double> numerosRacionais = new ListaClassificada<>();
		numerosRacionais.inserir(8.56);
		numerosRacionais.inserir(3.14);
		numerosRacionais.inserir(15.2);
		numerosRacionais.inserir(4.2);

		numerosRacionais.imprimir(); // saida: 3.14 4.2 8.56 15.2
		
		// teste para palavras
		ListaClassificada<String> nomes = new ListaClassificada<>();
		nomes.inserir("alice");
		nomes.inserir("claudio");
		nomes.inserir("beatriz");
		nomes.inserir("zelia");
		nomes.inserir("tiago");
		
		nomes.imprimir();
	}
}
