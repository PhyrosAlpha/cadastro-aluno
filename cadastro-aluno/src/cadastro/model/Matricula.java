package cadastro.model;

public class Matricula {
	private int alunoCursoID;
	private int cursoMatriculaID;
	private int disciplinaID;
	private String status;
	private String semestre;
	private double nota;
	private int faltas;
	private Disciplina disciplina;


	public Matricula(int alunoCursoID, int cursoMatriculaID, int disciplinaID, String status, String semestre,
			double nota, int faltas) {

		this.alunoCursoID = alunoCursoID;
		this.cursoMatriculaID = cursoMatriculaID;
		this.disciplinaID = disciplinaID;
		this.status = status;
		this.semestre = semestre;
		this.nota = nota;
		this.faltas = faltas;
	}

	public Matricula() {
		this.disciplinaID = 0;
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public int getAlunoCursoID() {
		return alunoCursoID;
	}

	public void setAlunoCursoID(int alunoCursoID) {
		this.alunoCursoID = alunoCursoID;
	}

	public int getCursoMatriculaID() {
		return cursoMatriculaID;
	}

	public void setCursoMatriculaID(int cursoMatriculaID) {
		this.cursoMatriculaID = cursoMatriculaID;
	}

	public int getDisciplinaID() {
		return disciplinaID;
	}

	public void setDisciplinaID(int disciplinaID) {
		this.disciplinaID = disciplinaID;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	
	@Override
	public String toString() {
		return "Matricula [alunoCursoID=" + alunoCursoID + ", cursoMatriculaID=" + cursoMatriculaID + ", disciplinaID="
				+ disciplinaID + ", status=" + status + ", semestre=" + semestre + ", nota=" + nota + ", faltas="
				+ faltas + ", disciplina=" + disciplina + "]";
	}


	
	

}
