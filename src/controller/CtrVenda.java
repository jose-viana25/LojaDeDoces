package controller;

import java.util.List;

import dao.DaoVenda;
import dao.IDaoVenda;
import entity.Venda;

public class CtrVenda {

	IDaoVenda daoVenda = new DaoVenda();

	public void cadastrarVenda(Venda venda) {
		daoVenda.criarVenda(venda);
	}

	public void mudarVenda(Venda vendaSelecionado,
			Venda venda) {
		
		daoVenda.alterarVenda(vendaSelecionado,
				venda);
		
	}
	
	public List<Venda> pesquisarVenda(Venda venda) {

		return daoVenda.buscarVenda(venda);
	}

	public List<Venda> pesquisarTodosVenda() {

		return daoVenda.buscarTodosVenda();
	}
	
	public void apagarVenda(Venda venda) {
		
		daoVenda.removerVenda(venda);
		
	}

}
