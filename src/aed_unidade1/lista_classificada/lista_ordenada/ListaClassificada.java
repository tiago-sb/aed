package aed_unidade1.lista_classificada.lista_ordenada;

public class ListaClassificada<T> implements IListaClassificada<T>{
	private Element<T> head;
	private Element<T> tail;
	private int numeroElementos;
	
	public ListaClassificada(){
		this.head = null;
		this.tail = null;
		numeroElementos = 0;
	}
	
	public final class Element<E> {
	    private T data;
	    private Element<T> next;
	    private Element<T> previous;

	    public Element(T data, Element<T> next, Element<T> previous) {
	      this.data = data;
	      this.next = next;
	      this.previous = previous;
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

	    public Element<T> getPrevious() {
	      return this.previous;
	    }

	    public void setNext(Element<T> next) {
	      this.next = next;
	    }

	    public void setPrevious(Element<T> previous) {
	      this.previous = previous;
	    }
	    
	    /**
	     * Metodo para comparar o valor contido em objetos.
	     * Caso o novo objeto a ser comparado tenha valor menor do que o objeto que chamou
	     * o metodo, retorna -1, caso for igual, retorna 0 e caso for menor, retorna 1.
	     * Esse metodo auxiliara na insercao de objetos na lista
	     * @param dado
	     * @return
	     * @throws Exception
	     */
	    public int comparesTo(T dado) throws Exception {
	      if(dado instanceof Integer) {
	        if((Integer) this.getData() < (Integer) dado) { return -1; }
	        if((Integer) this.getData() == (Integer) dado) { return 0; }
	        if((Integer) this.getData() > (Integer) dado) { return 1; }
	      } 
	      if(dado instanceof Float) {
			  if((Float) this.getData() < (Float) dado) { return -1; }
			  if((Float) this.getData() == (Float) dado) { return 0; }
			  if((Float) this.getData() > (Float) dado) { return 1; }
                
	      }
	      if(dado instanceof Double) {
	    	  if((Double) this.getData() < (Double) dado) { return -1; }
    	  	  if((Double) this.getData() == (Double) dado) { return 0; }
		      if((Double) this.getData() > (Double) dado) { return 1; }
	      }
	      if (dado instanceof String) {
	        if (((String) this.getData()).compareToIgnoreCase((String) dado) < 0) { return -1; }
	        if (((String) this.getData()).compareToIgnoreCase((String) dado) == 0) { return 0; }
	        if (((String) this.getData()).compareToIgnoreCase((String) dado) > 0) { return 1; }
	      }
	      
	      throw new Exception();
	    }
	}
	
	public boolean estaVazia() {
		return this.numeroElementos == 0;
	}

	public T get (int offset) {
		if (offset < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(offset >= this.numeroElementos) {
			throw new IndexOutOfBoundsException();
		}
		
		Element<T> elemento;
		
		elemento = this.head;
		for(int indice = 0; indice < offset && elemento != null; indice = indice + 1) {
			elemento = elemento.getNext();
		}

		return elemento.getData();
	}
	
	private void inserirInicio(T data) {
		Element<T> novoElemento = new Element<>(data, this.head, null);
	    
	    if (this.head == null) {
	      this.head = novoElemento;
	      this.tail = novoElemento;
	    } else {
	      this.head.setPrevious(novoElemento);
	      this.head = novoElemento;
	    }
	}

	public void inserirFim(T data) {
	    Element<T> novoElemento = new Element<>(data, null, this.tail);
	    
	    if (this.head == null) {
	      this.head = novoElemento;
	      this.tail = novoElemento;
	    } else {
	      this.tail.setNext(novoElemento);
	      this.tail = novoElemento;
	    }
	}
	
	public Cursor<T> procurarPosicao (T objetoEscolhido) throws Exception {
		Element<T> elemento;

		for (elemento = this.head; elemento != null; elemento = elemento.getNext()){
			if (elemento.getData().equals(objetoEscolhido)) {
				break;
			}
		}

		return new Cursor<T>(elemento);
	}

	public boolean eMembro(T objetoEscolhido) {
		Element<T> elemento;

		for (elemento = this.head; elemento != null; elemento = elemento.getNext()){
			if (elemento.getData().equals(objetoEscolhido)) {
				return true;
			}
		}

		return false;
	}
	
	public void inserir(T data) throws Exception {
	    Element<T> novoElemento = new Element<>(data, null, null);
	    Cursor<T> cursor = new Cursor<>(novoElemento);
	    
	    if (this.head == null) {
	    	// se o head for nulo e o dado nao for de um tipo primitivo aceito, envia uma excessao
	    	if(!(data instanceof Integer) && !(data instanceof String) && !(data instanceof Float) && !(data instanceof Double)) {
	    	  throw new Exception();
	    	}
	      
	        this.inserirInicio(data);
	        this.numeroElementos = this.numeroElementos + 1;
	        return;
	    }

    	// inserir no inicio caso o valor do cursor for menor do que o head
	    // evita repeticao desnecessaria
	    if((cursor.getElemento().comparesTo(this.head.getData()) <= 0)) {
	    	// se o valor do head comparado ao novoElemento for maior, insere o novoElemento
	    	// no inicio da lista
	    	this.inserirInicio(novoElemento.getData());
	    	this.numeroElementos = this.numeroElementos + 1;
	    	return;
	    }

	    if(this.tail.comparesTo(cursor.getElemento().getData()) <= 0) {
			this.inserirFim(novoElemento.getData());
			this.numeroElementos = this.numeroElementos + 1;
			return;
	    }

	    for(Element<T> auxiliar = this.head; auxiliar != null; auxiliar = auxiliar.getNext()) {
	    	// so ira inserir quando o valor do auxiliar for maior que o novoElemento
	    	if(cursor.getElemento().comparesTo(auxiliar.getData()) <= 0) {
		        Element<T> anterior = auxiliar.getPrevious(); 
	    		anterior.setNext(novoElemento);
		        
	    		auxiliar.setPrevious(novoElemento);
		        novoElemento.setNext(auxiliar);
		        novoElemento.setPrevious(anterior);
		        
		        this.numeroElementos = this.numeroElementos + 1;
		        return;
	        }
	    }
    }
	
	public void remover(T data) throws Exception {
		if(this.head == null) {
			throw new Exception();
	    } else {
    		for(Element<T> auxiliar = this.head; auxiliar != null; auxiliar = auxiliar.getNext()) {
    			if (auxiliar.getData().equals(data)) {
  		            if(auxiliar == this.head) {
  		                this.head = auxiliar.getNext();
		                if(this.head != null) {
	  		                this.head.setPrevious(null);
		                }
  		            }else if (auxiliar == this.tail) {
  		              this.tail = auxiliar.getPrevious();
  		              if(this.tail != null) {
  		                this.tail.setNext(null);
  		              }
  		          } else {
  		            auxiliar.getPrevious().setNext(auxiliar.getNext());
  		            auxiliar.getNext().setPrevious(auxiliar.getPrevious());
  		          }
  		            
  		          return;
  		        }
    		}		      
    		
    		throw new Exception();
	    }
    }

	public T procurar(T objetoEscolhido) {
		for (Element<T> elemento = this.head; elemento != null; elemento = elemento.getNext()){
			if(elemento.getData().equals(objetoEscolhido)) {
				return elemento.getData();
			}		
		}

		return null;
	}
	
	public int getTamanho() {
	    Element<T> aux = this.head;
	    int tamanho = 0;
	    while (aux != null) {
	      tamanho = tamanho + 1;
	      aux = aux.getNext();
	    }
	    return tamanho;
	}
	
	public void imprimir() {
		System.out.print("[");
		for (Element<T> elemento = this.head; elemento != null; elemento = elemento.getNext()) {
			if(elemento.equals(this.tail)) {
            	System.out.print(elemento.getData());
            }
    		if(!elemento.equals(this.tail)) {
    			System.out.print(elemento.getData() + ", ");
    		}
		}
		System.out.println("]");
	}
}