import java.io.FileNotFoundException;
import java.util.Scanner;

public class Empresa <T>{
	
	static Scanner scanner = new Scanner(System.in);
	
	private Vetor<Funcionario> funcionarios = new Vetor<>();
	private Vetor<Projeto> projetos = new Vetor<>();

	private Vetor<Competencia> competencias = new Vetor<>();

	
	
	public static void main(String[] args) {
		try {
			(new Empresa<Object>()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrei o arquivo.");
			System.err.println(e.getMessage());
		}
	}

	private void run() throws FileNotFoundException {
		leituraDeFuncionarios();
		leituraDeProjetos();
		leituraCompetencias();
		
		menuPrincipal();
	}
	@SuppressWarnings("rawtypes")
	private void leituraCompetencias() throws FileNotFoundException {
		CSVReader<Competencia> arquivo = new CSVReader<>("competencias.csv", new CompetenciaParser());
		
		arquivo.skipLine();
		
		while (arquivo.hasNext()) {
			competencias.append(arquivo.readObject());
			
		}		
		
		arquivo.close();
		
	}

	@SuppressWarnings("rawtypes")
	private void leituraDeFuncionarios() throws FileNotFoundException {
		CSVReader<Funcionario> arquivo = new CSVReader<>("funcionarios.csv", new FuncionarioParser());
		
		arquivo.skipLine();
		
		while (arquivo.hasNext()) {
			funcionarios.append(arquivo.readObject());
			
		}		
		
		arquivo.close();
	}
	
	private void leituraDeProjetos() throws FileNotFoundException {
		CSVReader<Projeto> arquivo = new CSVReader<>("projetos.csv", new ProjetoParser());
		
		arquivo.skipLine();

		while (arquivo.hasNext()) {
			projetos.append(arquivo.readObject());
		}
		
		arquivo.close();
	}
	
	private void menuPrincipal() {
		System.out.println("===== ** =====");
		System.out.println("Menu principal:");
		System.out.println("1 - Funcionarios");
		System.out.println("2 - Projetos");
		System.out.println("3 - Competencias");
		
		System.out.println();
		System.out.print("Digite o numero de menu desejado: ");
		
		String escolhaMenu = scanner.next();
		
		switch (escolhaMenu) {
			case "1":
					menuFuncionarios();
				break;
			case "2":
					menuProjetos();
				break;
			case "3":
				menuCompetencias();
			break;
			default:
				
					System.out.println("Escolha invalida.");
					menuPrincipal();
				break;
		}
	}
	
	private void menuCompetencias() {
		System.out.println("\nMenu de Projetos:");
		System.out.println("1 - adicionar nova competencia");
		System.out.println("2 - listar competencias");
		System.out.println("3 - remover competencia");
		System.out.println("0 - Voltar");
		System.out.print("\nDigite o numero de menu desejado: ");
		
		String menuComp = scanner.next();
		
		switch (menuComp) {
			case "1":
				adicionaCompetencia();
				break;
			case "2":
					System.out.println("==========");
					listarCompetencia();
					menuCompetencias();
				break;
			case "3":
				System.out.println("==========");
				removeCompetencia();
				break;			
			case "0":
				menuPrincipal();
			break;
			default:
					System.out.println("\nEscolha invalida.");
					menuFuncionarios();
				break;
		}
		
	}

	private void removeCompetencia() {
		listarCompetencia(1);
		
		System.out.println(">> 0 - Voltar");
		
		
		
		System.out.println(">> Escolha uma competencia para ser excluida:");
		
		String escolhaMenu = scanner.next();
		
		switch (escolhaMenu) {
			case "0":
					menuCompetencias();
				break;
			default:
				excluiCompetencia(Integer.parseInt(escolhaMenu) - 1);
				break;
		}
		
	}

	private void excluiCompetencia(int index) {
		System.out.println("--------------");
		
		try {
			competencias.remove(index);
			
			System.out.println("Competencia removida com sucesso!");
		} catch(Exception e) {			
			System.out.println("Erro ao remover Competencia. Tente novamente.");
			System.out.println("Erro: " + e);
		}
		
		menuCompetencias();
		
	}

	private void adicionaCompetencia() {
		listarCompetencia();
		System.out.println("digite competencia:");
		String comp = scanner.next();
		
		competencias.append(new Competencia(comp));
		
		
		listarCompetencia();
		menuCompetencias();
	}

	private void listarCompetencia(int index) {
		for (int i = 0; i < competencias.size(); i++) {
			competencias.get(i).mostrarInformacoes(i, index);
		}
	}
	private void listarCompetencia() {
		listarCompetencia(1);
	}

	private void menuProjetos() {
		System.out.println("\nMenu de Projetos:");
		System.out.println("1 - Cadastrar novo Projeto");
		System.out.println("2 - Adicionar competencia");
		System.out.println("3 - Listar Projetos");
		System.out.println("4 - Excluir projeto");
		System.out.println("5 - Voltar");
		System.out.print("\nDigite o numero de menu desejado: ");
		
		String menuProjeto = scanner.next();
		
		switch (menuProjeto) {
			case "1":
					adicionaProjeto();
				break;
			case "2":
					System.out.println("===== ** =====");
					adicionarCompetenciaProjetos();
				break;
			case "3":
				System.out.println("===== ** =====");
				listarProjetos();
				menuProjetos();
				break;
			case "4":
				ExcluirProjeto();
				break;
			case "5":
				menuPrincipal();
			break;
			default:
					System.out.println("\nEscolha invalida.");
					menuFuncionarios();
				break;
		}
		
	}

	private void ExcluirProjeto() {
		listarFuncionarios(1);
		
		System.out.println("Escolha projeto para ser excluido:");
		System.out.println("0 - Voltar");
		
		String escolhaMenu = scanner.nextLine();
		
		switch (escolhaMenu) {
			case "0":
					menuProjetos();
				break;
			default:
					excluirProjeto(Integer.parseInt(escolhaMenu) - 1);
				break;
		}		
	}

	private void excluirProjeto(int index) {
		System.out.println("--------------");
		
		try {
			projetos.remove(index);
			
			System.out.println("Projeto removido com sucesso!");
		} catch(Exception e) {			
			System.out.println("Erro ao remover Projeto. Tente novamente.");
			System.out.println("Erro: " + e);
		}
		
		menuFuncionarios();
	}

	private void adicionarCompetenciaProjetos() {
		listarProjetos();
		
		System.out.println("numero do Projeto: ");
		int index = scanner.nextInt();
		
		String nome = projetos.get(index-1).getNome();
		String data_inicio = projetos.get(index-1).getData_inicio();
		String data_fim = projetos.get(index-1).getData_fim();
		int num_competencia = projetos.get(index-1).getNum_competencias();
		
		String []competencias = new String[num_competencia+1];
		
		System.out.print("Competencia ");
		String comp = scanner.next();
		competencias[num_competencia] = comp;
		
		for (int i = 0; i < competencias.length-1; i++) {
			competencias[i] = projetos.get(index-1).getCompetencias()[i];
		}
			
		Projeto projeto = new Projeto (nome, data_inicio, data_fim, num_competencia+1, competencias);
			
		projetos.insert(index-1, projeto);
		projetos.remove(index);
		
		listarProjetos();	
		menuProjetos();
		
	}

	private void listarProjetos(int index) {
		for (int i = 0; i < projetos.size(); i++) {
			projetos.get(i).mostrarInformacoes(i, index);
		}
	}
	
	private void listarProjetos() {
		listarProjetos(1);
	}

	private void adicionaProjeto() {
		System.out.println("Adicionar Projeto:");	
		
		System.out.print("Nome do Projeto: ");
		String nome = scanner.nextLine();

		System.out.print("data Inicio: ");
		String dataInicio = scanner.nextLine();
		
		System.out.print("data Final: ");
		String dataFim = scanner.nextLine();
		
		System.out.print("Numero de competencias: ");
		int num_competencias = Integer.parseInt(scanner.nextLine());
		
		String[] competencias = new String[num_competencias];
		
		int index = 0;
		while(index < num_competencias) {
			System.out.print("Competencia " + (index + 1) + ": ");
			competencias[index] = scanner.nextLine();
			
			index++;
		}
		
		projetos.append(new Projeto(nome, dataInicio, dataFim, num_competencias, competencias));
	
		System.out.println("\nProjeto " + nome + " adicionado com sucesso!");
		
		menuProjetos();
		
	}

	private void menuFuncionarios() {
		System.out.println("===== ** ====="+"\nMenu de funcionarios:");
		System.out.println("1 - Cadastrar novo funcionario");
		System.out.println("2 - Adicionar competencia");
		System.out.println("3 - Listar funcionarios");
		System.out.println("4 - Excluir funcionario");
		System.out.println("5 - Voltar");
		System.out.print("\nDigite o numero de menu desejado: ");
		
		String escolhaMenu = scanner.next();
		
		switch (escolhaMenu) {
			case "1":
					adicionarFuncionario();
				break;
			case "2":
					System.out.println("===== ** =====");
					adicionarCompetenciaFuncionario();
				break;
			case "3":
				System.out.println("===== ** =====");
				listarFuncionarios();
				menuFuncionarios();
				break;
			case "4":
				menuExcluirFuncionario();
				break;
			case "0":
				menuPrincipal();
			break;
				
			default:
					
					System.out.println("Escolha invalida.");
					menuFuncionarios();
				break;
		}
	}
	
	private void adicionarCompetenciaFuncionario() {
		
		listarFuncionarios();
		
		System.out.println("numero do funcionario: ");
		int index = scanner.nextInt();
		
		String nome = funcionarios.get(index-1).getNome();
		String salario = funcionarios.get(index-1).getSalario();
		int num_competencia = funcionarios.get(index-1).getNum_competencias();
		
		String []competencias = new String[num_competencia+1];
		
		System.out.print("Competencia ");
		String comp = scanner.next();
		competencias[num_competencia] = comp;
		
		for (int i = 0; i < competencias.length-1; i++) {
			competencias[i] = funcionarios.get(index-1).getCompetencias()[i];
		}
			
		Funcionario funcionario = new Funcionario(nome, salario, num_competencia+1, competencias);
			
		funcionarios.insert(index-1, funcionario);
		funcionarios.remove(index);
			
		menuFuncionarios();
	}

	private void menuExcluirFuncionario() {
		listarFuncionarios(1);
		
		System.out.println("Escolha um funcionario para ser excluido:");
		System.out.println("0 - Voltar");
		
		System.out.print("Digite o numero do funcionario desejado:");
		
		String escolhaMenu = scanner.nextLine();
		
		switch (escolhaMenu) {
			case "0":
					menuFuncionarios();
				break;
			default:
					excluirFuncionario(Integer.parseInt(escolhaMenu) - 1);
				break;
		}
	}
	
	private void excluirFuncionario(int index) {
		System.out.println("\n==========");
		
		try {
			funcionarios.remove(index);
			
			System.out.println("Funcionario removido com sucesso!");
		} catch(Exception e) {			
			System.out.println("Erro ao remover o funcionario. Tente novamente.");
			System.out.println("Erro: " + e);
		}
		
		menuFuncionarios();
	}
	
	private void listarFuncionarios(int index) {				
		for (int i = 0; i < funcionarios.size(); i++) {
			funcionarios.get(i).mostrarInformacoes(i, index);
		}
	}
	
	private void listarFuncionarios() {
		listarFuncionarios(1);
	}
	
	private void adicionarFuncionario() {
		System.out.println();
		System.out.println("===== ** =====");
		System.out.println();
		System.out.println("Adicionar funcionario:");	
		
		System.out.println();
		
		System.out.print("Nome: ");
		String nome = scanner.nextLine();

		System.out.print("Salario: ");
		String salario = scanner.nextLine();
		
		System.out.print("Numero de competencias: ");
		int num_competencias = Integer.parseInt(scanner.nextLine());
		
		String[] competencias = new String[num_competencias];
		
		int index = 0;
		while(index < num_competencias) {
			System.out.print("Competencia " + (index + 1) + ": ");
			competencias[index] = scanner.nextLine();
			
			index++;
		}
		
		funcionarios.append(new Funcionario<Object>(nome, salario, num_competencias, competencias));
		
		System.out.println();
		System.out.println("Funcionario " + nome + " adicionado com sucesso!");
		
		// Volta para o menu de funcionarios
		menuFuncionarios();
	}
}