package org.comun.venda.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.comun.venda.Cliente;
import org.comun.venda.DetalhePedido;
import org.comun.venda.Dinheiro;
import org.comun.venda.Pedido;
import org.comun.venda.Pedido.StatusPedido;
import org.junit.Before;

public class PedidoTest {

	@Before
	public void testCriarObjetos() {
		
		Date hoje = new Date();
		List<Pedido> pedidos = new ArrayList<>();
		List<DetalhePedido> detalhes = new ArrayList<>();
		Dinheiro pagto;
		Pedido novoPedidoNovoCliente = new Pedido(hoje, StatusPedido.ABERTO, detalhes, pagto = new Dinheiro(100.00));
		Cliente novoCliente = new Cliente("nome", "endereco", pedidos);
		
		

	}

}
