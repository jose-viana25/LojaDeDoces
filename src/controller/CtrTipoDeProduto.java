package controller;

import java.util.List;

import dao.DaoTipoDeProduto;
import dao.IDaoTipoDeProduto;
import entity.TipoDeProduto;

public class CtrTipoDeProduto {

	IDaoTipoDeProduto daoTipoDeProduto = new DaoTipoDeProduto();

	public void cadastrarTipoDeProduto(TipoDeProduto tipoDeProduto) {
		daoTipoDeProduto.criarTipoDeProduto(tipoDeProduto);
	}

	public void mudarTipoDeProduto(TipoDeProduto tipoDeProdutoSelecionado,
			TipoDeProduto tipoDeProduto) {
		
		daoTipoDeProduto.alterarTipoDeProduto(tipoDeProdutoSelecionado,
				tipoDeProduto);
		
	}
	
	public List<TipoDeProduto> pesquisarTipoDeProduto(TipoDeProduto tipoDeProduto) {

		return daoTipoDeProduto.buscarTipoDeProduto(tipoDeProduto);
	}

	public List<TipoDeProduto> pesquisarTodosTipoDeProduto() {

		return daoTipoDeProduto.buscarTodosTipoDeProduto();
	}
	
	public void apagarTipoDeProduto(TipoDeProduto tipoDeProduto) {
		
		daoTipoDeProduto.removerTipoDeProduto(tipoDeProduto);
		
	}

}
