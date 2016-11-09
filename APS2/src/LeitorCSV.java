import java.io.FileNotFoundException;

public class LeitorCSV {

	public static void main(String[] args) {
		try {
			(new LeitorCSV()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrou arquivo.");
			System.err.println(e.getMessage());
		}
	}

	private void run() throws FileNotFoundException {
		testaAlunos();
		testaRotas();
	}

	private void testaRotas() throws FileNotFoundException {
		Parser<Funcionario> parser = new FuncionarioParser(); 
		CSVReader<Funcionario> reader = new CSVReader<>("Funcionarios.CSV", parser);
		reader.skipLine(); // cabecalho
		while (reader.hasNext()) {
			Funcionario route = reader.readObject();
			System.out.println(route);
		}
		reader.close();
	}

	private void testaAlunos() throws FileNotFoundException {
		Parser<Funcionario> parser = new FuncionarioParser(); 
		CSVReader<Funcionario> reader = new CSVReader<>("Funcionarios.csv", parser);
		while (reader.hasNext()) {
			Funcionario empregado = reader.readObject();
			System.out.println(empregado);
		}
		reader.close();
	}

}