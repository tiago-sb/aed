package aed_unidade2.arvores.arvore_binaria.node;

import java.util.Queue;
import java.util.LinkedList;

public class Node<T> implements INode<T> {
	private T dado; /* Valor armazenado na raiz. */
	private Node<T> filho_esquerdo; /* Referências para sub-árvores. */
	private Node<T> filho_direito; /* Referências para sub-árvores. */

	// construtor da arvore sem subarvore
	public Node(T dado) {
		this.dado = dado;
		this.filho_esquerdo = null;
		this.filho_direito = null;
	}

	// fornecendo as subarvores no construtor
	public Node(T dado, Node<T> filho_esquerdo, Node<T> filho_direito) {
		this.dado = dado;
		this.filho_esquerdo = filho_esquerdo;
		this.filho_direito = filho_direito;
	}

	// retorna o conteudo ou valor do no da arvore
	public T getDado() {
		return this.dado;
	}

	// seta o valor do no raiz da arvore
	public void setDado(T dado) {
		this.dado = dado;
	}

	// Retorna a sub-árvore esquerda
	public Node<T> getFilho_esquerdo() {
		return this.filho_esquerdo;
	}

	// seta o no da subarvore esquerda
	public void setFilho_esquerdo(Node<T> filho_esquerdo) {
		this.filho_esquerdo = filho_esquerdo;
	}

	// Retorna a sub-árvore direita
	public Node<T> getFilho_direito() {
		return this.filho_direito;
	}

	// seta o no da subarvore direita
	public void setFilho_direito(Node<T> filho_direito) {
		this.filho_direito = filho_direito;
	}

	public boolean inserirOrdenado(T dado) {
		// caso o valor a ser inserido seja menor que o valor contido no nó atual
		// insere a esquerda caso nao insere a direita
		if (dado.toString().compareTo(this.getDado().toString()) < 0) {
			// o valor deve ser inserido a esquerda do no atual
			if (this.getFilho_esquerdo() != null) {
				return this.getFilho_esquerdo().inserirOrdenado(dado); // senao for nulo continua navegando na arvore
																		// ate encontrar uma folha
			}

			Node<T> novoElemento = new Node<T>(dado);// se for nulo, cria o no e adiciona na folha
			this.setFilho_esquerdo(novoElemento);

			return true;
		} else {
			// o valor deve ser inserido a direita atual
			if (this.getFilho_direito() != null) {
				return this.getFilho_direito().inserirOrdenado(dado);
			}

			Node<T> novoElemento = new Node<T>(dado);
			this.setFilho_direito(novoElemento);

			return true;
		}
	}

	public void imprimeInOrdem() {
		if(this.getFilho_esquerdo() != null){
			this.getFilho_esquerdo().imprimeInOrdem();
		}
		
		System.out.print(this.getDado() + " ");
		
		if(this.getFilho_direito() != null){
			this.getFilho_direito().imprimeInOrdem();
		}
	}

	public void imprimeEmPreordem() {
		System.out.print(this.getDado() + " ");
		
		if(this.getFilho_esquerdo() != null){
			this.getFilho_esquerdo().imprimeEmPreordem();
		}
		if(this.getFilho_direito() != null){
			this.getFilho_direito().imprimeEmPreordem();
		}
	}

	public void imprimeEmPosordem() {
		if(this.getFilho_esquerdo() != null){
			this.getFilho_esquerdo().imprimeEmPreordem();
		}
		if(this.getFilho_direito() != null){
			this.getFilho_direito().imprimeEmPreordem();
		}
		
		System.out.print(this.getDado() + " ");
	}

	public void imprimeEmLargura() {
		Queue<Node<T>> fila = new LinkedList<>();
		fila.add(this);
		while(!fila.isEmpty()) {
			Node<T> no = fila.poll();
			
			if(no.getFilho_esquerdo() != null) {
				fila.add(no.getFilho_esquerdo());
			}
			
			System.out.print(no.getDado() + " ");
			
			if(no.getFilho_direito() != null) {
				fila.add(no.getFilho_direito());
			}
		}
	}
}