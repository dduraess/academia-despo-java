package br.gov.serpro.caixa24h;

public interface BancoOperavel {
	
	public String consultarExtrato(String nrConta);	
	public Double consultarSaldo(String nrConta);	
	public void realizarTransferencia(String nrContaOrigem, String nrContaDestino, Double valor);	
	public void realizarDeposito(String nrConta, Double valor);	
	public void saque(String nrConta, Double valor);	

}
