package br.gov.serpro.caixa24h;

import java.math.BigDecimal;
import java.util.List;

import br.gov.serpro.banco.BancoOperavel;
import br.gov.serpro.banco.SaldoInsuficienteException;
import br.gov.serpro.banco.Usuario;
import br.gov.serpro.caixa24h.test.Operacao;

public class Caixa24h {
	
	private BancoOperavel bancoOperacao;
	private Usuario usuario;

	public Caixa24h(BancoOperavel bancoOperacao, Usuario usuario) {
		this.bancoOperacao = bancoOperacao;
		this.usuario = usuario;
	}
	
	public List<Operacao> consultarExtrato() {
		return bancoOperacao.consultarExtrato(usuario);
	}
	
	public BigDecimal consultarSaldo() {
		return bancoOperacao.consultarSaldo(usuario);
	}
	
	public void realizarTransferencia(String nrContaDestino, BigDecimal valor) throws SaldoInsuficienteException {
		bancoOperacao.realizarTransferencia(usuario, nrContaDestino, valor);
	}
	
	public void realizarDeposito(BigDecimal valor) {
		bancoOperacao.realizarDeposito(usuario, valor);
	}
	
	public void realizarSaque(BigDecimal valor) throws SaldoInsuficienteException {
		bancoOperacao.saque(usuario, valor);
	}

}
