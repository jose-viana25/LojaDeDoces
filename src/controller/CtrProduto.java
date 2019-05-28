package controller;

import java.util.List;

import dao.DaoException;
import dao.DaoProduto;
import dao.IDaoProduto;
import entity.Produto;

public class CtrProduto {

	IDaoProduto daoProduto = new DaoProduto();

	public void cadastrarProduto(Produto produto) throws ControlException {
		try {
			daoProduto.criarProduto(produto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mudarProduto(Produto produtoSelecionado,
			Produto produto) throws ControlException {
		
		try {
			daoProduto.alterarProduto(produtoSelecionado,
					produto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Produto> pesquisarProduto(Produto produto) throws ControlException {

		try {
			return daoProduto.buscarProduto(produto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Produto> pesquisarTodosProduto() throws ControlException {

		try {
			return daoProduto.buscarTodosProduto();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void apagarProduto(Produto produto) throws ControlException {
		
		try {
			daoProduto.removerProduto(produto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
