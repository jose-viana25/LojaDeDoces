package dao;

import java.util.List;

import entity.Produto;

public interface IDaoProduto {
	
	public void criarProduto(Produto produto) throws DaoException;
	
	public void alterarProduto(Produto produtoSelecionado,Produto produto) throws DaoException;
	
	public List<Produto> buscarProduto(Produto produto) throws DaoException;
	
	public List<Produto> buscarTodosProduto() throws DaoException;
	
	public void removerProduto(Produto produto) throws DaoException;
	
}
