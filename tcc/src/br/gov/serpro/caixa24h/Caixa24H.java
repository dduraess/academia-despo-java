package br.gov.serpro.caixa24h;

import java.math.BigDecimal;
import java.util.List;

import br.gov.serpro.banco24h.BancoOperavel;
import br.gov.serpro.banco24h.ContaInexistenteException;
import br.gov.serpro.banco24h.Operacao;
import br.gov.serpro.banco24h.OperacaoRestritaException;
import br.gov.serpro.banco24h.ValorExcedeLimiteException;

public class Caixa24H {

	private BancoOperavel banco;
	private Integer numeroConta;

	public Caixa24H(BancoOperavel banco, Integer numeroConta) throws ContaInexistenteException {
		conectarComBanco(banco, numeroConta);
	}

	public void conectarComBanco(BancoOperavel banco, Integer numeroConta) throws ContaInexistenteException {
		if (banco == null) {
			throw new IllegalArgumentException("Banco invalido para caixa 24h.");
		}
		if (!banco.isContaExistente(numeroConta)) {
			throw new ContaInexistenteException(numeroConta);
		}
		this.banco = banco;
		this.numeroConta = numeroConta;
	}

	/**
	 * Devolve extrato da conta.
	 * 
	 * @return Extrato da conta.
	 */
	public List<Operacao> obterExtrato() {
		return banco.obterExtrato(numeroConta);
	}

	/**
	 * Devolve o saldo disponível na conta.
	 * 
	 * @return Valor do saldo disponível.
	 */
	public BigDecimal obterSaldo() {
		return banco.obterSaldo();
	}

	/**
	 * Realiza transferência para conta destino no mesmo banco.
	 * 
	 * @param valor              Valor a ser transferido.
	 * @param numeroContaDestino Conta a receber o valor.
	 */
	public void realizarTransferencia(BigDecimal valor, Integer numeroContaDestino) throws ValorExcedeLimiteException, OperacaoRestritaException {
			banco.realizarTransferencia(valor, numeroConta, numeroContaDestino);
	}

	/**
	 * Deposita um valor na conta corrente.
	 * 
	 * @param valorDeposito Valor a ser depositado.
	 * @throws OperacaoRestritaException 
	 */
	public void realizarDeposito(BigDecimal valorDeposito) throws OperacaoRestritaException {
		banco.realizarDeposito(valorDeposito, numeroConta);
	}

	/**
	 * Efetua saque do valor desejado, incluindo limite.
	 * 
	 * @param valorSaque Valor a ser sacado, incluindo limite, se existir.
	 * return Novo saldo da conta. Alterei para void, porque não vou usar esse saldo em lugar nenhum.
	 * @throws ValorExcedeLimiteException se valor desejado ultrapassa limite
	 *                                    disponível
	 */
	public void sacar(BigDecimal valorSaque) throws ValorExcedeLimiteException, OperacaoRestritaException {
		banco.sacar(valorSaque, numeroConta);
	}

}
