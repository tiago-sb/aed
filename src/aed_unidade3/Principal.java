// import algoritmosSort.BubbleSort;
// import algoritmosSort.InsertionSort;
import algoritmosSort.SelectionSort;

public class Principal {
    public static void main(String[] args) {
        int[] vetor = new int[100000];
        
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * 100000);
        }
        
        System.out.println("Vetor gerado!!!");
        
        // BubbleSort bS = new BubbleSort(vetor);
        SelectionSort sS = new SelectionSort(vetor);
        // InsertionSort iS = new InsertionSort(vetor);

        long tempoInicial = System.currentTimeMillis();
        
        // bS.bubbleSort();
        sS.selectionSort();
        // iS.insertionSort();

        long tempoFinal = System.currentTimeMillis();
        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
    }
}
