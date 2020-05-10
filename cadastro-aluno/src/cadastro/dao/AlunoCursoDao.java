package cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cadastro.model.Aluno;
import cadastro.model.AlunoCurso;
import cadastro.model.Curso;
import cadastro.model.Disciplina;
import cadastro.model.Matricula;

public class AlunoCursoDao {
	private Connection conn;
	private PreparedStatement ps;
//	private ResultSet rs;
	
	
	public AlunoCursoDao() throws Exception {
		try {
			this.conn = ConnectionDataBase.getConnection();
			
			
		}catch(Exception e) {
			throw new Exception("Erro AlunoDao " + e.getMessage());		
		}	
	}
	
	public void matricularCurso(AlunoCurso alunoCurso) throws Exception{
		try {
			String sql = "INSERT INTO aluno_curso VALUES("
					+"?, ?, ?, ?, ?)";	
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, alunoCurso.getRgm());
			ps.setInt(2, alunoCurso.getCursoId());
			ps.setInt(3, alunoCurso.getAlunoCursoId());
			ps.setString(4, alunoCurso.getPeriodo());
			ps.setString(5, alunoCurso.getCampus());
			
			ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception("Erro AlunoCursoDao - matricularCurso " + e.getMessage());
			
		}	
	}
	
	

}
