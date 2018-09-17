package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.lapizzaria.Entrega;
import com.lapizzaria.Pedido;
import com.lapizzaria.Pizza;

public class PedidoTest {
	
	Pizza[] lista;
	Pizza pizza1;
	Pizza pizza2;
	byte qtdePizzas = 2;
	Pedido meuPedido;

	@Before
	public void testCriarPedido() {
		
//		fail("Not yet implemented");
		lista = new Pizza[qtdePizzas];
		pizza1 = new Pizza("atum", "atum", "cebola", null);
		pizza2 = new Pizza("calabreza", "muzzarela", "calabreza", "cebola");
		Entrega entrega = new Entrega("R. Antonio Soares, 15 - Mooca", 8.3);
		lista[0]= pizza1;
		lista[1]= pizza2;
		meuPedido = new Pedido(1, lista, entrega);
	}
	
	@Test
	public void testarPrecoItem() {
		
		assertEquals(31.40, pizza1.getPreco(), 31.40);
		assertEquals(39.699999999999996, pizza2.getPreco(), 39.699999999999996);

	}
	
	@Test
	public void testarPrecoPedido() {
		
		assertEquals(75.25, meuPedido.calcularValor(), 75.25);

	}

}
