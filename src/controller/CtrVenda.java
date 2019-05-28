package controller;

import java.util.List;

import dao.DaoException;
import dao.DaoVenda;
import dao.IDaoVenda;
import entity.Venda;

public class CtrVenda {

	IDaoVenda daoVenda = new DaoVenda();

	public void cadastrarVenda(Venda venda) throws ControlException {
		try {
			daoVenda.criarVenda(venda);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mudarVenda(Venda vendaSelecionado,
			Venda venda) throws ControlException {
		
		try {
			daoVenda.alterarVenda(vendaSelecionado,
					venda);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Venda> pesquisarVenda(Venda venda) throws ControlException {

		try {
			return daoVenda.buscarVenda(venda);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Venda> pesquisarTodosVenda() throws ControlException {

		try {
			return daoVenda.buscarTodosVenda();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void apagarVenda(Venda venda) throws ControlException {
		
		try {
			daoVenda.removerVenda(venda);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
