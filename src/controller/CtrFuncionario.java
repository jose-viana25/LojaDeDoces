package controller;

import java.util.List;

import dao.DaoException;
import dao.DaoFuncionario;
import dao.IDaoFuncionario;
import entity.Funcionario;

public class CtrFuncionario {

	IDaoFuncionario daoFuncionario = new DaoFuncionario();

	public void cadastrarFuncionario(Funcionario funcionario) throws ControlException {
		try {
			daoFuncionario.criarFuncionario(funcionario);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mudarFuncionario(Funcionario funcionarioSelecionado,
			Funcionario funcionario) throws ControlException {
		
		try {
			daoFuncionario.alterarFuncionario(funcionarioSelecionado,
					funcionario);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Funcionario> pesquisarFuncionario(Funcionario funcionario) throws ControlException {

		try {
			return daoFuncionario.buscarFuncionario(funcionario);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public List<Funcionario> pesquisarTodosFuncionario() throws ControlException {

		try {
			return daoFuncionario.buscarTodosFuncionario();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public void apagarFuncionario(Funcionario funcionario) throws ControlException {
		
		try {
			daoFuncionario.removerFuncionario(funcionario);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
