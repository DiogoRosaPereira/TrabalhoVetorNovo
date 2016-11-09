import java.util.Scanner;

public class ProjetoParser implements Parser<Projeto> {
	public Projeto parse(String dados) {
		Scanner arquivo = new Scanner(dados);
	
		
		arquivo.useDelimiter(";");
		
		String nome = arquivo.next();
		String data_inicio = arquivo.next();
		String data_fim = arquivo.next();
		int num_competencias = arquivo.nextInt();
		
		
		String [] competencias = new String [num_competencias];
		
		for (int i = 0; i < num_competencias; i++) {
			competencias[i] = arquivo.next();
		}
			
		Projeto projeto = new Projeto(nome
												, data_inicio
												, data_fim
												, num_competencias
												, competencias);
		
		
		
		arquivo.close();
		return projeto;
	}
}






