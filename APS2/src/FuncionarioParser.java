import java.util.Scanner;

public class FuncionarioParser implements Parser<Funcionario> {
	public Funcionario parse(String dados) {
		Scanner arquivo = new Scanner(dados);
	
		
		arquivo.useDelimiter(";");
		
		String nome = arquivo.next();
		String salario = arquivo.next();
		int num_competencias = arquivo.nextInt();
		
		String [] competencias = new String [num_competencias];
		
		for (int i = 0; i < num_competencias; i++) {
			competencias[i] = arquivo.next();
		}
			
		Funcionario empregado = new Funcionario(nome, salario, num_competencias, competencias);
		
		arquivo.close();
		return empregado;
	}
}

