package lp2g20.locadora;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pessoa implements Serializable{
	
	private String nome, dataDeNascimento;
	
	public Pessoa(String nome, String dataDeNascimento){
		this.dataDeNascimento = dataDeNascimento;
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getDataDeNascimento(){
		return dataDeNascimento;
	}

	public String toString(){
		return "Nome = " + nome + "\nData de Nascimento = " + dataDeNascimento;
	}
}
