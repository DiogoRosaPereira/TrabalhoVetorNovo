public class Projeto {
	
	private String nome;
	private String dataInicio;
	private String dataFim;
	private Integer num_competencias;
	private String[] competencias;
	
	public Projeto(String nome, String data_inicio, String data_fim, Integer num_competencias, String[] competencias) {
		setNome(nome);
		setData_inicio(data_inicio);
		setData_fim(data_fim);
		setNum_competencias(num_competencias);
		setCompetencias(competencias);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData_inicio() {
		return dataInicio;
	}

	public void setData_inicio(String data_inicio) {
		this.dataInicio = data_inicio;
	}

	public String getData_fim() {
		return dataFim;
	}

	public void setData_fim(String data_fim) {
		this.dataFim = data_fim;
	}

	public Integer getNum_competencias() {
		return num_competencias;
	}

	public void setNum_competencias(Integer num_competencias) {
		this.num_competencias = num_competencias;
	}

	public String[] getCompetencias() {
		return competencias;
	}

	public void setCompetencias(String[] competencias) {
		this.competencias = competencias;
	}
}





























/*import java.time.LocalDate;

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



*/







