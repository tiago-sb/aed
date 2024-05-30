package hashAberto;

public class HashAberto<K, V> {
    private static final int CAPACIDADE = 11;
    private K[] keys;
    private V[] values;
    private int size;
    private int capacidade;

    @SuppressWarnings("unchecked")
    public HashAberto() {
        this.capacidade = CAPACIDADE;
        this.keys = (K[]) new Object[capacidade];
        this.values = (V[]) new Object[capacidade];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % CAPACIDADE);
    }

    private int hash2(K key) {
        // s eh qualquer numero menor que a capacidade da tabela
        // de preferencia primo
        int s = 7;
        return Math.abs(key.hashCode() % s);
    }

    public void put(K key, V value, int sondagem) {
        int index = hash(key);
        int tentativas = 1;

        // depois inserir aqui neste lugar a função de sondagem
        while (keys[index] != null) { // nulo é a informação que nunca foi usada
            // caso onde eu quero adicionar um valor que ja se encontra na tabela
            if (keys[index].equals(key)) {
                // Atualiza o valor se a chave já existir
                values[index] = value; 
                return;
            }
            // caso onde a sondagem eh linear
            if(sondagem == 1){
                // index = (index + 1) % CAPACIDADE;
                index = ((hash(key) + tentativas) % CAPACIDADE);
            }
            // caso onde a sondagem eh quadratica
            if(sondagem == 2){
                index = ((hash(key) + (tentativas * tentativas)) % CAPACIDADE);
            }
            // caso onde a sondagem eh dupla
            if(sondagem == 3){
                // index = (index + tentativas * this.hash2(key)) % CAPACIDADE;   
                index = (hash(key) + tentativas * (hash2(key) + 1)) % CAPACIDADE;
            }
            tentativas = tentativas + 1;
            
            // evitar os loops 
            if(tentativas >= CAPACIDADE){
                System.out.println("loop");
                break;
            }
        }

        keys[index] = key;
        values[index] = value;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % capacidade;
        }
        return null; // Retorna null se a chave não for encontrada
    }

    public V remove(K key) {
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                V value = values[index];
                keys[index] = null;
                values[index] = null;
                size--;
                return value;
            }
            index = (index + 1) % capacidade;
        }
        return null; // Retorna null se a chave não for encontrada
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void imprimir(){
        for (int i = 0; i < keys.length; i++) {
            if(keys[i] != null) {
                System.out.println("Chave: " + keys[i] + " - Estado: " + values[i]);
            }
            if(keys[i] == null){
                System.out.println("Posição vazia");
            }
        }
    }
}