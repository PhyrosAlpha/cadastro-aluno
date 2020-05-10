package cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cadastro.model.Disciplina;
import cadastro.model.Matricula;

public class MatriculaDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	

	public MatriculaDao() throws Exception {
		try {
			this.conn = ConnectionDataBase.getConnection();
			
			
		}catch(Exception e) {
			throw new Exception("Erro AlunoDao " + e.getMessage());		
		}	
	}
	
	public void matricularDisciplina(Matricula matricula) throws Exception  {
		try {
			String sql = "INSERT INTO curso_matricula VALUE(" + 
															"?," + 
															"?," + 
															"?," + 
															"DEFAULT," + 
															"DEFAULT," + 
															"DEFAULT," + 
															"DEFAULT)";
				
			ps = conn.prepareStatement(sql);
			ps.setInt(1, matricula.getAlunoCursoID());
			ps.setInt(2, matricula.getDisciplinaID());
			ps.setInt(3, matricula.getCursoMatriculaID());
			ps.executeUpdate();
				
		}catch(Exception e) {	
			throw new Exception("Erro AlunoDao - matricularDisciplina" + e.getMessage());					
		}
	
	}
	
	public List<Matricula> consultarDisciplinasMatriculadas(int alunoCursoID) throws Exception {
		List<Matricula> lista = new ArrayList<Matricula>();
	
		try {
			String sql = "SELECT * FROM curso_matricula am " + 
						 "INNER JOIN disciplina d ON am.disciplinaID = d.disciplinaID " + 
						 "WHERE aluno_cursoID = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, alunoCursoID);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Disciplina disciplina = new Disciplina(rs.getInt("DisciplinaID"), 
													   rs.getString("nome"), 
													   rs.getInt("carga_horaria"));
				
				Matricula matricula = new Matricula(rs.getInt("aluno_cursoID"),
													rs.getInt("curso_matriculaID"),
													rs.getInt("disciplinaID"),
													rs.getString("status"),
													rs.getString("semestre"),
													rs.getDouble("nota"),
													rs.getInt("falta"));			
				matricula.setDisciplina(disciplina);		
				lista.add(matricula);			
			}
			return lista;
					
		}catch(Exception e) {
			throw new Exception("Erro AlunoDao - consultasDisciplinasMatriculadas " + e.getMessage());	
		}	
	}
	
	public ResultSet consultarDisciplinasMatriculadasTable(int alunoCursoID) throws Exception {	
		try {
			String sql = "SELECT curso_matriculaID AS MatriculaID, "
					+ "nome AS Nome, status AS Status, "
					+ "semestre AS Semestre, nota AS Nota, "
					+ "falta AS Falta, carga_horaria AS Horas "
					+ "FROM curso_matricula am "
					+ "INNER JOIN disciplina d ON am.disciplinaID = d.disciplinaID "
					+ "WHERE aluno_cursoID = ? "
					+ "ORDER BY Status";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, alunoCursoID);
			rs = ps.executeQuery();
			return rs;
			
		}catch(Exception e) {
			throw new Exception("Erro AlunoDao - consultasDisciplinasMatriculadas " + e.getMessage());	
		}
		
	}
	
	public void alterarDadosMatricula(Matricula matricula) throws Exception {
		try {
			String sql =  "UPDATE curso_matricula "
						+ "SET status = ?, "
						+ "semestre = ?, "
						+ "nota = ?, "
						+ "falta = ? "
						+ "WHERE curso_matriculaID = ?";
			
			System.out.println(matricula.toString());
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, matricula.getStatus());
			ps.setString(2, matricula.getSemestre());
			ps.setDouble(3, matricula.getNota());
			ps.setInt(4, matricula.getFaltas());
			ps.setInt(5, matricula.getCursoMatriculaID());	
			ps.executeUpdate();
					
		}catch(Exception e) {
			throw new Exception("Erro AlunoDao - alterarDadosMatricula " + e.getMessage());		
		}		
	}
	
	public void excluirDisciplina(int cursoMatriculaID) throws Exception{
		try {
			String sql =  "DELETE FROM curso_matricula "
						+ "WHERE curso_matriculaID = ? "
						+ "LIMIT 1";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cursoMatriculaID);
			ps.executeUpdate();
			

		}catch(Exception e) {
			throw new Exception("Erro AlunoDao - excluirDisciplina " + e.getMessage());					
		}		
	}
}
