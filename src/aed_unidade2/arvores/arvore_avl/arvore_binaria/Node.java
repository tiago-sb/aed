package aed_unidade2.arvores.arvore_avl.arvore_binaria;

//lista encadeada do java, usada na pilha e na fila
import java.util.LinkedList;
//fila
import java.util.Queue;
//pilha
import java.util.Stack;

/**
 * <h1>metodos da arvore</h1>
 * <p>
 * - construtor
 * </p>
 * <p>
 * - inserir
 * </p>
 * <p>
 * - imprimir a arvore
 * </p>
 * <p>
 * - Em profundidade InOrdem
 * </p>
 * <p>
 * - Em profundidade PreOrdem
 * </p>
 * <p>
 * - Em profundidade PosOrdem
 * </p>
 * <p>
 * - Em largura
 * </p>
 * <p>
 * - pesquisarProfundidadeInOrdem
 * </p>
 * <p>
 * - pesquisarProfundidadePreOrdem
 * </p>
 * <p>
 * - pesquisarProfundidadePosOrdem
 * </p>
 * <p>
 * - pesquisarEmLargura
 * </p>
 * <p>
 * - remover
 * </p>
 * <p>
 * - calcular o comprimento do caminho entre dois nodes
 * </p>
 * <p>
 * - calcular a altura de um node
 * </p>
 * <p>
 * - verificar se um node eh interno ou externo
 * </p>
 * <p>
 * - calcular a profundidade de um node
 * </p>
 * @author Professor Helio
 */
public class Node<T> {

	private T valor; /* Valor armazenado na raiz. */
	private Node<T> filho_esq, filho_dir; /* Referências para sub-árvores. */

	// construtor da arvore sem subarvore
	public Node(T v) {
		valor = v;
		filho_esq = null;
		filho_dir = null;
	}

	// fornecendo as subarvores no construtor
	public Node(T v, Node<T> NoEsq, Node<T> NoDir) {
		valor = v;
		filho_esq = NoEsq;
		filho_dir = NoDir;
	}

	// retorna o conteudo ou valor do no da arvore
	public T getValor() {
		return valor;
	}

	// Retorna a sub-árvore esquerda
	public Node<T> getFilho_esq() {
		return filho_esq;
	}

	// Retorna a sub-árvore direita
	public Node<T> getFilho_dir() {
		return filho_dir;
	}

	// seta o valor do no raiz da arvore
	public void setValor(T v) {
		valor = v;
	}

	// seta o no da subarvore esquerda
	public void setEsq(Node<T> f_esq) {
		filho_esq = f_esq;
	}

	// seta o no da subarvore direita
	public void setDir(Node<T> f_dir) {

		filho_dir = f_dir;

	}

	public boolean inserirOrdenado(T v) {
		if (v.toString().compareTo(this.getValor().toString()) < 0) {
			// o valor deve ser inserido a esquerda do no atual
			if (this.getFilho_esq() != null)
				// senao for nulo continua navegando na arvore ate encontrar uma folha
				return this.getFilho_esq().inserirOrdenado(v);
			else {
				Node<T> n = new Node<T>(v);// se for nulo, cria o no e adiciona na folha
				this.setEsq(n);
				return true;
			}
		} else {
			// o valor deve ser inserido a direita atual
			if (this.getFilho_dir() != null)
				return this.getFilho_dir().inserirOrdenado(v);
			else {
				Node<T> n = new Node<T>(v);
				this.setDir(n);
				return true;
			}
		}

	}

	public void imprimeInOrdem() {

		if (this.getFilho_esq() != null) {
			this.getFilho_esq().imprimeInOrdem();
		}

		System.out.print(this.valor + " "); // visitando o no raiz

		if (this.getFilho_dir() != null) {
			this.getFilho_dir().imprimeInOrdem();
		}

	}

	protected void imprimeInOrdem2() {
		if (this.getFilho_dir() != null) {
			this.getFilho_dir().imprimeInOrdem2();
		}

		System.out.print(this.valor + " "); // visitando o no raiz

		if (this.getFilho_esq() != null) {
			this.getFilho_esq().imprimeInOrdem2();
		}

	}

	protected void imprimeEmPreordem() {
		System.out.print(this.valor + " "); // visitando o no raiz

		if (this.getFilho_esq() != null) {
			this.getFilho_esq().imprimeEmPreordem();
		}
		if (this.getFilho_dir() != null) {
			this.getFilho_dir().imprimeEmPreordem();
		}
	}

	protected void imprimeEmPosordem() {

		if (this.getFilho_esq() != null) {
			this.getFilho_esq().imprimeEmPosordem();
		}
		if (this.getFilho_dir() != null) {
			this.getFilho_dir().imprimeEmPosordem();
		}

		System.out.print(this.valor + " "); // visitando o no raiz

	}

	public void imprimeEmLargura() {
		// usaremos uma fila
		Queue<Object> f = new LinkedList<Object>();
		f.offer(this); // enfileira o objeto node que chamou o metodo imprimiremLargura
		while (f.peek() != null) { // enquanto fila nao estiver vazia repita
			@SuppressWarnings("unchecked")
			Node<T> no = (Node<T>) f.poll();// desenfileira um node da fila

			if (no.getFilho_esq() != null) {
				f.offer(no.getFilho_esq());// se tiver filho da esquerda, enfileira
			}
			if (no.getFilho_dir() != null) {
				f.offer(no.getFilho_dir());// se tiver filho da direita, enfileira
			}
			System.out.print(no.getValor() + " ");
		}
	}

	@SuppressWarnings("unchecked")
	protected void imprimeEmLarguraRecursivo(@SuppressWarnings("rawtypes") Queue f) {
		if (f.peek() != null) {
			Node<T> no = (Node<T>) f.poll();
			if (no != null) {
				if (no.getFilho_esq() != null) {
					f.offer(no.getFilho_esq());
				}
				if (no.getFilho_dir() != null) {
					f.offer(no.getFilho_dir());
				}
				System.out.print(no.getValor() + " ");
				this.imprimeEmLarguraRecursivo(f);
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void imprimeEmLarguraInvertido() {

		Queue<Object> f = new LinkedList<Object>();
		// PilhaEncadeada p = new PilhaEncadeada();
		@SuppressWarnings("rawtypes")
		java.util.Stack p = new Stack<String>();

		f.offer(this);
		while (f.peek() != null) {
			Node<T> no = (Node<T>) f.poll();

			if (no.getFilho_esq() != null) {
				f.offer(no.getFilho_esq());
				;
			}
			if (no.getFilho_dir() != null) {
				f.offer(no.getFilho_dir());
			}

			p.push(no.getValor().toString());
			// System.out.print(no.getValor()+ " ");

		} // while

		System.out.println();
		imprimePilha(p);

	}

	private void imprimePilha(@SuppressWarnings("rawtypes") java.util.Stack p) {
		while (!p.empty()) {
			System.out.print(p.pop() + " ");
		}
	}

	protected int calculaAltura() {
		// comprimento do caminho mais longo do nó a uma folha.
		int alturaesquerda = 0;
		int alturadireita = 0;

		if (this.getFilho_esq() != null)
			alturaesquerda = this.getFilho_esq().calculaAltura() + 1;

		// aqui, como vou saber a altura do filho da direita pra eu poder calcular a
		// altura do node

		if (this.getFilho_dir() != null)
			alturadireita = this.getFilho_dir().calculaAltura() + 1;

		if (alturaesquerda > alturadireita)
			return alturaesquerda;

		else
			return alturadireita;
	}
// ate aqui

	protected int calculaAlturaEmLargura() {

		Queue<Object> f = new LinkedList<Object>();
		Queue<Integer> dist = new LinkedList<Integer>();

		f.offer(this);
		dist.offer(0);

		int altura_maxima = 0;

		while (f.peek() != null) {
			@SuppressWarnings("unchecked")
			Node<T> no = (Node<T>) f.poll();
			int dist_pai = (int) dist.poll();

			if (no.getFilho_esq() != null) {
				f.offer(no.getFilho_esq());
				dist.offer(dist_pai + 1);
			}

			if (no.getFilho_dir() != null) {
				f.offer(no.getFilho_dir());
				dist.offer(dist_pai + 1);
			}

			// eh folha
			if (dist_pai > altura_maxima)
				altura_maxima = dist_pai;
		}

		return altura_maxima;
	}

	/**
	 * pesquisa um valor em especifico na arvore
	 * @param v
	 * @return o valor caso seja encontrado e nulo caso nao seja encontrado
	 */
	protected Node<T> pesquisarValor(T v) {
		// verifica se o valor a ser pesquisado esta do lado esquerdo do node
		if (v.toString().compareTo(this.getValor().toString()) < 0) { 
			if (this.getFilho_esq() != null) {
				// o valor pode estah na arvore esquerda
				return this.getFilho_esq().pesquisarValor(v); 
			}
			// valor nao foi encontrado
			return null;
		} 
		if(v.toString().compareTo(this.getValor().toString()) > 0) {
			if (this.getFilho_dir() != null) {
				// o valor pode estah na arvore direita
				return this.getFilho_dir().pesquisarValor(v); 
			}
			
			// valor nao foi encontrado
			return null; 
		} else {
			// o valor encontra-se nesse elemento atual
			return this; 
		}
	}

	/**
	 * calcula o total de elementos presentes na arvore
	 * @return numero total de elementos
	 */
	protected int calculaTotalNodes() {
		int totalesq = 0;
		int totaldir = 0;
		if (this.getFilho_esq() != null) {
			totalesq = this.getFilho_esq().calculaTotalNodes();
		}
		if (this.getFilho_dir() != null) {
			totaldir = this.getFilho_dir().calculaTotalNodes();
		}
		return totalesq + totaldir + 1;
	}

	/**
	 * Metodo para calcular o total de elementos folha contidos na arvore
	 * @return numero de elementos folha
	 */
	protected int calculaTotalNodesFolhas() {
		int totalesq = 0;
		int totaldir = 0;
		boolean ehfolha = true;
		if (this.getFilho_esq() != null) {
			totalesq = this.getFilho_esq().calculaTotalNodesFolhas();
			ehfolha = false;
		}
		if (this.getFilho_dir() != null) {
			totaldir = this.getFilho_dir().calculaTotalNodesFolhas();
			ehfolha = false;
		}
		if (ehfolha) {
			return 1;
		}
		return (totaldir + totalesq);
	}
	
	/**
	 * metodo remover para retirar o no arvore mantando o balanceamento
	 * @param valor do elemento a ser removido
	 * @param elemento pai do novo no a ser inserido
	 * @return resultado
	 */
	protected boolean removerNode(T v, Node<T> nodepai) {
		boolean resultado = false;

		if (v.toString().compareTo(this.getValor().toString()) < 0) {
			if (this.getFilho_esq() != null) {
				// o elemento a ser removido se encontra na subarvore esquerda
				return this.getFilho_esq().removerNode(v, this); 
			}
			
			// o valor nao se encontra na subarvore esquerda
			resultado = false;
		} else if (v.toString().compareTo(this.getValor().toString()) > 0) {
			if (this.getFilho_dir() != null) {
				// o valor pode se encontrar na subarvore direita
				return this.getFilho_dir().removerNode(v, this); 
			}
		
			// valor nao encontrado 
			resultado = false;
		} else {
			if ((this.getFilho_esq() == null) && (this.getFilho_dir() == null)) {
				// caso onde o no escolhido eh uma folha
				// setar o filho do elmento pai como nulo
				this.setFilhoNode(nodepai, null);
				resultado = true;
			} else if ((this.getFilho_esq() != null) && (this.getFilho_dir() == null)) {
				// o elemento escolhido tem o filho a esquerda
				// seta o pai o node atual com o filho da esquerda do nodeatual
				this.setFilhoNode(nodepai, this.getFilho_esq()); 
				resultado = true;
			} else if ((this.getFilho_esq() == null) && (this.getFilho_dir() != null)) {
				// o elemento escolhido tem o filho a direita
				// seta o pai do node atual com o filho da direita do nodeatual
				this.setFilhoNode(nodepai, this.getFilho_dir()); 
				resultado = true;
			} else if ((this.getFilho_esq() != null) && (this.getFilho_dir() != null)) {
				// caso onde o no possui filhos a direita e a esquerda
				// pega o node com menor valor da subarvore da direita
				Node<T> menorNodeDir = this.getFilho_dir().NodeComMenorValor(); 
				Node<T> paiMenorNodeDir;
				// verifica se o proprio node raiz da subarvore direita eh ou nao o menor valor
				if (menorNodeDir != this.getFilho_dir()) { 
					paiMenorNodeDir = this.getFilho_dir().acharPai(menorNodeDir);
				} else {
					paiMenorNodeDir = this;
				}
				// coloca o novo valor no nodeatual.
				this.setValor(menorNodeDir.getValor());
				// seta o pai do menorNode com o filho da direita
				menorNodeDir.setFilhoNode(paiMenorNodeDir, menorNodeDir.getFilho_dir()); 
				// menorNodeDir.removerNode(menorNodeDir.getValor(), paiMenorNodeDir)
				resultado = true;
			}
		}
		return resultado;
	}

	/**
	 * seta o filho de um node pai como sendo o novo node. 
	 * @param nodePai
	 * @param novoNode
	 */
	public void setFilhoNode(Node<T> nodePai, Node<T> novoNode) {
		if (nodePai.getFilho_esq() == this) {
			nodePai.setEsq(novoNode);
		} 
		if (nodePai.getFilho_dir() == this) {
			nodePai.setDir(novoNode);
		}
	}

	/**
	 * busca elemento com maior valor da arvore
	 */
	protected Node<T> NodeComMaiorValor() {
		if (this.getFilho_dir() != null) {
			return this.getFilho_dir().NodeComMaiorValor();
		}
		return this;
	}

	/**
	 * busca elemento com menor valor da arvore
	 */
	protected Node<T> NodeComMenorValor() {
		if (this.getFilho_esq() != null) {
			return this.getFilho_esq().NodeComMenorValor();
		}
		return this;
	}
	
	/**
	 * metodo que busca o elemento pai de um determinado elemento em questao
	 * @param nofilho
	 */
	protected Node<T> acharPai(Node<T> nofilho) {
		if (this.getFilho_esq() == nofilho || this.getFilho_dir() == nofilho) {
			return this;
		} else {
			if (nofilho.getValor().toString().compareTo(this.getValor().toString()) > 0) {
				// o valor do no do atual contexto eh maior que o elemento filho, logo o pai esta do lado esquerdo
				if (this.getFilho_esq() != null) {
					return this.getFilho_esq().acharPai(nofilho);
				} 
				// pode ser que o nofilho nao esta na arvore ou ele eh o no raiz
				return null;
			} else {
				if (this.getFilho_dir() != null) {
					return this.getFilho_dir().acharPai(nofilho);
				} 
				// pode ser que o nofilho nao esta na arvore ou ele eh o no raiz
				return null; 
			}
		}
	}
}