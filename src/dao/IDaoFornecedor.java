package dao;

import java.util.List;

import entity.Fornecedor;;

public interface IDaoFornecedor {
	
	public void criarFornecedor(Fornecedor fornecedor);
	
	public void alterarFornecedor(Fornecedor fornecedorSelecionado,Fornecedor fornecedor);
	
	public List<Fornecedor> buscarFornecedor(Fornecedor fornecedor);
	
	public List<Fornecedor> buscarTodosFornecedor();
	
	public void removerFornecedor(Fornecedor fornecedor);
	
}
