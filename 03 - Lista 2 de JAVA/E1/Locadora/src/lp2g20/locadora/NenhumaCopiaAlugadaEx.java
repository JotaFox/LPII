package lp2g20.locadora;

public class NenhumaCopiaAlugadaEx extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4348941442039649339L;

	public NenhumaCopiaAlugadaEx(){
		super("Esta copia nao esta alugada no momento!");
	}
}