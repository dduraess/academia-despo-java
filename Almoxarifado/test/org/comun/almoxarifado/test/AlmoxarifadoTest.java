package org.comun.almoxarifado.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlmoxarifadoTest {
	
	/**
	 * O almoxarifado de uma empresa estoca materiais e deve fazer o controle disso. 
	 * Para cada material ali depositado, deve-se saber o seu c�digo  num�rico, seu nome e o seu saldo (quantidade em estoque 
	 * no momento). O saldo pode ser alterado quando h� retiradas ou abastecimentos, o nome pode ser mudado e deve-se mostrar 
	 * os dados do material quando necess�rio. O sistema deve permitir as opera��es de entrada e sa�da do estoque e montar uma 
	 * lista de produtos em estoque.
	 * 
	 */

	@Test
	public void qtdeMaterialEstocado() {
		
//		dado que
//		eu tenho um estoque vazio
		Estoque estoque = new Estoque();
		
//		quando
//		eu requisitar a qtde total de materiais deste estoque
		int qtdeTotalDeMateriais = estoque.qtdeTotalDeMateriais();
		
//		entao
//		a qtde de materiais estocados � zero
		assertEquals(0, qtdeTotalDeMateriais);
		
	}

}
