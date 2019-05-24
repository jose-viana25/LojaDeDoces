package dao;
import java.util.List;
import entity.Cliente;

public interface IDaoCliente{
    public void criarCliente(Cliente cliente);
    public List<Cliente> buscarCliente (Cliente cliente);
    public List<Cliente> buscarTodosClientes();
    public void removerCliente(Cliente cliente);
}