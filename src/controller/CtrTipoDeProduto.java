package controller;

import java.util.List;

import dao.DaoException;
import dao.DaoTipoDeProduto;
import dao.IDaoTipoDeProduto;
import entity.TipoDeProduto;

public class CtrTipoDeProduto {

	IDaoTipoDeProduto daoTipoDeProduto = new DaoTipoDeProduto();

	public void cadastrarTipoDeProduto(TipoDeProduto tipoDeProduto) throws ControlException {
		try {
			daoTipoDeProduto.criarTipoDeProduto(tipoDeProduto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mudarTipoDeProduto(TipoDeProduto tipoDeProdutoSelecionado,
			TipoDeProduto tipoDeProduto) throws ControlException {
		
		try {
			daoTipoDeProduto.alterarTipoDeProduto(tipoDeProdutoSelecionado,
					tipoDeProduto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<TipoDeProduto> pesquisarTipoDeProduto(TipoDeProduto tipoDeProduto) throws ControlException {

		try {
			return daoTipoDeProduto.buscarTipoDeProduto(tipoDeProduto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<TipoDeProduto> pesquisarTodosTipoDeProduto() throws ControlException {

		try {
			return daoTipoDeProduto.buscarTodosTipoDeProduto();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void apagarTipoDeProduto(TipoDeProduto tipoDeProduto) throws ControlException {
		
		try {
			daoTipoDeProduto.removerTipoDeProduto(tipoDeProduto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
