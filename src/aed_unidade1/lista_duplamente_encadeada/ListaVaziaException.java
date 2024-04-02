package aed_unidade1.lista_duplamente_encadeada;

import java.util.NoSuchElementException;

public class ListaVaziaException extends NoSuchElementException {
	
	private static final long serialVersionUID = 1L;
	
	public ListaVaziaException() {
		super("lista esta vazia");
	}
	
	public ListaVaziaException(String erro) {
		super(erro);
	}
}
