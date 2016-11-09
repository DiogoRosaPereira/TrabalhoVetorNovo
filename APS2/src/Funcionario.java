
	
	import java.util.Arrays;

	public class Funcionario {

		private String nome;
		private String[] competencias;
		private double salario;

	
	public Funcionario(String nome, double salario) {
		this.nome = nome;
		this.salario = salario;
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

	