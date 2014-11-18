import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;
import java.util.InputMismatchException;

public class Ex4{

	private static Scanner sc = new Scanner(System.in);
	private static String nomePessoa, dataNascimentoPessoa;
	private static double pesoPessoa, alturaPessoa;


	public static void main(String[] args) {
		
		Vector<PessoaIMC> vector = new Vector<PessoaIMC>();
		int nPessoas = 0;

		boolean verify = false;

		while (verify == false){

			try{
				System.out.println("Digite o numero de pessoas: ");
				nPessoas = sc.nextInt();
				sc.nextLine();

				for (int i = 0; i < nPessoas; i++) {

					System.out.println("Inserir homem (h) ou mulher (m)?");
					String sexo = sc.next();
					sc.nextLine();

					if (sexo.compareTo("h") == 0){
						entradaDeDados();
						Homem homem = new Homem(nomePessoa,dataNascimentoPessoa,pesoPessoa,alturaPessoa);
						vector.add(homem);
					}
					else if (sexo.compareTo("m") == 0){
						entradaDeDados();
						Mulher mulher = new Mulher(nomePessoa,dataNascimentoPessoa,pesoPessoa,alturaPessoa);
						vector.add(mulher);
					}
					else{
						System.out.println("Sexo invalido!");
					}
					verify = true;
				}
			}
			catch(InputMismatchException e){
				System.out.println("Você entrou com um dado inválido! Tente novamente!");
				String limpaBuff = sc.next();
			}
		}

    	Iterator it = vector.iterator();
  
    	System.out.println("----------");
    	while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	public static void entradaDeDados(){

		System.out.println("Digite o nome: ");
		nomePessoa = sc.nextLine();
		System.out.println("Digite a data de nascimento: ");
		dataNascimentoPessoa = sc.nextLine();
		System.out.println("Digite o peso: ");
		pesoPessoa = sc.nextDouble();
		System.out.println("Digite a altura (em metros): ");
		alturaPessoa = sc.nextDouble();

	}
}