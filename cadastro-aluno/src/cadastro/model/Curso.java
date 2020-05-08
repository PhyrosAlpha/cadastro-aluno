package cadastro.model;

import java.util.List;

public class Curso {
	private int cursoId;
	private String nome;
	private int semestres;
	private String tipo;
	private String area;
	private List disciplinas;
	
	public Curso(int cursoId, String nome, int semestres, String tipo, String area, List disciplinas) {
		this.cursoId = cursoId;
		this.nome = nome;
		this.semestres = semestres;
		this.tipo = tipo;
		this.area = area;
		this.disciplinas = disciplinas;
	}
	
	public Curso() {
		
	}

	public int getCursoId() {
		return cursoId;
	}

	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSemestres() {
		return semestres;
	}

	public void setSemestres(int semestres) {
		this.semestres = semestres;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List disciplinas) {
		this.disciplinas = disciplinas;
	}	
}
