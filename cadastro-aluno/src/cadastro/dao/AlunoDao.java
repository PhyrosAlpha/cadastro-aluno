package cadastro.dao;

import java.sql.Connection;   
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import cadastro.model.Aluno;
import cadastro.model.AlunoCurso;



public class AlunoDao {
	private Aluno aluno;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public AlunoDao() throws Exception {
		try {
			this.conn = ConnectionDataBase.getConnection();
			
			
		}catch(Exception e) {
			throw new Exception("Erro AlunoDao " + e.getMessage());		
		}	
	}
	
	
	public void salvar(Aluno aluno) throws Exception {            // Incluir aluno ao banco de dados
	
		try {
			String sql = "INSERT INTO aluno VALUES("
						+"?, ?, ?, STR_TO_DATE(?,'%d-%m-%Y'), ?, ?, ?, ?, ?)";		
			ps = conn.prepareStatement(sql);
			ps.setString(1, aluno.getRgm());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getCpf());
			ps.setString(4, aluno.getDate());
			ps.setString(5, aluno.getEmail());
			ps.setString(6, aluno.getEndereço());
			ps.setString(7, aluno.getMunicipio());
			ps.setString(8, aluno.getEstado());	
			ps.setString(9, aluno.getTelefone());	
			ps.executeUpdate();
				
		}catch(Exception e) {
			throw new Exception("Erro AlunoDao - Salvar " + e.getMessage());		
		}

	}
	
	public void excluirAluno(String rgm) throws Exception {       //Excluir Aluno do banco de dados
		try {
			String sql = "DELETE FROM aluno "
						+ "WHERE rgm = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, rgm);
			ps.executeUpdate();
	
		}catch(Exception e) {
			throw new Exception("Erro AlunoDao - excluirAluno " + e.getMessage());	
					
		}			
	}
	
	public Aluno consultarAluno(String rgm) throws Exception {          //Consultar aluno e curso
		aluno = new Aluno();
		AlunoCurso alunoCurso = new AlunoCurso();
	
	try {		
		String sql =  "SELECT c.rgm, nome, cpf, "
					+ "DATE_FORMAT(nasc, \"%d-%m-%Y\") AS nasc, email, endereco, "
					+ "municipio, estado, telefone, cursoId, "
					+ "aluno_cursoID, periodo, campus "
					+ "FROM aluno a INNER JOIN aluno_curso c ON a.rgm = c.rgm "
					+ "WHERE a.rgm = '" + rgm + "'";
		
		
		ps = conn.prepareStatement(sql);
//		ps.setString(1, rgm);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			String rgmAluno = rs.getNString("rgm");
			String nome = rs.getString("nome");
			String cpf = rs.getString("cpf");
			String nasc = rs.getString("nasc");
			String email = rs.getString("email");
			String endereco = rs.getString("endereco");
			String municipio = rs.getString("municipio");
			String estado = rs.getString("estado");
			String telefone = rs.getString("telefone");
			
			int cursoId = rs.getInt("cursoId");
			int aluno_cursoID = rs.getInt("aluno_cursoID");
			String periodo = rs.getString("periodo");
			String campus = rs.getString("campus");
			
			alunoCurso.setCursoId(cursoId);
			alunoCurso.setAlunoCursoId(aluno_cursoID);
			alunoCurso.setPeriodo(periodo);
			alunoCurso.setCampus(campus);
			
			aluno.setRgm(rgmAluno);
			aluno.setNome(nome);
			aluno.setCpf(cpf);
			aluno.setDate(nasc);
			aluno.setEmail(email);
			aluno.setEndereço(endereco);
			aluno.setMunicipio(municipio);
			aluno.setEstado(estado);
			aluno.setTelefone(telefone);
			
			aluno.setCurso(alunoCurso);
			return aluno;
		}else return null;
		
	}catch(Exception e) {
		throw new Exception("Erro AlunoDao - consultarAluno "+e.getMessage()); 	
	}		
}
	
	public void alterarDadosAluno(Aluno aluno) throws Exception{                 //Alterar dados aluno
		try {
			String sql =  "UPDATE aluno "
						+ "SET nome = ?, "
						+ "cpf = ?, "
						+ "nasc = STR_TO_DATE(? ,'%d-%m-%Y'), "
						+ "email = ?, "
						+ "endereco = ?, "
						+ "municipio = ?, "
						+ "estado = ?, "
						+ "telefone = ? "
						+ "WHERE rgm = ? "
						+ "LIMIT 1";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getCpf());
			ps.setString(3, aluno.getDate());
			ps.setString(4, aluno.getEmail());
			ps.setString(5, aluno.getEndereço());
			ps.setString(6, aluno.getMunicipio());
			ps.setString(7, aluno.getEstado());	
			ps.setString(8, aluno.getTelefone());	
			ps.setString(9, aluno.getRgm());
			ps.executeUpdate();
								
		}catch(Exception e) {
			throw new Exception("Erro AlunoDao - alterarDadosAlunos " + e.getMessage());			
		}		
	}

}
