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

	public static enum StatusPedido {
		
		ABERTO, PAGO, ENVIADO, RECEBIDO
		
	}
	
	public Double calcTaxa() {
		Double somaTaxa = 0.0;
		Double valorImposto = 0.6;
		for (DetalhePedido detalhePedido:detalhes) {
			if (detalhePedido.getStatusImposto()== DetalhePedido.StatusImposto.POR_CONTA_COMPRADOR) {
				somaTaxa += detalhePedido.calcSubTotal() * valorImposto;
			} somaTaxa += 0.0;
		} return somaTaxa;

	}

    public Double calcTotalPeso() {
        Double somaTotalPeso = 0.0;
        for (DetalhePedido detalhePedido:detalhes) {
            somaTotalPeso += detalhePedido.calcPeso();
        } return somaTotalPeso;
    }

	public Double calcTotal() {
	    Double somaTotal = 0.0;
        for (DetalhePedido detalhePedido:detalhes) {
            somaTotal += detalhePedido.calcSubTotal();
        } return somaTotal + calcTaxa() + calcTotalPeso();
    }
}
