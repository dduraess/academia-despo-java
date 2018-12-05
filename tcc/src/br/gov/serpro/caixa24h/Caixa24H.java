package br.gov.serpro.caixa24h;

import java.math.BigDecimal;

import br.gov.serpro.banco24h.Banco24H;
import br.gov.serpro.banco24h.ContaInexistenteException;
import br.gov.serpro.banco24h.Extrato;
import br.gov.serpro.banco24h.ValorExcedeLimiteException;

public class Caixa24H {

	private Banco24H banco;
	private Integer numeroConta;

	public Caixa24H(Banco24H banco, Integer numeroConta) throws ContaInexistenteException {
		conectarComBanco(banco, numeroConta);
	}

	public void conectarComBanco(Banco24H banco, Integer numeroConta) throws ContaInexistenteException {
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
	public Extrato obterExtrato() {
		return banco.obterExtrato(numeroConta);
	}

	/**
	 * Devolve o saldo disponível na conta.
	 * 
	 * @return Valor do saldo disponível.
	 */
	public BigDecimal obterSaldo() {
		return banco.obterSaldo(numeroConta);
	}

	/**
	 * Realiza transferência para conta destino no mesmo banco.
	 * 
	 * @param valor              Valor a ser transferido.
	 * @param numeroContaDestino Conta a receber o valor.
	 */
	public void realizarTransferencia(BigDecimal valor, Integer numeroContaDestino) throws ValorExcedeLimiteException {
		banco.realizarTransferencia(valor, numeroConta, numeroContaDestino);
	}

	/**
	 * Deposita um valor na conta corrente.
	 * 
	 * @param valorDeposito Valor a ser depositado.
	 */
	public void realizarDeposito(BigDecimal valorDeposito) {
		banco.realizarDeposito(valorDeposito, numeroConta);
	}

	/**
	 * Efetua saque do valor desejado, incluindo limite.
	 * 
	 * @param valorSaque Valor a ser sacado, incluindo limite, se existir.
	 * @return Novo saldo da conta.
	 * @throws ValorExcedeLimiteException se valor desejado ultrapassa limite
	 *                                    disponível
	 */
	public BigDecimal sacar(BigDecimal valorSaque) throws ValorExcedeLimiteException {
		return banco.sacar(valorSaque, numeroConta);
	}

}
