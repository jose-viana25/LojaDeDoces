package dao;

import java.util.ArrayList;
import java.util.List;
import entity.Cliente

public class DaoCliente implements IDaoCliente{
    private List<Cliente> listCliente = new ArrayList<>();

    @Override
    public void criarCliente(Cliente cliente){
        cliente.setCPF(listCliente.size());
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
        && auxCliente.getCPF().toLowerCase().contains(cliente.getCPF().toLowerCase().contains())
        && auxCliente.getEmail().toLowerCase().contains(cliente.getEmail().toLowerCase().contains())
        && auxCliente.getTelefone().toLowerCase().contains(cliente.getTelefone().toLowerCase().contains());

    }

    @Override
    public void removerCliente(Cliente cliente){

    }
      @Override
	public List<Cliente> buscarTodosCliente() {
		
		return listCliente;
		
		
	}



}
