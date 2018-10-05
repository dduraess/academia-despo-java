package org.comun.venda;

import java.util.Date;

public class Credito extends Pagamento {

    private int numero;
    private String tipo;
    private Date dataExp;
    
    public Credito(int numero, String tipo, Date dataExp, int qtde) {
		super(qtde);
		this.numero = numero;
		this.tipo = tipo;
		this.dataExp = dataExp;
	}

	public boolean isAutorizado() {
        return false;
    }

	@Override
	public String tipoPagto() {
		return "Cartão de Crédito";
		
	}
}
