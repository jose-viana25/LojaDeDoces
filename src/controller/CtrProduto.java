package controller;

import java.util.List;

import dao.DaoProduto;
import dao.IDaoProduto;
import entity.Produto;

public class CtrProduto {

	IDaoProduto daoProduto = new DaoProduto();

	public void cadastrarProduto(Produto produto) {
		daoProduto.criarProduto(produto);
	}

	public void mudarProduto(Produto produtoSelecionado,
			Produto produto) {
		
		daoProduto.alterarProduto(produtoSelecionado,
				produto);
		
	}
	
	public List<Produto> pesquisarProduto(Produto produto) {

		return daoProduto.buscarProduto(produto);
	}

	public List<Produto> pesquisarTodosProduto() {

		return daoProduto.buscarTodosProduto();
	}
	
	public void apagarProduto(Produto produto) {
		
		daoProduto.removerProduto(produto);
		
	}

}
