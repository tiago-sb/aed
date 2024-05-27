import tabelaHashArvore.Hash;

public class Principal {
  public static void main(String[] args) {
    // criacao da tabela com o tamanho especificado
    Hash hashArvores = new Hash(7);
    // insercao de valores na tabela
    hashArvores.inserir("Tiago");
    hashArvores.inserir("Santos");
    hashArvores.inserir("Bela");
    hashArvores.inserir("Segunda");
    // imprimindo os elementos 
    hashArvores.imprimir();

    //removendo elementos
    hashArvores.remover("Segunda");
    hashArvores.imprimir();
  }
}
