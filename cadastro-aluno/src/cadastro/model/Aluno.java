package cadastro.model;

public class Aluno {
	private String rgm;
	private String nome;
	private String cpf;
	private String date;
	private String email;
	private String endereço;
	private String municipio;
	private String estado;
	private String telefone;
	private AlunoCurso curso;
	
	public Aluno(String rgm, String nome, String cpf, String date, String email, String endereço, String municipio,
			String estado, String telefone) {
		this.rgm = rgm;
		this.nome = nome;
		this.cpf = cpf;
		this.date = date;
		this.email = email;
		this.endereço = endereço;
		this.municipio = municipio;
		this.estado = estado;
		this.telefone = telefone;
	}	
	
	public Aluno() {
		
	}
		
	public String getRgm() {
		return rgm;
	}

	public void setRgm(String rgm) {
		this.rgm = rgm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public AlunoCurso getCurso() {
		return curso;
	}

	public void setCurso(AlunoCurso curso) {
		this.curso = curso;
	}
	
}
