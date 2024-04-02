package aed_unidade1.lista_duplamente_encadeada;

public class ListaDuplamenteEncadeada<Tipo> {
	private Element<Tipo> head;
    private Element<Tipo> tail;
    
    public ListaDuplamenteEncadeada() {
    	this.head = null;
    	this.tail = null;
    }
    
    public class Element<Tipos> {
    	private Tipo data;
    	private Element<Tipo> next;
    	private Element<Tipo> previous;
    	
    	public Element(Tipo data) {
    		this.data = data;
    		this.next = null;
    		this.previous = null;
    	}
    	
    	public Element(){
    		this.data = null;
    		this.next = null;
    		this.previous = null;
    	}
    	
    	public Tipo getData() {
    		return this.data;
    	}
    	
    	public void setData(Tipo data) {
    		this.data = data;
    	}
    	
    	public Element<Tipo> getNext() {
    		return this.next;
    	}
    	
    	public void setNext(Element<Tipo> next) {
    		this.next = next;
    	}
    	
    	public Element<Tipo> getPrevious() {
    		return this.previous;
    	}
    	
    	public void setPrevious(Element<Tipo> previous) {
    		this.previous = previous;
    	}
    }
    
    
    public Tipo getHeadValue() throws ListaVaziaException {
        if (this.head == null){
            throw new ListaVaziaException("lista vazia");
        }

        return head.data;
    }
    
    public Tipo getTailValue() throws ListaVaziaException {
        if (this.tail == null){
            throw new ListaVaziaException("lista vazia");
        }
    
        return tail.data;
    }
    
    public boolean estaVazia(){
        return this.head == null; 
    }
    
    public void fazVazia() {
        this.head = null;
        this.tail = null;
    }

    public void inserirInicio(Tipo item){
    	Element<Tipo> novoItem = new Element<Tipo>(item);
        
    	if (this.head == null){
            this.head = novoItem;
            this.tail = novoItem;
        }
    	
        if(this.head != null) {
        	novoItem.setNext(this.head);
        	this.head.setPrevious(novoItem);
        	this.head = novoItem;
        }
    }
    
    public void inserirFim(Tipo item){
        Element<Tipo> novoItem = new Element<Tipo>(item);
        
        if (this.head == null){
            this.head = novoItem;
            this.tail = novoItem;
        }
        if(this.head != null) {
        	this.tail.setNext(novoItem);
        	novoItem.setPrevious(this.tail);
        	this.tail = novoItem;
        }
    }
    
    public void atribuir (ListaDuplamenteEncadeada<Tipo> elemento){
        if (elemento != this){
           this.fazVazia();
            for (Element<Tipo> proximoItem = elemento.head; proximoItem != null; proximoItem = proximoItem.getNext()){
                this.inserirFim(proximoItem.data);
            }
        }
    }
    
    public void extrair(Tipo item) throws Exception {
        Element<Tipo> itemChosen = head;
        Element<Tipo> prevPtr = null;
    
        while (itemChosen != null && itemChosen.getData() != item){
            prevPtr = itemChosen;
            itemChosen = itemChosen.getNext(); 
        }
    
        if (itemChosen == null){
        	throw new ObjetoNaoEncontradoException("item nao encontrado");
        }
    
        if (itemChosen == this.head) {
            this.head = itemChosen.getNext();
        }
        
        if(itemChosen != this.head) {
            prevPtr.next = itemChosen.next;
        }
    
        if (itemChosen == tail) { 
            tail = prevPtr; 
        }
    }
    
    public void imprimirLista(){
    	for (Element<Tipo> ptr = this.head; ptr != null; ptr = ptr.getNext()){
            System.out.print("[" + ptr.getData() + "] ");
        }
    }
}
