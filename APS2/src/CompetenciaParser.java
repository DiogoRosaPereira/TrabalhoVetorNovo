
import java.util.Scanner;

public class CompetenciaParser implements Parser<Competencia> {
	public Competencia parse(String dados) {
		Scanner arquivo = new Scanner(dados);
	
		
		arquivo.useDelimiter(";");
		
		String competencia = arquivo.next();
			
		Competencia comp = new Competencia(competencia);
		
		arquivo.close();
		return comp;
	}
}
