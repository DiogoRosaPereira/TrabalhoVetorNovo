import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorCSV {
	
	static Scanner scanner = new Scanner(System.in);
	
	private Vetor<Funcionario> funcionarios = new Vetor<>();
	private Vetor<Projeto> projetos = new Vetor<>();
	private Vetor<Competencia> competencias = new Vetor<>();
	
	public static void main(String[] args) {
		try {
			(new LeitorCSV()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrou arquivo.");
			System.err.println(e.getMessage());
		}
	}

	private void run() throws FileNotFoundException {
		leituraDeFuncionarios();
		leituraDeProjetos();
	}

	private void leituraDeFuncionarios() throws FileNotFoundException {
		CSVReader<Funcionario> arquivo = new CSVReader<>("funcionarios.csv", new FuncionarioParser());
		
		arquivo.skipLine();
		
		while (arquivo.hasNext()) {
			funcionarios.append(arquivo.readObject());
		}		
		
		arquivo.close();
	}
	private void leituraDeCompetencias() throws FileNotFoundException {
		CSVReader<Competencia> arquivo = new CSVReader<>("competencias.csv", new CompetenciaParser());
		
		arquivo.skipLine();
		
		while (arquivo.hasNext()) {
			competencias.append(arquivo.readObject());
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

}