package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Venda;

public class DaoVenda implements IDaoVenda {

	private List<Venda> listVenda = new ArrayList<>();
	private int codigo_index = 0;

	@Override
	public void criarVenda(Venda venda) {

		venda.setCodigo(codigo_index);
		listVenda.add(venda);
		codigo_index++;

	}

	@Override
	public List<Venda> buscarVenda(Venda venda) {

		List<Venda> listResultado = new ArrayList<>();

		for (Venda auxVenda : listVenda) {
			if (temPadrao(venda, auxVenda)) {
				listResultado.add(auxVenda);
			}
		}
		
		return listResultado;

	}

	private boolean temPadrao(Venda venda, Venda auxVenda) {
		return auxVenda.getData().equals(venda.getData())
				&& auxVenda.getCpf_cliente().toLowerCase().equals(
						venda.getCpf_cliente())
				&& auxVenda.getCpf_funcionario().toLowerCase().equals(
						venda.getCpf_funcionario());
	}
	
	@Override
	public List<Venda> buscarTodosVenda() {
		
		return listVenda;
		
		
	}
	
	@Override
	public void alterarVenda(Venda vendaSelecionado,Venda venda) {
		
		for (Venda auxVenda : listVenda) {
			
			if (auxVenda.getCodigo() == 
					vendaSelecionado.getCodigo()) {
				
				auxVenda.setData(venda.getData());
				auxVenda.setCpf_cliente(venda.getCpf_cliente());
				auxVenda.setCpf_funcionario(venda.getCpf_funcionario());
				
			}
			
		}

	}

	@Override
	public void removerVenda(Venda venda) {
		
			for (Venda auxVenda : listVenda) {
				
				if (auxVenda.getCodigo() == 
						venda.getCodigo()) {
					
					listVenda.remove(auxVenda);
					return;
				}
				
			}

	}

	

}
