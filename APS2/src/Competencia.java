
public class Competencia {
	private String competencias;
	
	public Competencia(String competencias) {
		setCompetencias(competencias);
	}

	public String getCompetencias() {
		return competencias;
	}

	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}

	public void mostrarInformacoes(int index, int offset) {
		String competencias = "";
		
		System.out.println(
			(index + offset) + 
			", Competências: " +
			getCompetencias()
		);
	}
}	
	
	

