package aed_unidade1.lista_encadeada;

public class ListaEncadeada {
    private Element head;
    private Element tail;
    
    public ListaEncadeada() {}
    
    public class Element {
    	Object data;
    	Element next;
    	
    	public Element(Object data, Element next) {
    		this.data = data;
    		this.next = next;
    	}
    	
    	public Element(){}
    	
    	public Object getData() {
    		return this.data;
    	}
    	
    	public Element getNext() {
    		return this.next;
    	}
    }
    
    
    public Object getHeadValue() throws Exception {
        if (head == null){
            throw new Exception();
        }

        return head.data;
    }
    
    public Object getTailValue() throws Exception {
        if (tail == null){
            throw new Exception();
        }

        return tail.data;
    }
    
    public boolean estaVazia(){
        return head == null; 
    }
    
    public void fazVazia() {
        this.head = null;
        this.tail = null;
    }
    
    public void inserirInicio(Object item){
        Element temporaria = new Element (item, head);
        if (head == null){
            tail = temporaria;
        }
     
        head = temporaria;
    }
    
    public void inserirFim(Object item){
        Element temporaria = new Element(item, null);
        if (head == null){
            head = temporaria;
        } else {
            tail.next = temporaria;
        }
        
        tail = temporaria;
    }
    
    public void atribuir (ListaEncadeada elemento){
        if (elemento != this){
           this.fazVazia();
            for (Element ptr = elemento.head; ptr != null; ptr = ptr.next){
                this.inserirFim(ptr.data);
            }
        }
    }
    
    public void extrair(Object item) throws Exception {
        Element ptr = head;
        Element prevPtr = null;
    
        while (ptr != null && ptr.data!= item){
            prevPtr = ptr;
            ptr = ptr.next; 
        }
    
        if (ptr == null){
            throw new Exception();
        }
    
        if (ptr == head){
            head = ptr.next;
        } else {
            prevPtr.next = ptr.next;
        }
    
        if (ptr == tail){ 
            tail = prevPtr; 
        }
    }
    
    public static void imprimirLista(ListaEncadeada elemento){
    	for (Element ptr = elemento.head; ptr != null; ptr = ptr.next){
            System.out.print("[" + ptr.getData() + "] ");
        }
    }
}

