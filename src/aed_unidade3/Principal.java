public class Principal {
    public static void main(String[] args) {
        int quantidade = 100000;
        int[] vetor = new int[quantidade];
        
        

        for (int i = 0; i < vetor.length; i++) {
         vetor[i] = (int) (Math.random() * quantidade);
        }
        
        System.out.println("Vetor gerado!!!");
        
        // BubbleSort bS = new BubbleSort(vetor);
        // SelectionSort sS = new SelectionSort(vetor);
        InsertionSort iS = new InsertionSort(vetor);

        long tempoInicial = System.currentTimeMillis();
        
        // bS.bubbleSort();
        // sS.selectionSort();
        iS.insertionSort();

        long tempoFinal = System.currentTimeMillis();
        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
    }
}
