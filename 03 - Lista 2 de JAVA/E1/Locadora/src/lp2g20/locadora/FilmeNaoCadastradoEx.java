package lp2g20.locadora;

public class FilmeNaoCadastradoEx extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6585121842871949137L;

	public FilmeNaoCadastradoEx(){
		super("Esse filme nao esta cadastrado!");
	}
}