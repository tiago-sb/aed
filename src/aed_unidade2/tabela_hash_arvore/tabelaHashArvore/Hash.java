package tabelaHashArvore;

import arvore_avl.AVL;

/**
 * <h1>Hash</h1>
 * <p>Implementacao da tabela hash fechada usando arvores binarias balanceadas</p>
 */
public class Hash {

    @SuppressWarnings("rawtypes")
    // declarando que a tabela vai ser um vetor de arvores binarias balanceadas
    private AVL tabelaHash[];

    // o valor de m deve ser um numero primo
    private int m;

    public Hash(int m) {
        tabelaHash = new AVL[m];
        this.m = m;
    }

    /**
     * Inserir novos elementos na tabela
     * 
     * @param novoElemento
     */
    @SuppressWarnings("unchecked")
    public void inserir(String novoElemento) {
        // calculando a funcao hash do novo elemento e colocando esse valor em uma
        // entrada
        int entradaHash = funcaohash(novoElemento);

        // teste para verificar se o elemento ja esta na tabela
        if (tabelaHash[entradaHash] == null) {
            // caso nao esteja cria uma lista encadeada
            tabelaHash[entradaHash] = new AVL<>(novoElemento);
            return;
        }

        // insere o novo elemento no fim da lista encadeada
        tabelaHash[entradaHash].InsereOrdenado(novoElemento, null);
    }

    /**
     * Remover elementos da tabela caso eles existam
     * 
     * @param novoElemento
     * @return resultado
     */
    @SuppressWarnings("unchecked")
    public boolean remover(String novoElemento) {
        // calculando a funcao do novo elemento a ser inserido e colocando esse valor em
        // uma entrada
        int entradaHash = funcaohash(novoElemento);
        boolean resultado = false;

        // se eu nao encontrar o elemento na lista retorna falso
        if (tabelaHash[entradaHash] == null) {
            return resultado;
        }
        if (tabelaHash[entradaHash] != null) {
            try {
                tabelaHash[entradaHash] = tabelaHash[entradaHash].removerNode(novoElemento, null);
                resultado = true;
            } catch (Exception e) {
                System.out.println("erro");
            }
        }

        // caso onde o elemento foi encontrado na tabela e pode ser feito a extracao
        return resultado;
    }

    /**
     * trocar o valor de um determinado hash
     * 
     * @param valorAnterior
     * @param valorAtual
     */
    public void alterarValor(String valorAnterior, String valorAtual) {
        if (this.remover(valorAnterior)) {
            this.inserir(valorAtual);
        }
    }

    /**
     * fucao utilizada para efetuar o hash de um determinado elemento
     * 
     * @param chave
     * @return
     */
    private int funcaohash(String chave) {
        // minha função hash pode ser modificada
        int soma = 0;
        int comprimento = chave.length();

        // funcao para converter a chave em um inteiro
        for (int i = 0; i < comprimento; i++) {
            soma += (chave.charAt(i) * (i + 1));
        }

        return (soma % this.m);
    }

    /**
     * imprimir os elementos da tabela
     */
    public void imprimir() {
        System.out.println("------------------");
        for (int i = 0; i < this.m; i++) {
            System.out.print("posicao " + i + " da tabela: ");
            if (this.tabelaHash[i] != null) {
                this.tabelaHash[i].imprimeEmLargura();
            }
            if (this.tabelaHash[i] == null) {
                System.out.println("posicao vazia");
            }

        }
    }
}