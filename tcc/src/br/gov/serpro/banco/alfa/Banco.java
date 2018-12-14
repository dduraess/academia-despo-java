package br.gov.serpro.banco.alfa;

import java.math.BigDecimal;
import java.util.List;

import br.gov.serpro.banco24h.BancoOperavel;
import br.gov.serpro.banco24h.ContaInexistenteException;
import br.gov.serpro.banco24h.Operacao;
import br.gov.serpro.banco24h.ValorExcedeLimiteException;

public class Banco implements BancoOperavel {
	
	private List<Conta> contas;
	private Conta contaOperacao;
	
	public Banco(List<Conta> contas) {
		this.contas = contas;
	}

	@Override
	public List<Operacao> obterExtrato(Integer numeroConta) {
		return contaOperacao.consultaExtrato();
	}

	@Override
	public BigDecimal obterSaldo() {
		return contaOperacao.consultaSaldo();
	}

	@Override
	public void realizarTransferencia(BigDecimal valor, Integer numeroConta, Integer nrContaDestino)
			throws ValorExcedeLimiteException, QuantidadeOperacoesExcedidaException {
		Conta contaDestinoTransferencia;
		if(isDentroLimiteDiario()) {
			if (!contaOperacao.obterNrConta().equals(nrContaDestino)) {
				for (Conta conta : contas) {
					if (conta.obterNrConta().equals(nrContaDestino)) {
						contaDestinoTransferencia = conta;
						contaOperacao.enviarTransferencia(valor);
						contaDestinoTransferencia.receberTransferencia(valor);
					}
				}
			}
		} else {
			throw new QuantidadeOperacoesExcedidaException ("Quantidade de operações excedida para o dia!");
		}
	}

	@Override
	public void realizarDeposito(BigDecimal valorDeposito, Integer numeroConta) throws OperacaoNaoPermitidaException {
		throw new OperacaoNaoPermitidaException("Operação nao permitida!");
	}

	@Override
	public void sacar(BigDecimal valorSaque, Integer numeroConta) throws ValorExcedeLimiteException, QuantidadeOperacoesExcedidaException {
		if (isDentroLimiteDiario()) {
			contaOperacao.saque(valorSaque);
		} else {
			throw new QuantidadeOperacoesExcedidaException ("Quantidade de operações excedida para o dia!");
		}
	}

	@Override
	public String obterNomeBanco() {
		return "Banco Alfa Ltda.";
	}

	@Override
	public boolean isContaExistente(Integer numeroConta) throws ContaInexistenteException{
		for (Conta conta : contas) {
			if (conta.obterNrConta().equals(numeroConta)) {
				this.contaOperacao = conta;
				return true;
			} 
		} throw new ContaInexistenteException(numeroConta);
	}
	
	public Boolean isDentroLimiteDiario() {
		if (contaOperacao instanceof ContaComum) {
			return ((ContaComum) contaOperacao).isDentroLimiteDiario();
		} else {
			return true;
		}
	}

}
