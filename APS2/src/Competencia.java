
public class Competencia {
	private String compete;
	
	public Competencia(String competencia) {
		setCompetencias(competencia);
	}

	public String getCompete() {
		return compete;
	}

	public void setCompetencias(String competencia) {
		this.compete = competencia;
	}

	public void mostrarInformacoes(int index, int offset) {
		System.out.println(
			(index + offset) + 
			", Competências: " +
			getCompete()
		);
	}
}	
	
	

