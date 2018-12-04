package br.gov.serpro.banco;

import java.math.BigDecimal;
import java.util.List;

import br.gov.serpro.caixa24h.test.Operacao;

public interface BancoOperavel {
	
	public List<Operacao> consultarExtrato(Usuario usuario);	
	public BigDecimal consultarSaldo(Usuario usuario);	
	public void realizarTransferencia(Usuario usuario, String nrContaDestino, BigDecimal valor) throws SaldoInsuficienteException;	
	public void realizarDeposito(Usuario usuario, BigDecimal valor);	
	public void saque(Usuario usuario, BigDecimal valor) throws SaldoInsuficienteException;
	public void validarOperacao(Usuario usuario) throws OperacaoNaoValidadaException;

}
