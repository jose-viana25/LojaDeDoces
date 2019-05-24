package controller;

import java.util.List;
import dao.DaoCliente;
import dao.IDaoCliente;
import entity.Cliente;

public class CtrlCliente{
    IDaoCliente daoCliente = new DaoCliente();

    public void cadastrarCliente(Cliente cliente){
        daoCliente.criarCliente(cliente);
    }
    public List<Cliente> pesquisarCliente(Cliente cliente){
        return daoCliente.buscarCliente(cliente);
    }
    public List<Cliente> pesquisarCliente(){
        return daoCliente.buscarTodosCliente();
    }
}