package aed_unidade1.pilha.listaEncadeada;

public class Element<Tipo> {
	private Tipo data;
	private Element<Tipo> next;
	
	public Element(Tipo data) {
		this.data = data;
		this.next = null;
	}
	
	public Tipo getData() {
		return this.data;
	}
	
	public Element<Tipo> getNext() {
		return this.next;
	}

	public void setNext(Element<Tipo> novoItem) {
		this.next = novoItem;
		
	}
}
