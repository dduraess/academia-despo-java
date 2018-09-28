package org.comun.venda.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.comun.venda.Cliente;
import org.comun.venda.Pedido;
import org.junit.Before;

public class PedidoTest {

	@Before
	public void testCriarObjetos() {
		
		Date hoje = new Date();
//		Pedido novoPedidoNovoCliente = new Pedido(hoje, , detalhes, pagamento);
		List<Pedido> pedidos = new ArrayList<>();
		Cliente novoCliente = new Cliente("nome", "endereco", pedidos);

	}

}
