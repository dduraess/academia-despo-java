package br.gov.serpro.banco.beta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.gov.serpro.banco24h.Operacao;

public class ContaComum extends Conta {
	
	private static final BigDecimal LIMITE = BigDecimal.valueOf(200.00);

	public ContaComum(Integer nrConta, BigDecimal saldoAbertura) {
		this.nrConta = nrConta;
		this.saldo = saldoAbertura;
		this.operacoes = new ArrayList<>();
		this.limite = LIMITE;
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
		
		if (listaOperacoesHoje.size() < 2) {
			return true;
		} else {
			return false;
		}
			
	}

}
