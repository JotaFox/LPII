package lp2g20.locadora;

public class LimiteDeAluguelExcedidoEx extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4513176227759735375L;

	public LimiteDeAluguelExcedidoEx(){
		super("O limite de filmes alugados por vez foi excedido!");
	}
}