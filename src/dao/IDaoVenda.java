package dao;

import java.util.List;

import entity.Venda;

public interface IDaoVenda {
	
	public void criarVenda(Venda venda) throws DaoException;
	
	public void alterarVenda(Venda vendaSelecionado,Venda venda) throws DaoException;
	
	public List<Venda> buscarVenda(Venda venda) throws DaoException;
	
	public List<Venda> buscarTodosVenda() throws DaoException;
	
	public void removerVenda(Venda venda) throws DaoException;
	
}
