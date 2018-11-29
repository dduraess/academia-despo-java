package br.gov.serpro.caixa24h;

public class Caixa24h {
	
	private BancoOperavel bancoDaOperacao;
	private String contaUsuario;

	public Caixa24h(BancoOperavel bancoDaOperacao, String nrConta) {
		this.bancoDaOperacao = bancoDaOperacao;
		this.contaUsuario = nrConta;
	}
	
	public String consultarExtratoCaixa24h() {
		return bancoDaOperacao.consultarExtrato(contaUsuario);
	}
	
	public Double consultarSaldoCaixa24h() {
		return bancoDaOperacao.consultarSaldo(contaUsuario);
	}
	
	public void realizarTransferenciaCaixa24h(String nrContaDestino, Double valor) {
		bancoDaOperacao.realizarTransferencia(contaUsuario, nrContaDestino, valor);
	}
	
	public void realizarDepositoCaixa24h(Double valor) {
		bancoDaOperacao.realizarDeposito(contaUsuario, valor);
	}
	
	public void realizarSaqueCaixa24h(Double valor) {
		bancoDaOperacao.saque(contaUsuario, valor);
	}

}
