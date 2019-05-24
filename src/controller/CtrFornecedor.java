package controller;

import java.util.List;

import dao.DaoFornecedor;
import dao.IDaoFornecedor;
import entity.Fornecedor;

public class CtrFornecedor {

	IDaoFornecedor daoFornecedor = new DaoFornecedor();

	public void cadastrarFornecedor(Fornecedor fornecedor) {
		daoFornecedor.criarFornecedor(fornecedor);
	}

	public List<Fornecedor> pesquisarFornecedor(Fornecedor fornecedor) {

		return daoFornecedor.buscarFornecedor(fornecedor);
	}

	public List<Fornecedor> pesquisarFornecedor() {

		return daoFornecedor.buscarTodosFornecedor();
	}

}
