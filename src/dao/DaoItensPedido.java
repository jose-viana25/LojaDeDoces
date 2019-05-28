package dao;

import java.util.ArrayList;
import java.util.List;

import entity.ItensPedido;

public class DaoItensPedido implements IDaoItensPedido {

	private List<ItensPedido> listItensPedido = new ArrayList<>();

	@Override
	public void criarItensPedido(ItensPedido itensPedido) {

		itensPedido.setCodigo_venda(itensPedido.getCodigo_venda());
		itensPedido.setNome_produto(itensPedido.getNome_produto());
		itensPedido.setQuantidade(itensPedido.getQuantidade());
		itensPedido.setValorUnitario(itensPedido.getValorUnitario());
		listItensPedido.add(itensPedido);
		

	}

	@Override
	public List<ItensPedido> buscarItensPedido(ItensPedido itensPedido) {

		List<ItensPedido> listResultado = new ArrayList<>();

		for (ItensPedido auxItensPedido : listItensPedido) {
			if (temPadrao(itensPedido, auxItensPedido)) {
				listResultado.add(auxItensPedido);
			}
		}
		
		return listResultado;

	}

	private boolean temPadrao(ItensPedido itensPedido, ItensPedido auxItensPedido) {
		return auxItensPedido.getCodigo_venda() == 
					itensPedido.getCodigo_venda()
				&& auxItensPedido.getNome_produto() == 
					itensPedido.getNome_produto()
				&& auxItensPedido.getQuantidade() == 
					itensPedido.getQuantidade()
				&& auxItensPedido.getValorUnitario() == 
					itensPedido.getValorUnitario();
	}
	
	@Override
	public List<ItensPedido> buscarTodosItensPedido() {
		
		return listItensPedido;
		
		
	}
	
	@Override
	public void alterarItensPedido(ItensPedido itensPedidoSelecionado,ItensPedido itensPedido) {
		
		for (ItensPedido auxItensPedido : listItensPedido) {
			
			if (auxItensPedido.getCodigo_venda() == 
					itensPedidoSelecionado.getCodigo_venda()
					&& auxItensPedido.getNome_produto() == 
							itensPedidoSelecionado.getNome_produto()) {
				
				itensPedido.setQuantidade(itensPedido.getQuantidade());
				itensPedido.setValorUnitario(itensPedido.getValorUnitario());
				
			}
			
		}

	}

	@Override
	public void removerItensPedido(ItensPedido itensPedido) {
		
			for (ItensPedido auxItensPedido : listItensPedido) {
				
				if (auxItensPedido.getCodigo_venda() == 
						itensPedido.getCodigo_venda()
						&& auxItensPedido.getNome_produto() == 
								itensPedido.getNome_produto()) {
					
					listItensPedido.remove(auxItensPedido);
					return;
				}
				
			}

	}

	

}
