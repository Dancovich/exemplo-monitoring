package br.gov.serpro.exemplo_monitoring.monitoring;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.frameworkdemoiselle.monitoring.stereotype.MBean;

@MBean
public class Exemplo implements ExemploMBean{
	
	private int valor;
	
	@Inject
	private MeuBean meuBean;
	
	@Inject
	private EntityManager dao;

	@Override
	public int getValor() {
		try{
			meuBean.setNome("Teste");
		}
		catch(Throwable t){
			t.printStackTrace();
		}
		
		return valor;
	}

	@Override
	public void setValor(int valor) {
		this.valor = valor;
		
	}

	@Override
	public int getQtdBookmarks() {
		try{
			Number qtd = (Number) dao.createQuery("select count(b) from Bookmark b").getSingleResult();
			return qtd.intValue();
		}
		catch(Throwable t){
			t.printStackTrace();
			return 0;
		}
	}
}
