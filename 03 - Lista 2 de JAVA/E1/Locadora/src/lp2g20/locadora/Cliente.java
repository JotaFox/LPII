package lp2g20.locadora;

import java.util.Vector;

@SuppressWarnings("serial")
public class Cliente extends Pessoa{

	private String endereco, codigoCliente;
	private Vector <Aluguel> historico  = new Vector <Aluguel> ();
	
	public Cliente(String endereco, String codigoCliente, String nome, String dataDeNascimento){
		super(nome, dataDeNascimento);
		this.codigoCliente = codigoCliente;
		this.endereco = endereco;
	}

	public void addFilmeHist(String dataDeLocacao, String dataDeDevolucao, String codigoFilme){
		Aluguel aluga = new Aluguel(dataDeLocacao, dataDeDevolucao, codigoFilme);
		historico.add(aluga);
	}
	
	public String getCodigoCliente(){
		return codigoCliente;
	}
	
	public String getEndereco(){
		return endereco;
	}
	
	public Vector<Aluguel> getHistorico(){
		return historico;
	}
	
	public String toString(){
		return super.toString() + "\nCodigo = " + codigoCliente + "\nEndereco = " + endereco + "\nHistorico = " + historico;
	}

}
