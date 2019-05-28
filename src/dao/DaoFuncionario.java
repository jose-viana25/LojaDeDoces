package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Funcionario;

public class DaoFuncionario implements IDaoFuncionario {

	private List<Funcionario> listFuncionario = new ArrayList<>();

	@Override
	public void criarFuncionario(Funcionario funcionario) {

		listFuncionario.add(funcionario);
		
	}

	@Override
	public List<Funcionario> buscarFuncionario(Funcionario funcionario) {

		List<Funcionario> listResultado = new ArrayList<>();

		for (Funcionario auxFuncionario : listFuncionario) {
			if (temPadrao(funcionario, auxFuncionario)) {
				listResultado.add(auxFuncionario);
			}
		}
		
		return listResultado;

	}

	private boolean temPadrao(Funcionario funcionario, Funcionario auxFuncionario) {
		return auxFuncionario.getCpf().toLowerCase().contains(
				funcionario.getCpf().toLowerCase())
				&& auxFuncionario.getNome().toLowerCase().contains(
				funcionario.getNome().toLowerCase())
				&& auxFuncionario.getEmail().toLowerCase().contains(
						funcionario.getEmail().toLowerCase())
				&& auxFuncionario.getTelefone().toLowerCase().contains(
						funcionario.getTelefone().toLowerCase());
	}
	
	@Override
	public List<Funcionario> buscarTodosFuncionario() {
		
		return listFuncionario;
		
		
	}
	
	@Override
	public void alterarFuncionario(Funcionario funcionarioSelecionado,Funcionario funcionario) {
		
		for (Funcionario auxFuncionario : listFuncionario) {
			
			if (auxFuncionario.getCpf() == 
					funcionarioSelecionado.getCpf()) {
				
				auxFuncionario.setNome(funcionario.getNome());
				auxFuncionario.setSenha(funcionario.getSenha());
				auxFuncionario.setEmail(funcionario.getEmail());
				auxFuncionario.setTelefone(funcionario.getTelefone());
				
			}
			
		}

	}

	@Override
	public void removerFuncionario(Funcionario funcionario) {
		
			for (Funcionario auxFuncionario : listFuncionario) {
				
				if (auxFuncionario.getCpf().equals( 
						funcionario.getCpf())) {
					
					listFuncionario.remove(auxFuncionario);
					return;
				}
				
			}

	}

	

}
