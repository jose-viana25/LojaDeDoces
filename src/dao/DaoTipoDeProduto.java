package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.TipoDeProduto;

public class DaoTipoDeProduto implements IDaoTipoDeProduto {

	private Connection connection;

	@Override
	public void criarTipoDeProduto(TipoDeProduto tipoDeProduto) throws DaoException {

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "INSERT INTO tipo_de_produto(nome,descricao) VALUES(?,?);";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, tipoDeProduto.getNome());
			pstm.setString(2, tipoDeProduto.getDescricao());

			pstm.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<TipoDeProduto> buscarTipoDeProduto(TipoDeProduto tipoDeProduto) {

		List<TipoDeProduto> listResultado = new ArrayList<>();

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "SELECT * FROM tipo_de_produto " + "WHERE tipo_de_produto.nome LIKE ? "
					+ "AND tipo_de_produto.descricao LIKE ?;";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, "%" + tipoDeProduto.getNome().toLowerCase() + "%");
			pstm.setString(2, "%" + tipoDeProduto.getDescricao().toLowerCase() + "%");

			ResultSet rsResultado = pstm.executeQuery();

			connection.close();

			while (rsResultado.next()) {
				TipoDeProduto auxTipoDeProduto = new TipoDeProduto();
				auxTipoDeProduto.setNome(rsResultado.getString("nome"));
				auxTipoDeProduto.setDescricao(rsResultado.getString("descricao"));
				listResultado.add(auxTipoDeProduto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listResultado;

	}

	@Override
	public List<TipoDeProduto> buscarTodosTipoDeProduto() {

		List<TipoDeProduto> listResultado = new ArrayList<>();

		try {
			connection = ConnectionManager.getInstance().getConnection();
			String query = "SELECT * FROM tipo_de_produto;";

			PreparedStatement pstm = connection.prepareStatement(query);

			ResultSet rsResultado = pstm.executeQuery();

			connection.close();

			while (rsResultado.next()) {
				TipoDeProduto auxTipoDeProduto = new TipoDeProduto();
				auxTipoDeProduto.setNome(rsResultado.getString("nome").toLowerCase());
				auxTipoDeProduto.setDescricao(rsResultado.getString("descricao").toLowerCase());
				listResultado.add(auxTipoDeProduto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listResultado;
	}

	@Override
	public void alterarTipoDeProduto(TipoDeProduto tipoDeProdutoSelecionado, TipoDeProduto tipoDeProduto) {

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "UPDATE tipo_de_produto SET "
					+ "tipo_de_produto.nome=?, "
					+ "tipo_de_produto.descricao=? "
					+ "WHERE tipo_de_produto.nome=?;";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, tipoDeProduto.getNome());
			pstm.setString(2, tipoDeProduto.getDescricao());
			pstm.setString(3, tipoDeProdutoSelecionado.getNome());

			pstm.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void removerTipoDeProduto(TipoDeProduto tipoDeProduto) {

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query ="DELETE FROM tipo_de_produto "
					+ "WHERE tipo_de_produto.nome=?;";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, tipoDeProduto.getNome());

			pstm.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
