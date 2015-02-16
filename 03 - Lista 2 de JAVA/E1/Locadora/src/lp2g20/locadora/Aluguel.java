package lp2g20.locadora;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Aluguel implements Serializable {

	private String dataDeLocacao, dataDeDevolucao, codigoFilme;
	
	public Aluguel(String dataDeLocacao, String dataDeDevolucao, String codigoFilme){
		this.codigoFilme = codigoFilme;
		this.dataDeLocacao = dataDeLocacao;
		this.dataDeDevolucao = dataDeDevolucao;
	}
	
	public String getDataDeLocacao(){
		return dataDeLocacao;
	}
	
	public String getDataDeDevolucao(){
		return dataDeDevolucao;
	}
	
	public String getCodigoFilme(){
		return codigoFilme;
	}
	
	public String toString(){
		return "Data de Locacao = " + dataDeLocacao + "\n Data de Devolucao = " + dataDeDevolucao + "\n Codigo do filme = " + codigoFilme;
	}
}
