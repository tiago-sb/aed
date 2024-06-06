package algoritmosSort;

public class SelectionSort {
    private int[] vetor;
    
    public SelectionSort(int[] vetor){
        this.vetor = vetor;
    }

    public void selectionSort() {
        for (int fixo = 0; fixo < vetor.length - 1; fixo++) {
            int menor = fixo;

            for (int i = menor + 1; i < vetor.length; i++) {
                if (vetor[i] < vetor[menor]) {
                    menor = i;
                }
            }
            if (menor != fixo) {
                int t = vetor[fixo];
                vetor[fixo] = vetor[menor];
                vetor[menor] = t;
            }
        }
    }
}
