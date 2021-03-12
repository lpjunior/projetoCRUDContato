package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public DAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Classe não localizada. Erro ocorrido: " + e);
		}
	}
	
	protected Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/crud_db?createDatabaseIfNotExist=true","root","");
	}
	
	/*
	 * public static void main(String[] args) { DAO dao = new DAO();
	 * 
	 * try { if(dao.getConnect() != null) { System.out.println("Conectado"); } }
	 * catch (SQLException e) { e.printStackTrace();
	 * System.out.println("Não conectado"); } }
	 */
}
