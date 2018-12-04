package br.gov.serpro.caixa24h.test;

import br.gov.serpro.banco.Usuario;

public class CorrentistaMock extends Usuario {

	public CorrentistaMock(String nome, ContaMock conta) {
		super(nome, conta);
	}

}
