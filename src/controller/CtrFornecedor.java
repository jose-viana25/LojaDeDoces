package controller;

import java.util.List;

import dao.DaoException;
import dao.DaoFornecedor;
import dao.IDaoFornecedor;
import entity.Fornecedor;

public class CtrFornecedor {

	IDaoFornecedor daoFornecedor = new DaoFornecedor();

	public void cadastrarFornecedor(Fornecedor fornecedor) throws ControlException {
		try {
			daoFornecedor.criarFornecedor(fornecedor);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mudarFornecedor(Fornecedor fornecedorSelecionado,
			Fornecedor fornecedor) throws ControlException {
		
		try {
			daoFornecedor.alterarFornecedor(fornecedorSelecionado,
					fornecedor);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Fornecedor> pesquisarFornecedor(Fornecedor fornecedor) throws ControlException {

		try {
			return daoFornecedor.buscarFornecedor(fornecedor);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Fornecedor> pesquisarTodosFornecedor() throws ControlException {

		try {
			return daoFornecedor.buscarTodosFornecedor();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public void apagarFornecedor(Fornecedor fornecedor) throws ControlException {
		
		try {
			daoFornecedor.removerFornecedor(fornecedor);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
