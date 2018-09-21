package org.comun.almoxarifado.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlmoxarifadoTest {
	
	/**
	 * O almoxarifado de uma empresa estoca materiais e deve fazer o controle disso. 
	 * Para cada material ali depositado, deve-se saber o seu código  numérico, seu nome e o seu saldo (quantidade em estoque 
	 * no momento). O saldo pode ser alterado quando há retiradas ou abastecimentos, o nome pode ser mudado e deve-se mostrar 
	 * os dados do material quando necessário. O sistema deve permitir as operações de entrada e saída do estoque e montar uma 
	 * lista de produtos em estoque.
	 * 
	 */

	@Test
	public void qtdeEstoqueVazio() {
		
//		dado que
//		eu tenho um estoque vazio
		Estoque estoque = new Estoque();
		
//		quando
//		eu requisitar a qtde total de materiais deste estoque
		int qtde = estoque.qtdeTotalDeMateriais();
		
//		entao
//		a qtde de materiais estocados é zero
		assertEquals(0, (int) qtde);
		
	}

	@Test
	public void qtdeEstoqueComAbastecimento() {
		
//		dado que
//		eu tenho um estoque vazio
		Estoque estoque = new Estoque();
		int cdNumerico = 1;
		Material material = new Material(cdNumerico);
		estoque.abastecer(material);
		
//		quando
//		eu requisitar a qtde total de materiais deste estoque
		int qtde = estoque.qtdeTotalDeMateriais();
		
//		entao
//		verifica a qtde de materiais estocados 
		assertEquals(1, (int) qtde);
		
	}

	@Test
	public void qtdeEstoqueAposRetirada() {
		
//		dado que
//		eu tenho um estoque vazio
		Estoque estoque = new Estoque();
		int cdNumerico = 1;
		Material material = new Material(cdNumerico);
		estoque.abastecer(material);
		estoque.retirar(material);
		
//		quando
//		eu efetuar retirada
		int qtde = estoque.qtdeTotalDeMateriais();
		
//		entao
//		verifica a qtde de materiais estocados sem o material retirado
		assertEquals(0, (int) qtde);
		
	}

	@Test
	public void qtdeEstoqueAposRetiradaSemMaterial() {
		
//		dado que
//		eu tenho um estoque vazio
		Estoque estoque = new Estoque();
		Material material = new Material(1);
		Material material2 = new Material(2);
		estoque.abastecer(material);
		
//		quando
//		eu efetuar retirada
		int qtde = estoque.qtdeTotalDeMateriais();
		estoque.retirar(material2);
		
//		entao
//		verifica a qtde de materiais seja a mesma
		assertEquals(1, (int) qtde);
		
	}

}
