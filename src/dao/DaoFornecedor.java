package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Fornecedor;

public class DaoFornecedor implements IDaoFornecedor {

	private Connection connection;

	@Override
	public void criarFornecedor(Fornecedor fornecedor) {

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "INSERT INTO fornecedor(" 
			+ "cnpj,nome,endereco,descricao) " 
			+ "VALUES(?,?,?,?);";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, fornecedor.getCnpj());
			pstm.setString(2, fornecedor.getNome().toLowerCase());
			pstm.setString(3, fornecedor.getEndereco().toLowerCase());
			pstm.setString(4, fornecedor.getDescricao().toLowerCase());

			pstm.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Fornecedor> buscarFornecedor(Fornecedor fornecedor) {

		List<Fornecedor> listResultado = new ArrayList<>();

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "SELECT * FROM fornecedor " 
					+ "WHERE fornecedor.cnpj LIKE ? " 
					+ "AND fornecedor.nome LIKE ? "
					+ "AND fornecedor.endereco LIKE ? " 
					+ "AND fornecedor.descricao LIKE ?;";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, "%" + fornecedor.getCnpj() + "%");
			pstm.setString(2, "%" + fornecedor.getNome() + "%");
			pstm.setString(3, "%" + fornecedor.getEndereco() + "%");
			pstm.setString(4, "%" + fornecedor.getDescricao() + "%");

			ResultSet rsResultado = pstm.executeQuery();

			connection.close();

			while (rsResultado.next()) {
				Fornecedor auxFornecedor = new Fornecedor();
				auxFornecedor.setCnpj(rsResultado.getString("cnpj"));
				auxFornecedor.setNome(rsResultado.getString("nome"));
				auxFornecedor.setEndereco(rsResultado.getString("endereco"));
				auxFornecedor.setDescricao(rsResultado.getString("descricao"));
				listResultado.add(auxFornecedor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listResultado;

	}

	@Override
	public List<Fornecedor> buscarTodosFornecedor() {

		List<Fornecedor> listResultado = new ArrayList<>();

		try {
			connection = ConnectionManager.getInstance().getConnection();
			String query = "SELECT * FROM fornecedor;";

			PreparedStatement pstm = connection.prepareStatement(query);

			ResultSet rsResultado = pstm.executeQuery();

			connection.close();

			while (rsResultado.next()) {
				Fornecedor auxFornecedor = new Fornecedor();
				auxFornecedor.setCnpj(rsResultado.getString("cnpj"));
				auxFornecedor.setNome(rsResultado.getString("nome"));
				auxFornecedor.setEndereco(rsResultado.getString("endereco"));
				auxFornecedor.setDescricao(rsResultado.getString("descricao"));
				listResultado.add(auxFornecedor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listResultado;

	}

	@Override
	public void alterarFornecedor(Fornecedor fornecedorSelecionado, Fornecedor fornecedor) {

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "UPDATE fornecedor SET " 
					+ "fornecedor.cnpj=?," 
					+ "fornecedor.nome=?,"
					+ "fornecedor.endereco=?," 
					+ "fornecedor.descricao=? " 
					+ "WHERE fornecedor.cnpj=?;";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, fornecedor.getCnpj());
			pstm.setString(2, fornecedor.getNome());
			pstm.setString(3, fornecedor.getEndereco());
			pstm.setString(4, fornecedor.getDescricao());
			pstm.setString(5, fornecedorSelecionado.getCnpj());

			pstm.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void removerFornecedor(Fornecedor fornecedor) {

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "DELETE FROM fornecedor " + "WHERE fornecedor.cnpj=?;";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, fornecedor.getCnpj());

			pstm.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
