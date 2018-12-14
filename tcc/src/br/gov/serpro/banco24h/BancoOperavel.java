package br.gov.serpro.banco24h;

import java.math.BigDecimal;
import java.util.List;

public interface BancoOperavel {
	
	/*
	 *  - Método obterNomeBanco não precisa de "public abstract". Estamos dentro de uma interface.
     *  - O nome de interfaces deve seguir um padrão diferente do nome de classes. Banco24H talvez 
     *  não seja um bom nome para uma interface. Veja o nome das interfaces nativas do Java para 
     *  entender melhor: Comparable, Iterable, Serializable, etc. Elas indicam alguma ação que 
     *  objetos que implementam aquela interface é capaz de realizar.
	 */

	/**
	 * Devolve extrato da conta.
	 * 
	 * @param numeroConta Número da conta.
	 * return Extrato da conta. --> Não consegui fazer retornar um filho de Extrato
	 * alterei para uma lista de operações  
	 */
	List<Operacao> obterExtrato(Integer numeroConta);

	/**
	 * Devolve o saldo disponível na conta.
	 * 
	 * param numeroConta Número da conta (removido, pois é passado no construtor do caixa).
	 * @return Valor do saldo disponível.
	 */
	BigDecimal obterSaldo();

	/**
	 * Realiza transferência de valor para o mesmo banco.
	 * @param valor Valor a ser transferido.
	 * @param numeroConta Número da conta origem.
	 * @param numeroContaDestino Número da conta destino.
	 * @throws ValorExcedeLimiteException se valor desejado ultrapassa limite
	 *                                    disponível
	 * @throws OperacaoRestritaException 
	 */
	void realizarTransferencia(BigDecimal valor, Integer numeroConta, Integer numeroContaDestino) throws ValorExcedeLimiteException, OperacaoRestritaException;

	/**
	 * Deposita um valor na conta corrente.
	 * 
	 * @param numeroConta Número da conta.
	 * @param valorDeposito Valor a ser depositado.
	 * @throws OperacaoRestritaException 
	 */
	void realizarDeposito(BigDecimal valorDeposito, Integer numeroConta) throws OperacaoRestritaException;

	/**
	 * Efetua saque do valor desejado, incluindo limite.
	 * 
	 * @param valorSaque  Valor a ser sacado, incluindo limite, se existir.
	 * @param numeroConta Número da conta.
	 * return Novo saldo da conta. Alterei para void, porque não vou usar esse saldo em lugar nenhum.
	 * @throws ValorExcedeLimiteException se valor desejado ultrapassa limite disponível
	 * @throws OperacaoRestritaException 
	 * 
	 */
	void sacar(BigDecimal valorSaque, Integer numeroConta) throws ValorExcedeLimiteException, OperacaoRestritaException;

	/**
	 * Devolve o nome do banco.
	 * 
	 * @return Nome do banco.
	 */
	String obterNomeBanco();

	/**
	 * Devolve se existe a conta especificada. return Se existe a conta.
	 */
	boolean isContaExistente(Integer numeroConta) throws ContaInexistenteException;

}
