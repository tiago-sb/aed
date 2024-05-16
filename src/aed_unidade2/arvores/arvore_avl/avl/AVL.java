package aed_unidade2.arvores.arvore_avl.avl;

import aed_unidade2.arvores.arvore_avl.arvore_binaria.Node;

/**
 * <h1>Classe AVL</h1>
 * A classe Node AVL herda de Node.
 * eh adicionado nessa classe o fato de balancamento.
 * @author professor Helio
 */
public class AVL<T> extends Node<T> {

	private int fatorbalanceamento = 0;

	public AVL(T v) {
		super(v);
		this.fatorbalanceamento = 0;
	}
	
	/**
	 * o metodo getfilho é reescrito para retornar um node AVL
	 */
	public AVL<T> getFilho_dir() {

		return (AVL<T>) super.getFilho_dir();
	}

	/**
	 * o metodo getfilho é reescrito para retornar um node AVL
	 */
	public AVL<T> getFilho_esq() {
		return (AVL<T>) super.getFilho_esq();
	}

	/**
	 * fator de balanceamento de cada no AVL
	 * @return fator de balanceamento do no
	 */
	public int getFB() {
		// this.fatorbalanceamento = calculaFatorBalanceamento();
		return this.fatorbalanceamento;
	}

	/**
	 * metodo inserir que insere e atualiza o fator de balanceamento apos a insercao 
	 * @param valor do novo no escolhido
	 * @param elemento pai do novo no
	 * @return resultado
	 */
	public AVL<T> InsereOrdenado(T v, AVL<T> nodepai) {
		AVL<T> resultado;
		// caso o novo valor for menor que o seu no pai insere a esquerda
		if (v.toString().compareTo(this.getValor().toString()) < 0) {
			// o valor deve ser inserido a esquerda do no atual
			// caso nao seja nulo vamos navegar por toda a arvore ate encontrar uma folha
			if (this.getFilho_esq() != null) {
				this.getFilho_esq().InsereOrdenado(v, this);
				
				// chama o metodo para verificar se o no esta balanceado e aloca o resultado dessa operacao na variavel resultado
				resultado = this.verificarbalanceamento(nodepai);

				return resultado;
			}
			
			AVL<T> novoElemento = new AVL<T>(v);
			this.setEsq(novoElemento);
		}
		else {
			// o valor deve ser inserido a direita atual
			if (this.getFilho_dir() != null) {
				this.getFilho_dir().InsereOrdenado(v, this);
				
				// verifica e o balanceamento e rotaciona se necessario retornando a nova raiz da rotacao
				resultado = this.verificarbalanceamento(nodepai);
				return resultado;
			}
			
			AVL<T> novoElemento = new AVL<T>(v);
			this.setDir(novoElemento);
		}
		
		// retorno do raiz do novo elemento criado
		return this;
	}

	/**
	 * metodo remover para retirar o no arvore mantando o balanceamento
	 * @param valor do elemento a ser removido
	 * @param elemento pai do novo no a ser inserido
	 * @return resultado
	 */
	public AVL<T> removerNode(T v, AVL<T> nodepai) {
		AVL<T> resultado = this;

		if(v.toString().compareTo(this.getValor().toString()) < 0) {
			if(this.getFilho_esq() != null) {
				// o elemento a ser removido ta na subarvore esquerda
				this.getFilho_esq().removerNode(v, this); 
				
				// verifica balanceamento e rotaciona se necessario.
				resultado = this.verificarbalanceamento(nodepai);
				return resultado;
			} 
			return resultado;// o valor nao ta na subarvoreesquerda
		} else if (v.toString().compareTo(this.getValor().toString()) > 0) {
			if (this.getFilho_dir() != null) {
				// o valor pode estah na subarvore direita
				this.getFilho_dir().removerNode(v, this); 
				
				// verifica balanceamento e rotaciona se necessario.
				resultado = this.verificarbalanceamento(nodepai);
				return resultado;
			} 
			return resultado;// valor nao foi encontrado }
		} else {
			// caso em que o elemento selecionado eh uma folha
			if((this.getFilho_esq() == null) && (this.getFilho_dir() == null)) {
				this.setFilhoNode(nodepai, null);
			} else if((this.getFilho_esq() != null) && (this.getFilho_dir() == null)) {
				// o elemento escolhido tem um filho a esquerda
				// seta o pai o node atual com o filho da esquerda do nodeatual
				this.setFilhoNode(nodepai, this.getFilho_esq()); 
			} else if((this.getFilho_esq() == null) && (this.getFilho_dir() != null)) {
				// o elemento escolhido tem um filho a direita
				// seta o pai do node atual com o filho da direita do nodeatual
				this.setFilhoNode(nodepai, this.getFilho_dir()); 
			} else if ((this.getFilho_esq() != null) && (this.getFilho_dir() != null)) {
				// caso onde temos filhos tanto a esquerda quanto na direita
				// escolhemos pegar o elemento com menor valor da subarvore da direita
				Node<T> menorNodeDir = this.getFilho_dir().NodeComMenorValor(); 
				Node<T> paiMenorNodeDir;
				if (menorNodeDir != this.getFilho_dir()) {
					paiMenorNodeDir = this.getFilho_dir().acharPai(menorNodeDir);
				} else {
					paiMenorNodeDir = this;
				}
				
				// coloca o novo valor no elemento atual
				this.setValor(menorNodeDir.getValor());
				
				// seta o pai do menorNode com o filho da direita
				menorNodeDir.setFilhoNode(paiMenorNodeDir, menorNodeDir.getFilho_dir());
			}
		}

		return resultado;
	}
	
	/**
	 * metodo que busca o elemento pai de um determinado elemento em questao
	 */
	public AVL<T> acharPai(Node<T> noraiz) {
		return (AVL<T>) super.acharPai(noraiz);
	}

	/**
	 * metodo para calcular fator balanceamento do elemento
	 * @return
	 */
	private int calculaFatorBalanceamento() {
		int alturaesq = 0;
		int alturadir = 0;
		
		if (this.getFilho_esq() != null) {
			alturaesq = this.getFilho_esq().calculaAltura() + 1;
		}
		if (this.getFilho_dir() != null) {
			alturadir = this.getFilho_dir().calculaAltura() + 1;
		}
			
		this.fatorbalanceamento = alturadir - alturaesq;
		return this.fatorbalanceamento;
	}

	/**
	 * metodo para verificar a existencia de um possivel desbalanceamento na arvore
	 * @param elemento pai
	 * @return novo elemento raiz
	 */
	private AVL<T> verificarbalanceamento(AVL<T> nopai) {
		int fb = this.calculaFatorBalanceamento();
		int fb1 = 0;
		
		// verificar se existe algum desbalanceamento na arvore
		if ((fb < -1) || (fb > 1)) {
			if (fb > 1) { 
				if (this.getFilho_dir() != null) {
					fb1 = this.getFilho_dir().calculaFatorBalanceamento();
					if (fb1 < 0) {
						return this.rotacaoDuplaAEsquerda(nopai);
					}
					return this.rotacaoAEsquerda(nopai);
				}
			} else {
				fb1 = 0;
				if (this.getFilho_esq() != null) {
					fb1 = this.getFilho_esq().calculaFatorBalanceamento();
				}
				if (fb1 > 0) {
					return this.rotacaoDuplaADireita(nopai);
				}
				return this.rotacaoADireita(nopai);
			}
		}
		
		return this;
	}

	/**
	 * implementacao do algoritmo para rotacao a esquerda
	 * @param nopaideA
	 * @return novo elemento raiz 
	 */
	private AVL<T> rotacaoAEsquerda(AVL<T> nopaideA) {
		// filho da direita sera a nova raiz
		AVL<T> novaraizB = this.getFilho_dir();
		// raiz da rotacao
		AVL<T> tempA = this;
		if (novaraizB != null) {
			// filho da direita da antiga raiz vira a nova raiz
			this.setFilhoNode(nopaideA, novaraizB);
			// filho da esquerda da nova raiz vira filho da direita da antiga raiz
			tempA.setDir(novaraizB.getFilho_esq());
			// antiga raiz vira filho da esquerda da nova raiz
			novaraizB.setEsq(tempA);
		}
		
		return novaraizB;
	}

	// implementamos o algoritmo para rotacao a direita
	/**
	 * implementacao do algoritmo para rotacao a direita
	 * @param nopaideC
	 * @return novo elemento raiz
	 */
	private AVL<T> rotacaoADireita(AVL<T> nopaideC) {
		// filho da esquerda sera a nova raiz
		AVL<T> novaraizB = this.getFilho_esq();
		// raiz da rotacao
		AVL<T> tempC = this;
		if (novaraizB != null) {
			// o filho da direita vira a raiz
			this.setFilhoNode(nopaideC, novaraizB);
			// filho da direita da nova raiz vira filho da Esquerda da antiga raiz
			tempC.setEsq(novaraizB.getFilho_dir());
			// antiga raiz vira filho da direita da nova raiz
			novaraizB.setDir(tempC);
		}
		
		return novaraizB;
	}

	/**
	 * rotacao simples a esquerda seguida de uma rotacao a direita
	 * @param nopaideA
	 * @return novo elemento raiz
	 */
	private AVL<T> rotacaoDuplaAEsquerda(AVL<T> nopaideA) {
		// rotacao simples a direita no filho da direita.
		this.getFilho_dir().rotacaoADireita(this);
		// rotacao a esquerda na arvore original
		return this.rotacaoAEsquerda(nopaideA);
	}

	// rotação dupla é a chamada consecutiva de duas rotacoes simples
	private AVL<T> rotacaoDuplaADireita(AVL<T> nopaideA) {
		// rotacao simples a esquerda no filho da esquerda
		this.getFilho_esq().rotacaoAEsquerda(this);
		// rotacao a esquerda na arvore original
		return this.rotacaoADireita(nopaideA);
	}
}