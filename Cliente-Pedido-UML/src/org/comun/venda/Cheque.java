package org.comun.venda;

public class Cheque extends Pagamento {
	
	private String nomeBanco;
	private int idBanco;
	
	public Cheque(String nomeBanco, int idBanco, int qtde) {
		super(qtde);
		this.nomeBanco = nomeBanco;
		this.idBanco = idBanco;
	}

	@Override
	public String tipoPagto() {
		// TODO Auto-generated method stub
		return "Cheque";
	}

}
