package cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cadastro.model.Disciplina;

public class DisciplinaDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public DisciplinaDao() throws Exception {
		try {
			this.conn = ConnectionDataBase.getConnection();
			
			
		}catch(Exception e) {
			throw new Exception("Erro AlunoDao " + e.getMessage());		
		}	
	}
	
	public List listarDisciplinas() throws Exception{
		List<Disciplina> lista = new ArrayList<Disciplina>();
		try {
			String sql = "SELECT disciplinaID, nome FROM disciplina";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Disciplina disciplina = new Disciplina();
				int disciplinaId = rs.getInt("disciplinaID");
				String nome = rs.getString("nome");
				
				disciplina.setDisciplinaId(disciplinaId);
				disciplina.setNome(nome);
				lista.add(disciplina);	
			}
			return lista;
			
			
		}catch(Exception e) {
			throw new Exception("Erro AlunoDao - listarDisciplinas "+e.getMessage()); 			
		}		
	}

}
