package aed_unidade1.lista_encadeada;

public class Principal {
	public static void main(String[] args) throws Exception {
		ListaEncadeada lista = new ListaEncadeada();
		
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
		
		// metodo estatico para imprimir os elementos presentes na lista
		ListaEncadeada.imprimirLista(lista);
	}
}
