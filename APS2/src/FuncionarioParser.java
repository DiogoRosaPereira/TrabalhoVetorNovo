import java.util.Scanner;

public class FuncionarioParser implements Parser<Funcionario> {
	public Funcionario parse(String dados) {
		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");
		String nome = arquivo.next();
		double salario = arquivo.nextDouble();
		Funcionario empregado = new Funcionario (nome, salario);
		
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