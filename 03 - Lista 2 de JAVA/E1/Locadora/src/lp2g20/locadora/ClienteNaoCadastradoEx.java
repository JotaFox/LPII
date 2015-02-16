package lp2g20.locadora;


public class ClienteNaoCadastradoEx extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3865753662296569142L;

	public ClienteNaoCadastradoEx(){
		super("Esse cliente nao esta cadastrado!");
	}
}