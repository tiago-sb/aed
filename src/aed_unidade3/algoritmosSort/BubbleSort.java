package algoritmosSort;

public class BubbleSort{
    private int[] vetor;

    public BubbleSort(int[] vetor){
        this.vetor = vetor;
    }

    public void bubbleSort(){
        boolean troca = true;
        
        while(troca) {
            troca = false;
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    int auxiliar = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = auxiliar;
                    troca = true;
                }
            }        
        }  
    }     
}
