package cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cadastro.model.Curso;

public class CursoDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public CursoDao() throws Exception {
		try {
			this.conn = ConnectionDataBase.getConnection();
			
			
		}catch(Exception e) {
			throw new Exception("Erro AlunoDao " + e.getMessage());		
		}	
	}
	
	public Curso consultaCurso(int idCurso) throws Exception{
		try {
			String sql = "SELECT * FROM curso "
					+ "WHERE cursoId = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idCurso);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Curso curso = new Curso();
				curso.setCursoId(rs.getInt("cursoId"));
				curso.setNome(rs.getString("nome"));
				curso.setTipo(rs.getString("tipo"));
				curso.setArea(rs.getString("area_conhecimento"));
				
				return curso;	
			}
			return null;
			
			
		}catch(Exception e) {
			throw new Exception("Erro CursoDao - consultaCurso "+e.getMessage()); 		
		}		
	}
	
	public List<Curso> listarCursos() throws Exception {
		List<Curso> lista = new ArrayList<Curso>();
		
		try {
			String sql = "SELECT cursoId, nome FROM curso";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Curso curso = new Curso();    
				int cursoId = rs.getInt("cursoId");
				String nome = rs.getString("nome");
				
				curso.setCursoId(cursoId);
				curso.setNome(nome);
				lista.add(curso);			
			}
			return lista;
	
		}catch(Exception e) {
			throw new Exception("Erro AlunoDao - listarCursos "+e.getMessage()); 		
		}		
	}

}
