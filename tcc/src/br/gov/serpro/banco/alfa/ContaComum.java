package br.gov.serpro.banco.alfa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.gov.serpro.banco24h.Operacao;
import br.gov.serpro.banco24h.ValorExcedeLimiteException;

public class ContaComum extends Conta {

	public ContaComum(Integer nrConta, BigDecimal saldoAbertura) {
		this.nrConta = nrConta;
		this.saldo = saldoAbertura;
		this.operacoes = new ArrayList<>();
	}

	@Override
	public void enviarTransferencia(BigDecimal valor)
			throws ValorExcedeLimiteException {
		if (saldo.compareTo(valor) >= 0) {
			Operacao transferencia = new Operacao(consultaSaldo(), "Transferência", valor);
			operacoes.add(transferencia);
			saldo = saldo.subtract(valor);
		} else {
			throw new ValorExcedeLimiteException("Valor excede limite!", "Banco alfa", this.nrConta);
		}
		
	}

	@Override
	public void saque(BigDecimal valor) throws ValorExcedeLimiteException {
		if (saldo.compareTo(valor) >= 0) {
			Operacao saque = new Operacao(consultaSaldo(), "Saque", valor);
			operacoes.add(saque);
			saldo = saldo.subtract(valor);
		} else {
			throw new ValorExcedeLimiteException("Valor excede limite!", "Banco alfa", this.nrConta);
		}

	}
	
	public Boolean isDentroLimiteDiario () {
		
		List<Operacao> listaOperacoesHoje = new ArrayList<>();
		for (Operacao operacao : operacoes) {
			LocalDate hoje = LocalDate.now();
			LocalDate dataOperacao = operacao.getDataHora().toLocalDate();
			if (dataOperacao.compareTo(hoje) == 0) {
				listaOperacoesHoje.add(operacao); 
			}
		}
		
		if (listaOperacoesHoje.size() < 3) {
			return true;
		} else {
			return false;
		}
			
	}

}
