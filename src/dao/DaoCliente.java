package dao;

import java.util.ArrayList;
import java.util.List;
import entity.Cliente;

public class DaoCliente implements IDaoCliente{
    private List<Cliente> listCliente = new ArrayList<>();

    @Override
    public void criarCliente(Cliente cliente){
        cliente.setCPF(String.valueOf(listCliente.size()));
        listCliente.add(cliente);
    }
    @Override
    public List<Cliente> buscarCliente(Cliente cliente){
        List<Cliente> listResultado = new ArrayList<>();

        for(Cliente auxCliente : listCliente){
            if(temPadrao(cliente,auxCliente)){
                listResultado.add(auxCliente);
            }
        }
        return listCliente;
    }
    private boolean temPadrao(Cliente cliente, Cliente auxCliente){
        return auxCliente.getNome().toLowerCase().contains(cliente.getNome().toLowerCase())
        && auxCliente.getCPF().toLowerCase().contains(cliente.getCPF().toLowerCase())
        && auxCliente.getEmail().toLowerCase().contains(cliente.getEmail().toLowerCase())
        && auxCliente.getTelefone().toLowerCase().contains(cliente.getTelefone().toLowerCase());

    }

    @Override
    public void removerCliente(Cliente cliente){

    }
      @Override
	public List<Cliente> buscarTodosClientes() {
		
		return listCliente;
		
		
	}



}
