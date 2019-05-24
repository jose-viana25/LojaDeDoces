package dao;

import java.util.List;

import entity.Produto;

public interface IDaoProduto {
	
	public void criarProduto(Produto produto);
	
	public void alterarProduto(Produto produtoSelecionado,Produto produto);
	
	public List<Produto> buscarProduto(Produto produto);
	
	public List<Produto> buscarTodosProduto();
	
	public void removerProduto(Produto produto);
	
}
