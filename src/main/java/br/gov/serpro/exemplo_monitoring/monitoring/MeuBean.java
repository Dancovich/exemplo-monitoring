package br.gov.serpro.exemplo_monitoring.monitoring;

import javax.inject.Named;

@Named
public class MeuBean {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
