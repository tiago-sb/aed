import TabelaHash.Hash;

/**
 * Testes
 */
public class Principal {
    public static void main(String[] args) {
        // o tamanho da tabela eh passado como argumento no construtor
        Hash meu_hash = new Hash(7);      
        
        // inserindo os elementos na tabela
        meu_hash.inserir("tiago");
        meu_hash.inserir("santos");
        meu_hash.inserir("bela");
        meu_hash.inserir("aed");
        meu_hash.inserir("quinta");

        // imprimir os elementos que estao na tabela Hash
        meu_hash.imprimir();
    }
}


