import java.time.LocalDate;

public class Projeto {
	
	private String nome;
	private static LocalDate dataInicio;
	private LocalDate dataFim;
	private String []competencia = new String[4];
	private int ind =0;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public static LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate date) {
		dataInicio = date;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate date1) {
		dataFim = date1;
	}
	public String getCompetencias() {
		String comp = "";
		for (int i = 0; i < competencia.length; i++) {
			if(competencia[i] != null)
				comp += competencia[i]+", ";
		}
		return comp;
	}
	public void setCompetencia(String competenciaProj) {
		testavetorCompetencia();
		competencia[ind] = competenciaProj;
		ind++;
	}
	
	
	private void testavetorCompetencia() {
		if(ind >= competencia.length-1){
		String [] vetNovo = new String [competencia.length+4];
		for(int i = 0; i<competencia.length;i++ ){
			vetNovo[i] = competencia[i];
			}
		competencia = vetNovo;
		}
	}
	public String toString(){
		return "nome  "+getNome()+
				"\ndata de inicio  "+getDataInicio()+
				"\ndata final  "+getDataFim()+
				"\nCompetencias  "+getCompetencias();
	}
	
	



}











