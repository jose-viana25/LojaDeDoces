package dao;
import java.util.List;

import entity.Cliente;

public interface IDaoCliente{
    public void criarCliente(Cliente cliente) throws DaoException;
    public List<Cliente> buscarCliente (Cliente cliente) throws DaoException;
    public List<Cliente> buscarTodosClientes() throws DaoException;
    public void removerCliente(Cliente cliente) throws DaoException;
}