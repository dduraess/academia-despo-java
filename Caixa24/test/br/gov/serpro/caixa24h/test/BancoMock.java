package br.gov.serpro.caixa24h.test;

import java.util.List;

import br.gov.serpro.banco.BancoOperavel;
import br.gov.serpro.banco.ContaInexistenteException;
import br.gov.serpro.banco.SaldoInsuficienteException;

public class BancoMock implements BancoOperavel {

	private List<ContaMock> contas;
	private Boolean operacaoValidada;

	public BancoMock(List<ContaMock> contas) {
		this.contas = contas;
		this.operacaoValidada = false;
	}

	@Override
	public String consultarExtrato(String nrConta) throws ContaInexistenteException {
		String historico = "";
		for (ContaMock conta : contas) {
			if (nrConta.equals(conta.obterNrConta())) {
				return historico.concat(conta.extrato());
			} 
		} if (!operacaoValidada) {
			throw new ContaInexistenteException("Conta inexistente!");
		} return null;
	}

	@Override
	public Double consultarSaldo(String nrConta) throws ContaInexistenteException {
		for (ContaMock conta : contas) {
			if (nrConta.equals(conta.obterNrConta())) {
				operacaoValidada = true;
				return conta.obterSaldo();
			} 				
		} if (!operacaoValidada) {
			throw new ContaInexistenteException("Conta inexistente!");
		} return null;
	}

	@Override
	public void realizarTransferencia(String nrContaOrigem, String nrContaDestino, Double valor)
			throws ContaInexistenteException, SaldoInsuficienteException {
		
		for (ContaMock conta : contas) {
			if (nrContaOrigem.equals(conta.obterNrConta())) {
				try {
					conta.enviarTransferencia(nrContaDestino, valor);
					for (ContaMock contaDestino : contas) {
						if (nrContaDestino.equals(contaDestino.obterNrConta())) {
							operacaoValidada = true;
							contaDestino.receberTransferencia(nrContaOrigem, valor);
						}
					}
				} catch (SaldoInsuficienteException e) {
					e.printStackTrace();
				}
			}  
		} if (!operacaoValidada) {
			throw new ContaInexistenteException("Conta inexistente!");
		}
		
	}

	@Override
	public void realizarDeposito(String nrConta, Double valor) throws ContaInexistenteException {
		
	}

	@Override
	public void saque(String nrConta, Double valor) throws ContaInexistenteException {
		for (ContaMock conta : contas) {
			if (nrConta.equals(conta.obterNrConta())) {
				try {
					conta.saque(valor);
					operacaoValidada = true;
				} catch (SaldoInsuficienteException e) {
					e.printStackTrace();
				}
			}  
		} if (!operacaoValidada) {
			throw new ContaInexistenteException("Conta inexistente!");
		}
	}

}
