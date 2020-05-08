package cadastro.model;

public class Disciplina {
	private int disciplinaId;
	private String nome;
	private int horaAula;
	
	public Disciplina(int disciplinaId, String nome, int horaAula) {
		this.disciplinaId = disciplinaId;
		this.nome = nome;
		this.horaAula = horaAula;
	}
	
	public Disciplina() {
		
	}

	public int getDisciplinaId() {
		return disciplinaId;
	}

	public void setDisciplinaId(int disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getHoraAula() {
		return horaAula;
	}

	public void setHoraAula(int horaAula) {
		this.horaAula = horaAula;
	}

	@Override
	public String toString() {
		return "Disciplina [disciplinaId=" + disciplinaId + ", nome=" + nome + ", horaAula=" + horaAula + "]";
	}

	
	

}
