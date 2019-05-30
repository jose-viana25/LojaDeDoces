package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Cliente;

public class DaoCliente implements IDaoCliente{
    
    private Connection connection;
	@Override
    public void criarCliente(Cliente cliente){

    	try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "INSERT INTO cliente("
					+ "cpf,nome,email,telefone,data_nascimento,data_cadastro) "
					+ "VALUES(?,?,?,?,?,?);";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, cliente.getCpf());
			pstm.setString(2, cliente.getNome());
			pstm.setString(3, cliente.getEmail());
			pstm.setString(4, cliente.getTelefone());
			pstm.setDate(5, new java.sql.Date(cliente.getDataNascimento().getTime()));
			pstm.setDate(6, new java.sql.Date(cliente.getDataCadastro().getTime()));

			pstm.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    @Override
    public List<Cliente> buscarCliente(Cliente cliente){
    	
    	List<Cliente> listResultado = new ArrayList<>();

		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "SELECT * FROM cliente " 
					+ "WHERE cliente.cpf LIKE ? "
					+ "AND cliente.nome LIKE ? "
					+ "AND cliente.email LIKE ? "
					+ "AND cliente.telefone LIKE ?"
					+ ";";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, "%" + cliente.getCpf() + "%");
			pstm.setString(2, "%" + cliente.getNome() + "%");
			pstm.setString(3, "%" + cliente.getEmail() + "%");
			pstm.setString(4, "%" + cliente.getTelefone() + "%");

			ResultSet rsResultado = pstm.executeQuery();

			connection.close();

			while (rsResultado.next()) {
				Cliente auxCliente = new Cliente();
				auxCliente.setCpf(rsResultado.getString("cpf"));
				auxCliente.setNome(rsResultado.getString("nome"));
				auxCliente.setEmail(rsResultado.getString("email"));
				auxCliente.setTelefone(rsResultado.getString("telefone"));
				auxCliente.setDataNascimento(
						new java.util.Date(rsResultado.getDate("data_nascimento").getTime()));
				auxCliente.setDataCadastro(
						new java.util.Date(rsResultado.getDate("data_cadastro").getTime()));
				
				listResultado.add(auxCliente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listResultado;
    }

    @Override
    public void removerCliente(Cliente cliente){

    }
      @Override
	public List<Cliente> buscarTodosClientes() {
		
    	  List<Cliente> listResultado = new ArrayList<>();

  		try {
  			connection = ConnectionManager.getInstance().getConnection();

  			String query = "SELECT * FROM cliente;";

  			PreparedStatement pstm = connection.prepareStatement(query);

  			ResultSet rsResultado = pstm.executeQuery();

  			connection.close();

  			while (rsResultado.next()) {
  				Cliente auxCliente = new Cliente();
  				auxCliente.setCpf(rsResultado.getString("cpf"));
  				auxCliente.setNome(rsResultado.getString("nome"));
  				auxCliente.setEmail(rsResultado.getString("email"));
  				auxCliente.setTelefone(rsResultado.getString("telefone"));
  				auxCliente.setDataNascimento(
  						new java.util.Date(rsResultado.getDate("data_nascimento").getTime()));
  				auxCliente.setDataCadastro(
  						new java.util.Date(rsResultado.getDate("data_cadastro").getTime()));
  				
  				listResultado.add(auxCliente);
  			}
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}

  		return listResultado;
		
		
	}
	@Override
	public void alterar(Cliente clienteSelecionado, Cliente cliente) {
		try {
			connection = ConnectionManager.getInstance().getConnection();

			String query = "UPDATE cliente SET "
					+ "cliente.cpf=?, "
					+ "cliente.nome=?, "
					+ "cliente.email=?, "
					+ "cliente.telefone=?,"
					+ "cliente.dataNascimento=? "
					+ "WHERE funcionario.cpf=?;";

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setString(1, cliente.getCpf());
			pstm.setString(2, cliente.getNome());
			pstm.setString(3, cliente.getEmail());
			pstm.setString(4, cliente.getTelefone());
			pstm.setDate(5, new java.sql.Date(cliente.getDataNascimento().getTime()));
			pstm.setString(6, cliente.getCpf());

			pstm.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
