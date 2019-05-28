package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Produto;

public class DaoProduto implements IDaoProduto {

	private List<Produto> listProduto = new ArrayList<>();
	

	@Override
	public void criarProduto(Produto produto) {

		listProduto.add(produto);
		

	}

	@Override
	public List<Produto> buscarProduto(Produto produto) {

		List<Produto> listResultado = new ArrayList<>();

		for (Produto auxProduto : listProduto) {
			if (temPadrao(produto, auxProduto)) {
				listResultado.add(auxProduto);
			}
		}
		
		return listResultado;

	}

	private boolean temPadrao(Produto produto, Produto auxProduto) {
		return auxProduto.getNome().toLowerCase().contains(
				produto.getNome().toLowerCase())
				&& auxProduto.getValidade().equals(
						produto.getValidade())
				&& auxProduto.getValor() == produto.getValor()
				&& auxProduto.getCnpj_fornecedor().equals(
						produto.getCnpj_fornecedor());
	}
	
	@Override
	public List<Produto> buscarTodosProduto() {
		
		return listProduto;
		
		
	}
	
	@Override
	public void alterarProduto(Produto produtoSelecionado,Produto produto) {
		
		for (Produto auxProduto : listProduto) {
			
			if (auxProduto.getNome() == 
					produtoSelecionado.getNome()) {
				
				auxProduto.setNome(produto.getNome());
				auxProduto.setValidade(produto.getValidade());
				auxProduto.setValor(produto.getValor());
				auxProduto.setCnpj_fornecedor(
						produto.getCnpj_fornecedor());
				auxProduto.setNome_tipoDeProduto(
						produto.getNome_tipoDeProduto());
				
			}
			
		}

	}

	@Override
	public void removerProduto(Produto produto) {
		
			for (Produto auxProduto : listProduto) {
				
				if (auxProduto.getNome() == 
						produto.getNome()) {
					
					listProduto.remove(auxProduto);
					return;
				}
				
			}

	}

	

}
