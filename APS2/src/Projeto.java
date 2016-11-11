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

	public void mostrarInformacoes(int index, int offset) {
		String competencias = "";
		
		for (int i = 0; i < getNum_competencias(); i++) {
			competencias += getCompetencias()[i];
			
			if(i == getNum_competencias() - 1) {
				competencias += ".";
			} else {
				competencias += ", ";
			}
		}
		
		System.out.println(
			(index + offset) + 
			" - Nome: " + 
			this.getNome() + 
			", data Inicio: " + 
			this.getData_inicio() +
			", data Final: " +
			this.getData_fim() +
			", num_competencias: "+
			this.getNum_competencias()+
			", Competências: " +
			competencias
		);
	}
}

