package cadastro.model;

import java.util.List;
import java.util.ArrayList;


public class AlunoCurso {
	private int alunoCursoId;
	private String periodo;
	private String campus;
	private String rgm;
	private int cursoId;
	private List matricula;
	
	public AlunoCurso(int alunoCursoId, String periodo, String campus, String rgm, int cursoId, List matricula) {

		this.alunoCursoId = alunoCursoId;
		this.periodo = periodo;
		this.campus = campus;
		this.rgm = rgm;
		this.cursoId = cursoId;
		this.matricula = new ArrayList<Matricula>();
	}
	
	
	public AlunoCurso() {
		this.alunoCursoId = 0;
		
	}
		
	

	public int getAlunoCursoId() {
		return alunoCursoId;
	}

	public void setAlunoCursoId(int alunoCursoId) {
		this.alunoCursoId = alunoCursoId;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getRgm() {
		return rgm;
	}

	public void setRgm(String rgm) {
		this.rgm = rgm;
	}

	public int  getCursoId() {
		return cursoId;
	}

	public void setCursoId(int  cursoId) {
		this.cursoId = cursoId;
	}

	public List getMatricula() {
		return matricula;
	}

	public void setMatricula(ArrayList matricula) {
		this.matricula = matricula;
	}
}
