

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import lp2g20.locadora.Cliente;
import lp2g20.locadora.ClienteNaoCadastradoEx;
import lp2g20.locadora.CopiaNaoDisponivelEx;
import lp2g20.locadora.Filme;
import lp2g20.locadora.FilmeNaoCadastradoEx;
import lp2g20.locadora.LimiteDeAluguelExcedidoEx;
import lp2g20.locadora.Locadora;
import lp2g20.locadora.NenhumaCopiaAlugadaEx;

public class Ex1 {
	
	private static Scanner leitor = new Scanner(System.in);
	private static String data = "\\d{2}/\\d{2}/\\d{4}";
	private static Locadora LocadoraDoJJ;
		
	static void Cadastro(Locadora minhaLocadora) {

		String endereco, codigoCliente, nome, dataDeNascimento, codigoFilme, tituloDoFilme, categoria, opcao;
		int quantidade;

		while (true) {
			
			System.out.println("Selecione a opcao  da operacao desejada: \n[1] - Cadastrar Clientes\n[2] - Cadastrar Filmes\n[3] - Salvar em arquivo");
			opcao = leitor.nextLine();

			if (opcao.equals("1")) {

				System.out.println("Digite o codigo do cliente: ");
				codigoCliente = leitor.nextLine();

				System.out.println("Digite o nome do cliente: ");
				nome = leitor.nextLine();

				System.out.println("Digite o endereco do cliente: ");
				endereco = leitor.nextLine();

				while (true) {
					System.out.println("Digite a data de nascimento do cliente: ");
					if ((dataDeNascimento = leitor.nextLine()).matches(data)) {
						break;
					} 
					else {
						System.out.println("Data invalida!");
					}
				}

				minhaLocadora.cadastraCliente(new Cliente(endereco, codigoCliente, nome, dataDeNascimento));
				System.out.println("Cliente cadastrado!");
				break;
			}

			else if (opcao.equals("2")) {

				System.out.println("Digite o codigo do filme: ");
				codigoFilme = leitor.nextLine();

				System.out.println("Digite o titulo do filme: ");
				tituloDoFilme = leitor.nextLine();

				System.out.println("Digite a categoria do filme: ");
				categoria = leitor.nextLine();

				while (true) {
					try {
						System.out.println("Digite a quantidade de filmes: ");
						quantidade = Integer.parseInt(leitor.nextLine());
						break;
					} 
					catch (NumberFormatException erro) {
						System.out.println("Quantidade invalida, digite apenas numeros!");
					}
				}

				minhaLocadora.cadastraFilme(new Filme(codigoFilme, tituloDoFilme, categoria, quantidade));
				System.out.println("Filme cadastrado!");
				break;
			}

			else if (opcao.equals("3")) {

				while (true) {

					System.out.println("Que arquivo deseja salvar?\n[A] - Filmes\n[B] - Clientes");
					opcao = leitor.nextLine();

					if (opcao.equalsIgnoreCase("a")) {
						try {
							minhaLocadora.salvaArquivo("filmes");
							System.out.println("Arquivo salvo!");
							break;
						} 
						catch (IOException erro) {
							System.out.println("Erro ao salvar arquivo!");
						}
					}

					else if (opcao.equalsIgnoreCase("b")) {
						try {
							minhaLocadora.salvaArquivo("clientes");
							System.out.println("Arquivo salvo!");
							break;
						} 
						catch (IOException erro) {
							System.out.println("Erro ao salvar arquivo!");
						}
					}

					else {
						System.out.println("Opcao invalida!");
					}
				}
				break;
			}
			
			else {
				System.out.println("Opcao invalida!");
			}
		}
	}
	
	public static void Manutencao(Locadora minhaLocadora){
		try {
			minhaLocadora.salvaArquivo("clientes");
			minhaLocadora.salvaArquivo("filmes");
			System.out.println("Arquivos criados com sucesso!");
		} 
		catch (IOException erro) {
			erro.printStackTrace();
			System.out.println("Erro ao criar arquivos!");
		}

		try {
			minhaLocadora.leArquivo("filmes.dat");
			minhaLocadora.leArquivo("clientes.dat");
			System.out.println("Arquivo de Clientes: \n");
			System.out.println(minhaLocadora.imprimeClientes());
			System.out.println("Arquivo de Filmes: \n");
			System.out.println(minhaLocadora.imprimeFilmes());
		} 
		catch (FileNotFoundException erro) {
			System.out.println("Arquivo nao encontrado!");
		} 
		catch (IOException erro) {
			erro.printStackTrace();
			System.out.println("Erro ao abrir arquivos!");
		} 
		catch (ClassNotFoundException erro) {
			System.out.println("Erro ao ler arquivos!");
		}
		catch(ClassCastException erro){
			System.out.println("Tipos de arquivos invalidos!");
		}

		try {
			minhaLocadora.salvaArquivo("clientes");
			minhaLocadora.salvaArquivo("filmes");
			System.out.println("Arquivos salvos com sucesso!");
		} 
		catch (IOException erro) {
			System.out.println("Erro ao criar arquivos!");
		}
	}

	
	static void Locacao(Locadora minhaLocadora) throws CopiaNaoDisponivelEx, ClienteNaoCadastradoEx, FilmeNaoCadastradoEx, NenhumaCopiaAlugadaEx {

		String opcao;

		while (true) {
			System.out.println("Selecione a opcao da operacao desejada: \n[1] - Exibir cadastro de filmes\n[2] - Alugar um filme\n[3] - Devolver um filme");
			opcao = leitor.nextLine();
			
			if (opcao.equals("1")) {
				try{
					System.out.println(minhaLocadora.imprimeFilmes());
					break;
				}
				catch(ClassCastException erro){
					System.out.println("Tipos de arquivos invalidos!");
				}
			}

			else if (opcao.equals("2")) {

				String codigoCliente, codigoFilme;
				Cliente cliente;
				Filme filme;
				
				while (true) {
					try {
						System.out.println("Digite o codigo do cliente: ");
						codigoCliente = leitor.nextLine();
						cliente = minhaLocadora.getCliente(codigoCliente);
						break;
					}
					catch (ClienteNaoCadastradoEx erro) {
						System.out.println(erro.getMessage());
					} 	
				}
				
				try{
					if(cliente.getHistorico().size() == 5){
						throw new LimiteDeAluguelExcedidoEx();
					}
				}
				catch(LimiteDeAluguelExcedidoEx erro){
					System.out.println(erro.getMessage());
					break;
				}
				while(true){
					try{	
						System.out.println("Digite o codigo do filme: ");
						codigoFilme = leitor.nextLine();
						filme = minhaLocadora.getFilme(codigoFilme);
						break;
					}
					catch (FilmeNaoCadastradoEx erro) {
						System.out.println(erro.getMessage());
					}
					
				}
				try{						
					minhaLocadora.alugaFilme(cliente,filme);
					System.out.println("Filme alugado com sucesso!");
					
					break;
				} 					
				catch (CopiaNaoDisponivelEx erro) {
						System.out.println(erro.getMessage());
						break;			
				}
			}

			else if (opcao.equals("3")) {

				String codigoFilme;
				Filme filme;
				
				while (true) {
					try {
						System.out.println("Digite o codigo do filme: ");
						codigoFilme = leitor.nextLine();
						filme = minhaLocadora.getFilme(codigoFilme);
						break;
					} 
					catch (FilmeNaoCadastradoEx erro) {
						System.out.println(erro.getMessage());
					}
				}
				try{
					filme.devolve();
					System.out.println("O filme foi devolvido!");
					break;
				}
				catch (NenhumaCopiaAlugadaEx erro) {
					System.out.println(erro.getMessage());
					break;
				}
			}
			
			else{
				System.out.println("Opcao invalida!");
			}
		}
	}
	
	static void Relatorio(Locadora minhaLocadora){
		
		String opcao;
		
		while(true){
			
			System.out.println("Selecione a opcao da operacao desejada: \n[1] - Listar acervo de filmes\n[2] - Listar cadastro de clientes\n[3] - Verificar historico de cliente:");
			opcao = leitor.nextLine();

			if(opcao.equals("1")){
				try{
					System.out.println(minhaLocadora.imprimeFilmes());
					break;
				}
				catch(ClassCastException erro){
					System.out.println("Tipos de arquivos invalidos!");
				}
			}
			else if(opcao.equals("2")){
				try{
					System.out.println(minhaLocadora.imprimeClientes());
					break;
				}
				catch(ClassCastException erro){
					System.out.println("Tipos de arquivos invalidos!");
				}
			}
			else if(opcao.equals("3")){
				
				Cliente clie;
				String codc;
				
				try{
					System.out.println("Digite o codigo do cliente: ");
					codc = leitor.nextLine();
					clie = minhaLocadora.getCliente(codc);
					System.out.println(clie.getHistorico());
					break;
				}
				catch(ClienteNaoCadastradoEx erro){
					System.out.println(erro.getMessage());
				}
				catch(ClassCastException erro){
					System.out.println("Tipos de arquivos invalidos!");
				}
			}
			else{
				System.out.println("Opcao invalida!");
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, CopiaNaoDisponivelEx, ClienteNaoCadastradoEx, FilmeNaoCadastradoEx, NenhumaCopiaAlugadaEx {
		
		
		String opcao, filme, cliente;
		
		
		while(true){
			System.out.println("Selecione a opcao da operacao desejada: \n[1] - Carregar locadora a partir de arquivos\n[2] - Criar nova locadora");
			opcao = leitor.nextLine();
			
			if(opcao.equals("1")){
				try{
					System.out.println("Digite o nome do arquivo de filmes(com a extensao): ");
					filme = leitor.nextLine();
					System.out.println("Digite o nome do arquivo de clientes(com a extensao): ");
					cliente = leitor.nextLine();
					LocadoraDoJJ = new Locadora(filme, cliente);
					break;
				}
			
				catch(FileNotFoundException erro){
					System.out.println("Arquivo nao encontrado!");
				}
				catch(IOException erro){
					System.out.println("Erro ao abrir arquivos!");
				}
				catch(Exception erro){
					System.out.println("Erro ao ler arquivos!");
				}
			}
			else if(opcao.equals("2")){
				LocadoraDoJJ = new Locadora();
				break;
			}
			else{
				System.out.println("Opcao invalida!");
			}
		}
		
		System.out.println("[ Seja Bem-vindo a Locadora do JJ! ]");
		System.out.println("\n[ Informamos que, de acordo com a nossa politica, cada cliente pode alugar ate 5 filmes por vez! ]");
		System.out.println("[ A data de devolucao eh 7 dias (correntes) apos da data de locacao. ]\n");
		
		while(true){
			System.out.println("Selecione a opcao da operacao desejada: \n[1] - Manutencao\n[2] - Cadastro\n[3] - Locacao\n[4] - Relatorio\n[5] - Sair");
			opcao = leitor.nextLine();
			
			if(opcao.equals("1")){
				Manutencao(LocadoraDoJJ);
			}
			else if(opcao.equals("2")){
				Cadastro(LocadoraDoJJ);
			}
			else if(opcao.equals("3")){
				Locacao(LocadoraDoJJ);
			}
			else if(opcao.equals("4")){
				Relatorio(LocadoraDoJJ);
			}
			else if(opcao.equals("5")){
				System.out.println("O sistema foi encerrado!");
				break;
			}
			else{
				System.out.println("Opcao invalida!");
			}
		}
	}
}
