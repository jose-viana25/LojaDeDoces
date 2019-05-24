package dao;

import java.util.ArrayList;
import java.util.List;

import entity.TipoDeProduto;

public class DaoTipoDeProduto implements IDaoTipoDeProduto {

	private List<TipoDeProduto> listTipoDeProduto = new ArrayList<>();
	private int codigo_index = 0;

	@Override
	public void criarTipoDeProduto(TipoDeProduto tipoDeProduto) {

		tipoDeProduto.setCodigo(codigo_index);
		listTipoDeProduto.add(tipoDeProduto);
		codigo_index++;

	}

	@Override
	public List<TipoDeProduto> buscarTipoDeProduto(TipoDeProduto tipoDeProduto) {

		List<TipoDeProduto> listResultado = new ArrayList<>();

		for (TipoDeProduto auxTipoDeProduto : listTipoDeProduto) {
			if (temPadrao(tipoDeProduto, auxTipoDeProduto)) {
				listResultado.add(auxTipoDeProduto);
			}
		}
		
		return listResultado;

	}

	private boolean temPadrao(TipoDeProduto tipoDeProduto, TipoDeProduto auxTipoDeProduto) {
		return auxTipoDeProduto.getNome().toLowerCase().contains(
				tipoDeProduto.getNome().toLowerCase())
				&& auxTipoDeProduto.getDescricao().toLowerCase().contains(
						tipoDeProduto.getDescricao().toLowerCase());
	}
	
	@Override
	public List<TipoDeProduto> buscarTodosTipoDeProduto() {
		
		return listTipoDeProduto;
		
		
	}
	
	@Override
	public void alterarTipoDeProduto(TipoDeProduto tipoDeProdutoSelecionado,TipoDeProduto tipoDeProduto) {
		
		for (TipoDeProduto auxTipoDeProduto : listTipoDeProduto) {
			
			if (auxTipoDeProduto.getCodigo() == 
					tipoDeProdutoSelecionado.getCodigo()) {
				
				auxTipoDeProduto.setNome(tipoDeProduto.getNome());
				auxTipoDeProduto.setDescricao(tipoDeProduto.getDescricao());
				
			}
			
		}

	}

	@Override
	public void removerTipoDeProduto(TipoDeProduto tipoDeProduto) {
		// TODO Auto-generated method stub

	}

	

}
