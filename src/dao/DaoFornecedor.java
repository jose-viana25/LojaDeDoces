package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Fornecedor;

public class DaoFornecedor implements IDaoFornecedor {

	List<Fornecedor> listFornecedor = new ArrayList<>();

	@Override
	public void criarFornecedor(Fornecedor fornecedor) {

		fornecedor.setCodigo_fornecedor(listFornecedor.size());
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

	private boolean temPadrao(Fornecedor fornecedor, 
			Fornecedor auxFornecedor) {
		
		return auxFornecedor.getNome().toLowerCase().contains(
				fornecedor.getNome().toLowerCase())
				&& auxFornecedor.getCnpj().toLowerCase().contains(
						fornecedor.getCnpj().toLowerCase())
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
	public void alterarFornecedor(Fornecedor fornecedor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removerFornecedor(Fornecedor fornecedor) {
		// TODO Auto-generated method stub

	}

	

}
