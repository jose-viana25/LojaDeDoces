package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Fornecedor;

public class DaoFornecedor implements IDaoFornecedor {

	private List<Fornecedor> listFornecedor = new ArrayList<>();

	@Override
	public void criarFornecedor(Fornecedor fornecedor) {

		listFornecedor.add(fornecedor);
		
	}

	@Override
	public List<Fornecedor> buscarFornecedor(Fornecedor fornecedor) {

		List<Fornecedor> listResultado = new ArrayList<>();

		for (Fornecedor auxFornecedor : listFornecedor) {
			if (temPadrao(fornecedor, auxFornecedor)) {
				listResultado.add(auxFornecedor);
			}
		}
		
		return listResultado;

	}

	private boolean temPadrao(Fornecedor fornecedor, Fornecedor auxFornecedor) {
		return auxFornecedor.getCnpj().toLowerCase().contains(
				fornecedor.getCnpj().toLowerCase())
				&& auxFornecedor.getNome().toLowerCase().contains(
				fornecedor.getNome().toLowerCase())
				&& auxFornecedor.getEndereco().toLowerCase().contains(
						fornecedor.getEndereco().toLowerCase())
				&& auxFornecedor.getDescricao().toLowerCase().contains(
						fornecedor.getDescricao().toLowerCase());
	}
	
	@Override
	public List<Fornecedor> buscarTodosFornecedor() {
		
		return listFornecedor;
		
		
	}
	
	@Override
	public void alterarFornecedor(Fornecedor fornecedorSelecionado,Fornecedor fornecedor) {
		
		for (Fornecedor auxFornecedor : listFornecedor) {
			
			if (auxFornecedor.getCnpj() == 
					fornecedorSelecionado.getCnpj()) {
				
				auxFornecedor.setNome(fornecedor.getNome());
				auxFornecedor.setEndereco(fornecedor.getEndereco());
				auxFornecedor.setDescricao(fornecedor.getDescricao());
				
			}
			
		}

	}

	@Override
	public void removerFornecedor(Fornecedor fornecedor) {
		
			for (Fornecedor auxFornecedor : listFornecedor) {
				
				if (auxFornecedor.getCnpj() == 
						fornecedor.getCnpj()) {
					
					listFornecedor.remove(auxFornecedor);
					return;
				}
				
			}

	}

	

}
