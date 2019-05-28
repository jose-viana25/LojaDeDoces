package controller;

import java.util.List;

import dao.DaoCliente;
import dao.DaoException;
import dao.IDaoCliente;
import entity.Cliente;

public class CtrCliente{
    IDaoCliente daoCliente = new DaoCliente();

    public void cadastrarCliente(Cliente cliente)  throws ControlException{
        try {
			daoCliente.criarCliente(cliente) ;
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public List<Cliente> pesquisarCliente(Cliente cliente)  throws ControlException{
        try {
			return daoCliente.buscarCliente(cliente);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    public List<Cliente> pesquisarClientes() throws ControlException{
        try {
			return daoCliente.buscarTodosClientes();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
}