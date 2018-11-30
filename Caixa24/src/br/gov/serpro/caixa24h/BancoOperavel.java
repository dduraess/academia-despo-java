package br.gov.serpro.caixa24h;

public interface BancoOperavel {
	
	public String consultarExtrato(String nrConta) throws ContaInexistenteException;	
	public Double consultarSaldo(String nrConta) throws ContaInexistenteException;	
	public void realizarTransferencia(String nrContaOrigem, String nrContaDestino, Double valor) throws ContaInexistenteException, SaldoInsuficienteException;	
	public void realizarDeposito(String nrConta, Double valor) throws ContaInexistenteException;	
	public void saque(String nrConta, Double valor) throws ContaInexistenteException, SaldoInsuficienteException;	

}
