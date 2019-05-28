package dao;

import java.util.List;

import entity.TipoDeProduto;

public interface IDaoTipoDeProduto {
	
	public void criarTipoDeProduto(TipoDeProduto tipoDeProduto) throws DaoException;
	
	public void alterarTipoDeProduto(TipoDeProduto tipoDeProdutoSelecionado,TipoDeProduto tipoDeProduto) throws DaoException;
	
	public List<TipoDeProduto> buscarTipoDeProduto(TipoDeProduto tipoDeProduto) throws DaoException;
	
	public List<TipoDeProduto> buscarTodosTipoDeProduto() throws DaoException;
	
	public void removerTipoDeProduto(TipoDeProduto tipoDeProduto) throws DaoException;
	
}
