package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Produto;

public class DaoProduto implements IDaoProduto {
	

	private Connection connection;

	@Override
	public void criarProduto(Produto produto) {

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "INSERT INTO produto("
					+ "nome,valor,quantidade,validade,"
					+ "tipo_de_produtoNome,fornecedorCnpj) "
					+ "VALUES(?,?,?,?,?,?);";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, produto.getNome());
			pstm.setDouble(2, produto.getValor());
			pstm.setInt(3, produto.getQuantidadeEmEstoque());
			pstm.setDate(4, new java.sql.Date(
					produto.getValidade().getTime()));
			pstm.setString(5, produto.getNome_tipoDeProduto());
			pstm.setString(6, produto.getCnpj_fornecedor());

			pstm.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public List<Produto> buscarProduto(Produto produto) {

		List<Produto> listResultado = new ArrayList<>();

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "SELECT * FROM produto " 
					+ "WHERE produto.nome LIKE ?;";
					/*+ "AND produto.valor LIKE ? "
					+ "AND produto.quantidade LIKE ? "
					+ "AND produto.validade LIKE ? "
					+ "AND produto.tipo_de_produtoNome LIKE ? "
					+ "AND produto.fornecedorCnpj LIKE ?;";*/

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, "%" + produto.getNome() + "%");
			/*pstm.setString(2, "%" + produto.getValor() + "%");
			pstm.setString(3, "%" + produto.getQuantidadeEmEstoque() + "%");
			pstm.setString(4, "%" + new java.sql.Date(produto.getValidade().getTime()) + "%");
			pstm.setString(4, "%" + produto.getNome_tipoDeProduto() + "%");
			pstm.setString(5, "%" + produto.getCnpj_fornecedor() + "%");*/

			ResultSet rsResultado = pstm.executeQuery();

			connection.close();

			while (rsResultado.next()) {
				Produto auxProduto = new Produto();
				auxProduto.setNome(rsResultado.getString("nome"));
				auxProduto.setValor(rsResultado.getDouble("valor"));
				auxProduto.setQuantidadeEmEstoque(rsResultado.getInt("quantidade"));
				auxProduto.setValidade(rsResultado.getDate("validade"));
				auxProduto.setNome_tipoDeProduto(rsResultado.getString("tipo_de_produtoNome"));
				auxProduto.setCnpj_fornecedor(rsResultado.getString("fornecedorCnpj"));
				listResultado.add(auxProduto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listResultado;

	}

	
	@Override
	public List<Produto> buscarTodosProduto() {
		
		List<Produto> listResultado = new ArrayList<>();

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "SELECT * FROM produto;";

			PreparedStatement pstm = connection.prepareStatement(query);

			ResultSet rsResultado = pstm.executeQuery();

			connection.close();

			while (rsResultado.next()) {
				Produto auxProduto = new Produto();
				auxProduto.setNome(rsResultado.getString("nome"));
				auxProduto.setValor(rsResultado.getDouble("valor"));
				auxProduto.setQuantidadeEmEstoque(rsResultado.getInt("quantidade"));
				auxProduto.setValidade(rsResultado.getDate("validade"));
				auxProduto.setNome_tipoDeProduto(rsResultado.getString("tipo_de_produtoNome"));
				auxProduto.setCnpj_fornecedor(rsResultado.getString("fornecedorCnpj"));
				listResultado.add(auxProduto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listResultado;
		
		
	}
	
	@Override
	public void alterarProduto(Produto produtoSelecionado,Produto produto) {
		
		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "UPDATE produto SET "
					+ "produto.nome=?, "
					+ "produto.valor=?, "
					+ "produto.quantidade=?, "
					+ "produto.validade=? "
					//+ "produto.tipo_de_produtoNome=?, "
					//+ "produto.fornecedorCnpj=? "
					+ "WHERE produto.nome=?;";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, produto.getNome());
			pstm.setDouble(2, produto.getValor());
			pstm.setInt(3, produto.getQuantidadeEmEstoque());
			pstm.setDate(4, new java.sql.Date(produto.getValidade().getTime()));
			//pstm.setString(5, produto.getNome_tipoDeProduto());
			//pstm.setString(6, produto.getCnpj_fornecedor());
			pstm.setString(5, produtoSelecionado.getNome());

			pstm.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void removerProduto(Produto produto) {
		
		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "DELETE FROM produto WHERE produto.nome=?;";

			PreparedStatement pstm = connection.prepareStatement(query);
			
			pstm.setString(1, produto.getNome());

			pstm.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
