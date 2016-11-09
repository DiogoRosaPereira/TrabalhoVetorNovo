import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Empresa {
	
	private static Funcionario []funcionario = new Funcionario[4];
	private static int NumeroFuncionario = 0;
	
	private static Scanner n = new Scanner (System.in);
	
	private static Projeto []projeto = new Projeto[4];
	private static int NumeroProjeto=0;

	private static int opcao;
	
	
	public static void main(String[] args) {
		
		
		do{
			
            menu();
            
            opcao = n.nextInt();
            
            switch(opcao){
            case 1:
            	cadastraFuncionario();
                break;
                
            case 2:
            	addCompetenciaFuncionario(NumeroFuncionario);
                break;
                
            case 3:
            	removerFuncionario();
                break;
                
            case 4:
            	cadastrarProjeto();
                break;
            case 5:
            	addCompetenciaProjeto(NumeroProjeto);
                break;
            case 6:
            	imprimeProjetos();
            case 7:
            	removerProjetos();
            default:
                System.out.println("Opção inválida.");
            }
            
        } while(opcao != 0);
    }
		
	private static void menu(){
		
		System.out.println("1 = cadastrar funcionario");
		System.out.println("2 = adicionar competencia a funcionario");
		System.out.println("3 = remover funcionario");
		System.out.println("4 = cadastra projeto");
		System.out.println("5 = adicionar competencia a projeto");
		System.out.println("6 = consultar projetos ativos");
		System.out.println("7 = remover projetos");
		System.out.println("Opção: ");
		
		
	}	
	
	private static void addCompetenciaProjeto(int index) {
		imprimeProjetos();
		System.out.println("Favor entrar com o numero do projeto: ");
		testaindexProjetos(index);
		int index1 = n.nextInt();
		
		System.out.println("competencia. ");
		String competenciaProj = n.next();
		projeto[index1].setCompetencia(competenciaProj);
		
		System.out.println(projeto[index1]);
		
		
	}

	private static void testaindexProjetos(int index) {
		if(index < 0 || index >= funcionario.length){
			throw new ArrayIndexOutOfBoundsException(index);
		} 
		
	}

	private static void imprimeProjetos() {
		for (int i = 0; i < projeto.length; i++) {
			if(projeto[i] != null)
			System.out.println("Projeto "+i + " = "+projeto[i].getNome()+"\n");
		}
		
	}
	
	private static void removerProjetos() {
		imprimeProjetos();
		System.out.println("digite o numero do Projeto: ");
		int index = n.nextInt();
		testaIndexProjetos(index);
			for(int i=index; i<projeto.length-1; i++ ){
				projeto[i] = projeto[i+1];
			}
		imprimeProjetos();
		NumeroProjeto--;
		
	}
	
	private static void testaIndexProjetos(int index) {
		if(index < 0 || index >= NumeroProjeto){
			throw new ArrayIndexOutOfBoundsException(index);
		} 
		
	}

	private static void cadastrarProjeto() {
		Projeto proj = new Projeto();
		testaVetorProjetos();
		System.out.print("nome do projeto:");
		String nome = n.next();
		proj.setNome(nome);
		try{
		System.out.println("digite data inicio no formato (dd/mm/yyyy):");
		String dataIncio = n.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dataIncio, formatter);
		if(date.equals(LocalDate.now())){
			proj.setDataInicio(date);
		}
		if(date.isAfter (date) ){
			System.out.println("Favor inserir data valida. ");
			cadastrarProjeto();
		}else{
			proj.setDataInicio(date);
		}
		System.out.println("digite data final no formato (dd/mm/yyyy):");
		String dataFim = n.next();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1 = LocalDate.parse(dataFim, formatter1);
		if(date1.equals(LocalDate.now())){
			proj.setDataFim(date1);
		}
		if(date1.isAfter (date1) ){
			System.out.println("Favor inserir data valida. ");
			cadastrarProjeto();
		}else{
			proj.setDataFim(date1);
		}
		}catch(DateTimeException erro){
			System.err.print("\nerro no formato da data preenchida: \n");
			cadastrarProjeto();
		}
		
		System.out.println("digite competencia: ");
		String competenciaProj = n.next();
		proj.setCompetencia(competenciaProj);
		
		projeto[NumeroProjeto] = proj;
		System.out.println(projeto[NumeroProjeto]);
		NumeroProjeto++;
	}
	
	private static void testaVetorProjetos() {
		if (NumeroProjeto >= projeto.length){
			Projeto[] projetoNovo = new Projeto [projeto.length*2];
			for(int i = 0; i<projeto.length;i++ ){
				projetoNovo[i] = projeto[i];
			}
			projeto = projetoNovo;
	
		}
	}
	
	private static void addCompetenciaFuncionario(int index) { 
		imprimirFuncionario();
		System.out.println("\ndigite numero do funcionario ");
		index = n.nextInt();
		testaNumFunc(index);
		
		System.out.println("digite competencia. ");
		String compFunc = n.next();
		funcionario[index].setCompetencia(compFunc);
		
		
		System.out.println(funcionario[index]);
		
	}
	
	private static void testaNumFunc(int index) {
		if(index < 0 || index >= NumeroFuncionario){
			throw new ArrayIndexOutOfBoundsException(index);
		} 
		
	}

	private static void removerFuncionario() {
		imprimirFuncionario();
		
		System.out.println("digite o numero do funcionario: ");
		int index = n.nextInt();
		testaNumFunc(index);
			for(int i=index; i<funcionario.length-1; i++ ){
				funcionario[i] = funcionario[i+1];
			
			}
			System.out.println("Favor insirir funcionario valido. ");
		
		NumeroFuncionario--;
	}
	
	private static void imprimirFuncionario() {
		for (int i = 0; i < funcionario.length; i++) {
			if(funcionario[i] != null){
				System.out.println("funcionario "+i+" = "+funcionario[i].getNome());
			}
		}
		
	}

	private static void cadastraFuncionario() {
		testaVetorFunc();
		Funcionario empregado = new Funcionario();
		System.out.println("Nome funcionario. ");
		String nomeFunc = n.next();
		empregado.setNome(nomeFunc);
	
		System.out.println("salario do funcionario. ");
		double salarioFunc = n.nextDouble();
		empregado.setSalario(salarioFunc);
	
		System.out.println("digite competencia: ");
		String compFunc = n.next();
		empregado.setCompetencia(compFunc);
		
		funcionario[NumeroFuncionario] = empregado ;
		NumeroFuncionario++;
		
		System.out.println(NumeroFuncionario);
		for (int i = 0; i < funcionario.length; i++) {
			System.out.println(funcionario[i]);
		}
		
			
	}

	private static void testaVetorFunc() {
		if (NumeroFuncionario >= funcionario.length){
			Funcionario[] funcionarioNovo = new Funcionario [funcionario.length*2];
			for(int i = 0; i<funcionario.length;i++ ){
			funcionarioNovo[i] = funcionario[i];
			System.out.println("fiz o vetor");
			}
			funcionario = funcionarioNovo;
			}
		
		}
	}
	

