package aed_unidade1.fila.excecao;

public class ContainerVazioException extends Exception {
	private static final long serialVersionUID = 1L;

	public ContainerVazioException() {
		super("container esta vazio");
	}
}
