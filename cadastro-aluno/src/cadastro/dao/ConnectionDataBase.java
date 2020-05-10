package cadastro.dao;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionDataBase {
	
	public static Connection getConnection() throws Exception {	
		try {
			
			String login = "root";
			String senha = "digite-a-senha-aqui";
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/cadastro_aluno";
			Class.forName(driver);
			System.out.println("Conectado ao DB");
			
			return DriverManager.getConnection(url, login, senha);
			
			
		}catch(Exception e) {
			throw new Exception("Erro Connection DataBase" + e.getMessage());
		}
	}
}

