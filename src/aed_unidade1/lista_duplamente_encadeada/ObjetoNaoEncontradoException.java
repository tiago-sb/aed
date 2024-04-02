package aed_unidade1.lista_duplamente_encadeada;

import java.lang.IllegalArgumentException;

public class ObjetoNaoEncontradoException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;
	
	public ObjetoNaoEncontradoException() {
		super();
	}
	
	public ObjetoNaoEncontradoException(String erro) {
		super(erro);
	}
}
