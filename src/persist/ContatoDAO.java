package persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DAO;
import entity.Contato;

// Classe responsável por manter todas as operações de C.R.U.D
public class ContatoDAO extends DAO {

	private Connection connection;

	public ContatoDAO() {
	}

	public void addContato(Contato contato) throws SQLException {
		// call para abertura da conexão
		openConnection();
		PreparedStatement pstmt = null;

		try {
			// Query template para envio de dados
			String queryString = "insert into contatos(nome, email, telefone) values(?, ?, ?)";

			// instrução parametrizada para envio de multiplas requisições de forma
			// eficiente
			// também ajuda na segurança de conexão com o banco, impedindo o SQL injection
			pstmt = connection.prepareStatement(queryString);

			/** biding **/
			// setString(param1, param2) -> param1 define o index do coringa(?) e o param2
			// define o valor
			// a contagem dos indexes de coringas começa de 1
			pstmt.setString(1, contato.getNome());
			pstmt.setString(2, contato.getEmail());
			pstmt.setString(3, contato.getTelefone());

			if (pstmt.executeUpdate() == 0) {
				throw new SQLException("Ocorreu um erro ao adicionar um contato");
			}
		} finally { // SEMPRE executa
			if (connection != null)
				connection.close();
			if (pstmt != null)
				pstmt.close();
		}
	}

	public Contato findContatoById(Long id) throws SQLException {

		openConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String queryString = "select * from contatos where id = ?";
			pstmt = connection.prepareStatement(queryString);

			/** biding **/
			pstmt.setLong(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				return new Contato(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}

			return null;
		} finally {
			if (connection != null)
				connection.close();
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
		}
	}

	public List<Contato> ListContato() throws SQLException {

		openConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			List<Contato> lista = new ArrayList<Contato>();

			String queryString = "select * from contatos";
			pstmt = connection.prepareStatement(queryString);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				lista.add(new Contato(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}

			return lista;
		} finally {
			if (connection != null)
				connection.close();
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
		}
	}

	public void updateContato(Contato contato) throws SQLException {
		openConnection();
		PreparedStatement pstmt = null;

		try {
			String queryString = "update contatos set nome = ?, email = ?, telefone = ? where id = ?";

			pstmt = connection.prepareStatement(queryString);

			pstmt.setString(1, contato.getNome());
			pstmt.setString(2, contato.getEmail());
			pstmt.setString(3, contato.getTelefone());
			pstmt.setLong(4, contato.getId());

			if (pstmt.executeUpdate() == 0) {
				throw new SQLException("Ocorreu um erro ao atualizar o contato");
			}
		} finally {
			if (connection != null)
				connection.close();
			if (pstmt != null)
				pstmt.close();
		}
	}

	public void deleteContato(Long id) throws SQLException {
		openConnection();
		PreparedStatement pstmt = null;

		try {
			String queryString = "delete from contatos where id = ?";

			pstmt = connection.prepareStatement(queryString);

			pstmt.setLong(1, id);

			if (pstmt.executeUpdate() == 0) {
				throw new SQLException("Ocorreu um erro ao deletar um contato");
			}
		} finally {
			if (connection != null)
				connection.close();
			if (pstmt != null)
				pstmt.close();
		}
	}

	private void openConnection() {
		try {
			connection = getConnect();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Não foi possível efetuar a conexão com o banco. Msg de erro: " + e);
		}
	}

	/*
	 * Exclusão Atualização
	 */

	public static void main(String[] args) {
		Contato c = new Contato("Luis", "luis@gmail.com", "2121-2121");

		try {
			new ContatoDAO().addContato(c);
			System.out.println("Dados gravados com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Falha ao gravar");
		}
	}
}