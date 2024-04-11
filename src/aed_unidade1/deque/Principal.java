package aed_unidade1.deque;

import aed_unidade1.deque.dequeEncadeada.Deque;

public class Principal {
	public static void main(String[] args) throws Exception {
		Deque<String> nomesProfessores = new Deque<>();
		
		nomesProfessores.enfileirarInicio("professor joao marcos");
		nomesProfessores.enfileirarFim("professora laura nunes");
		nomesProfessores.enfileirarFim("professor marcos silveira");
		
		nomesProfessores.imprimir();
		
		System.out.println(nomesProfessores.getPrimeiro());
		System.out.println(nomesProfessores.getUltimo());
	}
}
