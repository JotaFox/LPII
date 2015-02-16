package lp2g20.locadora;

public class CopiaNaoDisponivelEx extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1002113633390428389L;

	public CopiaNaoDisponivelEx(){
		super("Esta copia nao esta disponivel no momento!");
	}
}