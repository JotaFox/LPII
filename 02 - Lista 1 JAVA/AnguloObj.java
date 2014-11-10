public class AnguloObj{
	
	protected double arcoRad;
	public double seno, coseno, tangente, cotangente;

	AnguloObj(double valorDoAngulo){
		arcoRad = Math.toRadians(valorDoAngulo);
	}

	public double funcaoSeno(){
		seno = Math.sin(arcoRad);
		return seno;
	}
	public double funcaoCoseno(){
		coseno = Math.cos(arcoRad);
		return coseno;
	}
	public double funcaoTangente(){
		tangente = Math.tan(arcoRad);
		return tangente;
	}
	public double funcaoCotangente(){
		cotangente = 1.0 / Math.tan(arcoRad);
		return cotangente;
	}

	public void imprime(){
		System.out.printf("\nArco: %.2f\n",arcoRad ,"rad");
		System.out.printf("Seno: %.2f\n",seno);
		System.out.printf("Coseno: %.2f\n",coseno);
		System.out.printf("Tangente: %.2f\n",tangente);
		System.out.printf("Cotangente: %.2f\n\n",cotangente);
	}

}
