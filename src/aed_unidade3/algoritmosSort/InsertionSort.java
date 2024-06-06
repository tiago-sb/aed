package algoritmosSort;

public class InsertionSort {
    private int[] vetor;

    public InsertionSort(int[] vetor){
        this.vetor = vetor;
    }

    public void insertionSort() {
        int j; //indice
        int key; //chave
        int i; //indice

        //comeca a partir do segundo elemento
        //o primeiro sozinho ja eh ordenado
        for (j = 1; j < vetor.length; j++){
            key = vetor[j];
            for (i = j - 1; (i >= 0) && (vetor[i] > key); i--) {
                vetor[i + 1] = vetor[i];    
            }
            vetor[i + 1] = key;
        }
    }
}