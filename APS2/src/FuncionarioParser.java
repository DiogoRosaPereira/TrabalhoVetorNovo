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






















/*import java.util.Scanner;

public class AlunoParser implements Parser<Aluno> {
	public Aluno parse(String dados) {
		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");
		String nome = arquivo.next();
		String matricula = arquivo.next();
		int numAulas = arquivo.nextInt();
		Aluno aluno = new Aluno(nome, matricula, numAulas);
		for (int aula = 0; aula < numAulas; aula++) {
			int v = arquivo.nextInt();
			aluno.setPresenca(aula, v == 1);
		}
		arquivo.close();
		return aluno;
	}
}*/