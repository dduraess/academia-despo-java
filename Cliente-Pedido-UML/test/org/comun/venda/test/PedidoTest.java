package org.comun.venda.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.comun.venda.Cliente;
import org.comun.venda.DetalhePedido;
import org.comun.venda.Pagamento;
import org.comun.venda.Pedido;
import org.comun.venda.Pedido.StatusPedido;
import org.junit.Before;

public class PedidoTest {

	@Before
	public void testCriarObjetos() {
		
		Date hoje = new Date();
		List<Pedido> pedidos = new ArrayList<>();
		List<DetalhePedido> detalhes = new ArrayList<>();
		Pagamento pagamento = new Pagamento();
		Pedido novoPedidoNovoCliente = new Pedido(hoje, StatusPedido.ABERTO, detalhes, pagamento);
		Cliente novoCliente = new Cliente("nome", "endereco", pedidos);

	}

}
