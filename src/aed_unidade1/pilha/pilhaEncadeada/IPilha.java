package aed_unidade1.pilha.pilhaEncadeada;

public interface IPilha<Tipo> {
	
	public void fazVazia ();

	public boolean estaVazia();

	public Tipo getTop() throws Exception;
	
	public void push(Tipo item);
	
	public Tipo pop() throws Exception;
	
	public void extrair (Tipo item) throws Exception;
}
