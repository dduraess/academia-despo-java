package br.gov.serpro.banco24h;

import java.math.BigDecimal;

public interface Banco24H {

	/**
	 * Devolve extrato da conta.
	 * 
	 * @param numeroConta Número da conta.
	 * @return Extrato da conta.
	 */
	Extrato obterExtrato(Integer numeroConta);

	/**
	 * Devolve o saldo disponível na conta.
	 * 
	 * @param numeroConta Número da conta.
	 * @return Valor do saldo disponível.
	 */
	BigDecimal obterSaldo(Integer numeroConta);

	/**
	 * Realiza transferência de valor para o mesmo banco.
	 * @param valor Valor a ser transferido.
	 * @param numeroConta Número da conta origem.
	 * @param numeroContaDestino Número da conta destino.
	 * @throws ValorExcedeLimiteException se valor desejado ultrapassa limite
	 *                                    disponível
	 */
	void realizarTransferencia(BigDecimal valor, Integer numeroConta, Integer numeroContaDestino) throws ValorExcedeLimiteException;

	/**
	 * Deposita um valor na conta corrente.
	 * 
	 * @param numeroConta Número da conta.
	 * @param valorDeposito Valor a ser depositado.
	 */
	void realizarDeposito(BigDecimal valorDeposito, Integer numeroConta);

	/**
	 * Efetua saque do valor desejado, incluindo limite.
	 * 
	 * @param valorSaque  Valor a ser sacado, incluindo limite, se existir.
	 * @param numeroConta Número da conta.
	 * @return Novo saldo da conta.
	 * @throws ValorExcedeLimiteException se valor desejado ultrapassa limite
	 *                                    disponível
	 */
	BigDecimal sacar(BigDecimal valorSaque, Integer numeroConta) throws ValorExcedeLimiteException;

	/**
	 * Devolve o nome do banco.
	 * 
	 * @return Nome do banco.
	 */
	public abstract String obterNomeBanco();

	/**
	 * Devolve se existe a conta especificada. return Se existe a conta.
	 */
	boolean isContaExistente(Integer numeroConta);

}
