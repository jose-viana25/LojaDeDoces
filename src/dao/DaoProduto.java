package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Produto;

public class DaoProduto implements IDaoProduto {

	private List<Produto> listProduto = new ArrayList<>();
	private int codigo_index = 0;

	@Override
	public void criarProduto(Produto produto) {

		produto.setCodigo(codigo_index);
		listProduto.add(produto);
		codigo_index++;

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
						produto.getCnpj_fornecedor())
				&& auxProduto.getCodigo_tipo() == 
				produto.getCodigo_tipo();
	}
	
	@Override
	public List<Produto> buscarTodosProduto() {
		
		return listProduto;
		
		
	}
	
	@Override
	public void alterarProduto(Produto produtoSelecionado,Produto produto) {
		
		for (Produto auxProduto : listProduto) {
			
			if (auxProduto.getCodigo() == 
					produtoSelecionado.getCodigo()) {
				
				auxProduto.setNome(produto.getNome());
				auxProduto.setValidade(produto.getValidade());
				auxProduto.setValor(produto.getValor());
				auxProduto.setCnpj_fornecedor(
						produto.getCnpj_fornecedor());
				auxProduto.setCodigo_tipo(
						produto.getCodigo_tipo());
				
			}
			
		}

	}

	@Override
	public void removerProduto(Produto produto) {
		
			for (Produto auxProduto : listProduto) {
				
				if (auxProduto.getCodigo() == 
						produto.getCodigo()) {
					
					listProduto.remove(auxProduto);
					return;
				}
				
			}

	}

	

}
