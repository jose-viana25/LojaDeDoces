package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Funcionario;

public class DaoFuncionario implements IDaoFuncionario {

	

	private Connection connection;

	@Override
	public void criarFuncionario(Funcionario funcionario) {

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "INSERT INTO funcionario("
					+ "cpf,nome,email,senha,telefone,data_cadastro) "
					+ "VALUES(?,?,?,?,?,?);";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, funcionario.getCpf());
			pstm.setString(2, funcionario.getNome());
			pstm.setString(3, funcionario.getEmail());
			pstm.setString(4, funcionario.getSenha());
			pstm.setString(5, funcionario.getTelefone());
			pstm.setDate(6, new java.sql.Date(funcionario.getDataCadastro().getTime()));

			pstm.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Funcionario> buscarFuncionario(Funcionario funcionario) {

		List<Funcionario> listResultado = new ArrayList<>();

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "SELECT * FROM funcionario " 
					+ "WHERE funcionario.cpf LIKE ? "
					+ "AND funcionario.nome LIKE ? "
					+ "AND funcionario.email LIKE ? "
					+ "AND funcionario.telefone LIKE ?"
					+ ";";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, "%" + funcionario.getCpf() + "%");
			pstm.setString(2, "%" + funcionario.getNome() + "%");
			pstm.setString(3, "%" + funcionario.getEmail() + "%");
			pstm.setString(4, "%" + funcionario.getTelefone() + "%");

			ResultSet rsResultado = pstm.executeQuery();

			connection.close();

			while (rsResultado.next()) {
				Funcionario auxFuncionario = new Funcionario();
				auxFuncionario.setCpf(rsResultado.getString("cpf"));
				auxFuncionario.setNome(rsResultado.getString("nome"));
				auxFuncionario.setEmail(rsResultado.getString("email"));
				auxFuncionario.setTelefone(rsResultado.getString("telefone"));
				auxFuncionario.setDataCadastro(
						new java.util.Date(rsResultado.getDate("data_cadastro").getTime()));
				
				listResultado.add(auxFuncionario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listResultado;

	}

	
	@Override
	public List<Funcionario> buscarTodosFuncionario() {
		
		List<Funcionario> listResultado = new ArrayList<>();

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "SELECT * FROM funcionario;";

			PreparedStatement pstm = connection.prepareStatement(query);

			ResultSet rsResultado = pstm.executeQuery();

			connection.close();

			while (rsResultado.next()) {
				Funcionario auxFuncionario = new Funcionario();
				auxFuncionario.setCpf(rsResultado.getString("cpf"));
				auxFuncionario.setNome(rsResultado.getString("nome"));
				auxFuncionario.setEmail(rsResultado.getString("email"));
				auxFuncionario.setTelefone(rsResultado.getString("telefone"));
				auxFuncionario.setDataCadastro(
						new java.util.Date(rsResultado.getDate("data_cadastro").getTime()));
				
				listResultado.add(auxFuncionario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listResultado;
		
		
	}
	
	@Override
	public void alterarFuncionario(Funcionario funcionarioSelecionado,Funcionario funcionario) {
		
		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "UPDATE funcionario SET "
					+ "funcionario.cpf=?, "
					+ "funcionario.nome=?, "
					+ "funcionario.email=?, "
					+ "funcionario.senha=?, "
					+ "funcionario.telefone=? "
					+ "WHERE funcionario.cpf=?;";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, funcionario.getCpf());
			pstm.setString(2, funcionario.getNome());
			pstm.setString(3, funcionario.getEmail());
			pstm.setString(4, funcionario.getSenha());
			pstm.setString(5, funcionario.getTelefone());
			pstm.setString(6, funcionarioSelecionado.getCpf());

			pstm.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void removerFuncionario(Funcionario funcionario) {
		
		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query ="DELETE FROM funcionario "
					+ "WHERE funcionario.cpf=?;";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, funcionario.getCpf());

			pstm.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
