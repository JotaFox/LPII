package lp2g20.locadora;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Filme implements Serializable{

	private String codigoFilme, tituloDoFilme, categoria;
	private int quantidade, alugados = 0;

	public Filme(String codigoDoFilme, String tituloDoFilme, String categoria, int quantidade) {
		this.categoria = categoria;
		this.codigoFilme = codigoDoFilme;
		this.quantidade = quantidade;
		this.tituloDoFilme = tituloDoFilme;
	}

	public Filme(String tituloDoFilme) {
		this.tituloDoFilme = tituloDoFilme;
	}

	public void aluga() throws CopiaNaoDisponivelEx {

		if (quantidade == alugados) {
			throw new CopiaNaoDisponivelEx();
		}

		else {
			alugados += 1;
		}
	}

	public void devolve() throws NenhumaCopiaAlugadaEx {
		if (alugados == 0) {
			throw new NenhumaCopiaAlugadaEx();
		}

		else {
			alugados -= 1;
		}
	}
	
	
	public String getCodigoFilme(){
		return codigoFilme;
	}
	
	public String getTitulo(){
		return tituloDoFilme;
	}
	
	public String getCategoria(){
		return categoria;
	}
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public int getAlugados(){
		return alugados;
	}
	
	public String toString(){
		return "\nTitulo = " + tituloDoFilme + "\nCodigo = " + codigoFilme + "\nCategoria = " + categoria + "\nQuantidade = " + quantidade + "\nAlugados = " + alugados;
	}
}
