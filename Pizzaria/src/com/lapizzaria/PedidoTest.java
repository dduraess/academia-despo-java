package com.lapizzaria;

import static org.junit.Assert.*;

import org.junit.Test;

public class PedidoTest {

	@Test
	public void test() {
//		fail("Not yet implemented");
		byte qtdePizzas = 2;
		Pizza[] lista= new Pizza[qtdePizzas];
		Pizza pizza1 = new Pizza("atum", "atum", "cebola", null);
		Pizza pizza2 = new Pizza("calabreza", "muzzarela", "calabreza", "cebola");
		Entrega entrega = new Entrega("R. Antonio Soares, 15 - Mooca", 8.3);
		lista[0]= pizza1;
		lista[1]= pizza2;
//		assertEquals(pizza1.getPreco(), 31.40);
		Pedido meuPedido = new Pedido(1, lista, entrega);
		meuPedido.imprimePedido();
	}

}
