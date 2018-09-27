package org.comun.venda;

import java.util.Date;

public class Pedido {
	
	private Date dataEntrada;
	private DetalhePedido[] detalhes;
	
	public Pedido(Date dataEntrada, DetalhePedido[] detalhes) {
		super();
		this.dataEntrada = dataEntrada;
		this.detalhes = detalhes;
	}

	public enum StatusPedido {
		
		EM_PROCESSAMENTO, PAGO, ENVIADO, RECEBIDO;
		
	}
	
	
	
}
