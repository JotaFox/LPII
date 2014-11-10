import java.util.Scanner;

public class Ex3{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite a medida do angulo: ");
		double valorDoAngulo = sc.nextDouble();

		AnguloObj invocador = new AnguloObj(valorDoAngulo);

		invocador.funcaoSeno();
		invocador.funcaoCoseno();
		invocador.funcaoTangente();
		invocador.funcaoCotangente();
		invocador.imprime();

	}
}
