package controller;

import java.util.List;

import dao.DaoItensPedido;
import dao.IDaoItensPedido;
import entity.ItensPedido;

public class CtrItensPedido {

	IDaoItensPedido daoItensPedido = new DaoItensPedido();

	public void cadastrarItensPedido(ItensPedido itensPedido) {
		daoItensPedido.criarItensPedido(itensPedido);
	}

	public void mudarItensPedido(ItensPedido itensPedidoSelecionado,
			ItensPedido itensPedido) {
		
		daoItensPedido.alterarItensPedido(itensPedidoSelecionado,
				itensPedido);
		
	}
	
	public List<ItensPedido> pesquisarItensPedido(ItensPedido itensPedido) {

		return daoItensPedido.buscarItensPedido(itensPedido);
	}

	public List<ItensPedido> pesquisarTodosItensPedido() {

		return daoItensPedido.buscarTodosItensPedido();
	}
	
	public void apagarItensPedido(ItensPedido itensPedido) {
		
		daoItensPedido.removerItensPedido(itensPedido);
		
	}

}
