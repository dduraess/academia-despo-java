package org.comun.venda;

import java.util.Date;
import java.util.List;

public class Pedido {
	
	private Date dataEntrada;
	private StatusPedido status;
	private List<DetalhePedido> detalhes;
	private Pagamento pagamento;
	
	public Pedido(Date dataEntrada, StatusPedido status, List<DetalhePedido> detalhes, Pagamento pagamento) {
		super();
		this.dataEntrada = dataEntrada;
		this.detalhes = detalhes;
		this.status = status;
		this.pagamento = pagamento;
	}

	public enum StatusPedido {
		
		ABERTO, PAGO, ENVIADO, RECEBIDO;
		
	}
	
	public Double calcTaxa() {
		for (:
			 ) {
			
		}
	}
	
}
