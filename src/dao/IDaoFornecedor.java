package dao;

import java.util.List;

import entity.Fornecedor;;

public interface IDaoFornecedor {
	
	public void criarFornecedor(Fornecedor fornecedor) throws DaoException;
	
	public void alterarFornecedor(Fornecedor fornecedorSelecionado,Fornecedor fornecedor) throws DaoException;
	
	public List<Fornecedor> buscarFornecedor(Fornecedor fornecedor) throws DaoException;
	
	public List<Fornecedor> buscarTodosFornecedor() throws DaoException;
	
	public void removerFornecedor(Fornecedor fornecedor) throws DaoException;
	
}
