import java.util.Scanner;

public class Ex3{
	public static void main(String[] args) {
		
		double valorDoAngulo = 0; 

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o numero de angulos:");
		int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

			System.out.println("Digite a medida do angulo: ");
			valorDoAngulo = sc.nextDouble();
		}

		AnguloObj[] array = new AnguloObj[n];//criação de um array do tipo AnguloObj com n posições

		for (int j = 0; j < n; j++) {

			AnguloObj invocador = new AnguloObj(valorDoAngulo);// criação do invocador

			invocador.funcaoSeno();
			invocador.funcaoCoseno();
			invocador.funcaoTangente();
			invocador.funcaoCotangente();
			System.out.println(invocador.toString());

			array[j] = invocador;
  		}
	}
}
