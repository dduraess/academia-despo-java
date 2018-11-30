package br.gov.serpro.caixa24h;

public class Caixa24h {
	
	private BancoOperavel bancoDaOperacao;
	private String contaUsuario;

	public Caixa24h(BancoOperavel bancoDaOperacao, String nrConta) {
		this.bancoDaOperacao = bancoDaOperacao;
		this.contaUsuario = nrConta;
	}
	
	public String consultarExtratoCaixa24h() throws ContaInexistenteException {
		return bancoDaOperacao.consultarExtrato(contaUsuario);
	}
	
	public Double consultarSaldoCaixa24h() throws ContaInexistenteException {
		return bancoDaOperacao.consultarSaldo(contaUsuario);
	}
	
	public void realizarTransferenciaCaixa24h(String nrContaDestino, Double valor) throws ContaInexistenteException, SaldoInsuficienteException {
		bancoDaOperacao.realizarTransferencia(contaUsuario, nrContaDestino, valor);
	}
	
	public void realizarDepositoCaixa24h(Double valor) throws ContaInexistenteException {
		bancoDaOperacao.realizarDeposito(contaUsuario, valor);
	}
	
	public void realizarSaqueCaixa24h(Double valor) throws ContaInexistenteException, SaldoInsuficienteException {
		bancoDaOperacao.saque(contaUsuario, valor);
	}

}
