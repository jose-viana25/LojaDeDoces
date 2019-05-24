package dao;

import java.util.List;

import entity.ItensPedido;

public interface IDaoItensPedido {
	
	public void criarItensPedido(ItensPedido itensPedido);
	
	public void alterarItensPedido(ItensPedido itensPedidoSelecionado,ItensPedido itensPedido);
	
	public List<ItensPedido> buscarItensPedido(ItensPedido itensPedido);
	
	public List<ItensPedido> buscarTodosItensPedido();
	
	public void removerItensPedido(ItensPedido itensPedido);
	
}
