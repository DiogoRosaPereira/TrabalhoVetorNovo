
	
	import java.util.Arrays;

	public class Funcionario {

		private String nome;
		private String[] competencias;
		private String  salario;
		private Integer num_competencias;

	
	public Funcionario(String nome, String salario, Integer num_competencias, String[] competencias) {
		setNome(nome);
		setSalario(salario);
		setCompetencias(getCompetencias());
		setNum_competencias(num_competencias);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String[] getCompetencias() {
		return competencias;
	}

	public void setCompetencias(String[] competencias) {
		this.competencias = competencias;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public Integer getNum_competencias() {
		return num_competencias;
	}

	public void setNum_competencias(Integer num_competencias) {
		this.num_competencias = num_competencias;
	}

	public void setCompetencias(int numFunc, String competencia) {
		if (numFunc < 0 || numFunc >= competencias.length)
			throw new ArrayIndexOutOfBoundsException(numFunc);
			this.competencias[numFunc] = competencia;
		}	
	

		public String toString() {
			return "Funcionario = " + nome + "\n salario=" + salario + "\n presencas=" + Arrays.toString(competencias) ;
		}

		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	
	private int ind = 0 ;


	public String getListaCompetencias() {
		String func = "";
		for (int i = 0; i < competencia.length; i++) {
			if(competencia[i] != null)
				func += competencia[i]+", ";
		}
		return func;
	}
	
	public void setCompetencia(String compFunc) {
		testarVetorCompetencia();
		competencia[ind] = compFunc;
		ind++;
		
	}
		
	
	private void testarVetorCompetencia() {
		if(ind >= competencia.length-1){
		String [] competenciaNovoNovo = new String [competencia.length+4];
		for(int i = 0; i<competencia.length;i++ ){
			competenciaNovoNovo[i] = competencia[i];
			}
		competencia = competenciaNovoNovo;
		}
	}
	

	public String getNome() {
		return nome;
	}
	public  void setNome(String nomeFunc) {
		nome = nomeFunc;
	}
	public double getSalario() {
		return salario;
	}
	public  void setSalario(double salarioFunc) {
		salario = salarioFunc;
	}
	public String toString(){
		return "nome  "+getNome()+
				"\nSalario  "+getSalario()+
				"\nCompetencia  "+getListaCompetencias();
	}
	
	
}*/

	