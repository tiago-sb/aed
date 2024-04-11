package aed_unidade1.deque.dequeEncadeada.lista_simples;

public class ListaSimples<T> implements IListaSimples<T> {
    private Element<T> head;
    private Element<T> tail;
    private int numeroElementos;
    
    public ListaSimples() {
    	this.head = null;
    	this.tail = null;
    	this.numeroElementos = 0;
    }
    
    public class Element<E> {
    	private T data;
    	private Element<T> next;
    	
    	public Element(T data, Element<T> next) {
    		this.data = data;
    		this.next = next;
    	}
    	
    	public T getData() {
    		return this.data;
    	}
    	
    	public void setData(T data) {
    		this.data = data;
    	}
    	
    	public Element<T> getNext() {
    		return this.next;
    	}
    	
    	public void setNext(Element<T> next) {
    		this.next = next;
    	}
    }
    
    
    public T getHeadValue() throws Exception {
        if (this.head == null){
            throw new Exception();
        }

        return this.head.getData();
    }
    
    public T getTailValue() throws Exception {
        if (this.tail == null){
            throw new Exception();
        }

        return this.tail.getData();
    }
    
    public boolean estaVazia(){
        return this.head == null; 
    }
    
    public void fazVazia() {
        this.head = null;
        this.tail = null;
    }
    
    public int tamanhoLista(){
    	return this.numeroElementos;
    }
    
    public void inserirInicio(T itemEscolhido){
        Element<T> novoItem = new Element<T>(itemEscolhido, head);
        
        if (this.head == null){
        	this.tail = novoItem;
        }
     
        this.numeroElementos = this.numeroElementos + 1;
        this.head = novoItem;
    }
    
    public void inserirFim(T item){
        Element<T> novoItem = new Element<T>(item, null);
        
        if (this.head == null){
            this.head = novoItem;
        } else {
            this.tail.setNext(novoItem);
        }
        
        this.numeroElementos = this.numeroElementos + 1;
        this.tail = novoItem;
    }
    
    public void atribuir(ListaSimples<T> novaLista){
        if (novaLista != this){
           this.fazVazia();
           
           for(Element<T> novoItem = novaLista.head; novoItem != null; novoItem = novoItem.getNext()) {
        	   this.numeroElementos = this.numeroElementos + 1;
        	   this.inserirFim(novoItem.getData());
           }
        }
    }
    
    public void extrair(T item) throws Exception {
        Element<T> itemEscolhido = this.head;
        Element<T> anteriorItemEscolhido = null;
    
        while (itemEscolhido != null && itemEscolhido.getData() != item){
            anteriorItemEscolhido = itemEscolhido;
            itemEscolhido = itemEscolhido.getNext();
        }
    
        if (itemEscolhido == null){
            throw new Exception();
        }
        if(!itemEscolhido.equals(this.head)){
            anteriorItemEscolhido.setNext(itemEscolhido.getNext());
        }
        if (itemEscolhido.equals(this.head)){
            this.head = itemEscolhido.getNext();
        }
        if (itemEscolhido.equals(this.tail)){ 
            this.tail = anteriorItemEscolhido; 
        }
        
        this.numeroElementos = this.numeroElementos - 1;
    }
    
    public void imprimirLista(){
    	for (Element<T> novoItem = this.head; novoItem != null; novoItem = novoItem.getNext()){
    		if(novoItem.equals(this.tail)) {
            	System.out.println(novoItem.getData() + ".");
            }
    		if(!novoItem.equals(this.tail)) {
    			System.out.print(novoItem.getData() + ", ");
    		}
        }
    }
}