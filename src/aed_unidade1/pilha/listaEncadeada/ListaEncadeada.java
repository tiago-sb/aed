package aed_unidade1.pilha.listaEncadeada;

public class ListaEncadeada<Tipo> {
	private Element<Tipo> head;
	private Element<Tipo> tail;

	public ListaEncadeada() {
		this.head = null;
		this.tail = null;
	}
	
	public Tipo getHeadValue() throws Exception {
	    if (this.head == null){
	        throw new Exception();
	    }

	    return this.head.getData();
	}

	public Tipo getTailValue() throws Exception {
	    if (tail == null){
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

	public void inserirInicio(Tipo valorEscolhido){
	    Element<Tipo> novoItem = new Element<Tipo>(valorEscolhido);
	    if (this.head == null){
	        this.tail = novoItem;
	    }
	 
	    this.head = novoItem;
	}

	public void inserirFim(Tipo valorEscolhido){
		Element<Tipo> novoItem = new Element<Tipo>(valorEscolhido);
	    
		if (this.head == null){
	        this.head = novoItem;
	    } 
	    
	    if(this.head != null) {
	    	this.tail.setNext(novoItem);
	    }
	}
	
	public void atribuir (ListaEncadeada<Tipo> elemento){
	    if (elemento != this){
	       this.fazVazia();
	        for (Element<Tipo> ptr = elemento.head; ptr != null; ptr = ptr.getNext()){
	            this.inserirFim(ptr.getData());
	        }
	    }
	}

	public void extrair(Tipo item) throws Exception {
	    Element<Tipo> ptr = head;
	    Element<Tipo> prevPtr = null;

	    while (ptr != null && ptr.getData() != item){
	        prevPtr = ptr;
	        ptr = ptr.getNext(); 
	    }

	    if (ptr == null){
	        throw new Exception();
	    }

	    if (ptr == head){
	        head = ptr.getNext();
	    } else {
	        prevPtr.setNext(ptr.getNext());
	    }

	    if (ptr == tail){ 
	        tail = prevPtr; 
	    }
	}

	public void imprimirLista(ListaEncadeada<Tipo> elemento){
		for (Element<Tipo> ptr = elemento.head; ptr != null; ptr = ptr.getNext()){
	        System.out.print("[" + ptr.getData() + "] ");
	    }
	}
}