package dao;

import java.util.List;

import entity.ItensPedido;

public interface IDaoItensPedido {
	
	public void criarItensPedido(ItensPedido itensPedido) throws DaoException;
	
	public void alterarItensPedido(ItensPedido itensPedidoSelecionado,ItensPedido itensPedido) throws DaoException;
	
	public List<ItensPedido> buscarItensPedido(ItensPedido itensPedido) throws DaoException;
	
	public List<ItensPedido> buscarTodosItensPedido() throws DaoException;
	
	public void removerItensPedido(ItensPedido itensPedido) throws DaoException;
	
}
