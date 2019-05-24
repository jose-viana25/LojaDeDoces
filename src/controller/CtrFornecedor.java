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

	public void mudarFornecedor(Fornecedor fornecedorSelecionado,
			Fornecedor fornecedor) {
		
		daoFornecedor.alterarFornecedor(fornecedorSelecionado,
				fornecedor);
		
	}
	
	public List<Fornecedor> pesquisarFornecedor(Fornecedor fornecedor) {

		return daoFornecedor.buscarFornecedor(fornecedor);
	}

	public List<Fornecedor> pesquisarTodosFornecedor() {

		return daoFornecedor.buscarTodosFornecedor();
	}
	
	public void apagarFornecedor(Fornecedor fornecedor) {
		
		daoFornecedor.removerFornecedor(fornecedor);
		
	}

}
