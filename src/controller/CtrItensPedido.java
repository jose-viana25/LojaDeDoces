package controller;

import java.util.List;

import dao.DaoException;
import dao.DaoItensPedido;
import dao.IDaoItensPedido;
import entity.ItensPedido;

public class CtrItensPedido {

	IDaoItensPedido daoItensPedido = new DaoItensPedido();

	public void cadastrarItensPedido(ItensPedido itensPedido) throws ControlException {
		try {
			daoItensPedido.criarItensPedido(itensPedido);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mudarItensPedido(ItensPedido itensPedidoSelecionado,
			ItensPedido itensPedido) throws ControlException {
		
		try {
			daoItensPedido.alterarItensPedido(itensPedidoSelecionado,
					itensPedido);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<ItensPedido> pesquisarItensPedido(ItensPedido itensPedido) throws ControlException {

		try {
			return daoItensPedido.buscarItensPedido(itensPedido);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public List<ItensPedido> pesquisarTodosItensPedido() throws ControlException {

		try {
			return daoItensPedido.buscarTodosItensPedido();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void apagarItensPedido(ItensPedido itensPedido) throws ControlException {
		
		try {
			daoItensPedido.removerItensPedido(itensPedido);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
