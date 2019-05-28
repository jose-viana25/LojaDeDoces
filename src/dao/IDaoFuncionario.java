package dao;

import java.util.List;

import entity.Funcionario;;

public interface IDaoFuncionario {

	public void criarFuncionario(Funcionario funcionario) throws DaoException;

	public void alterarFuncionario(Funcionario funcionarioSelecionado, Funcionario funcionario) throws DaoException;

	public List<Funcionario> buscarFuncionario(Funcionario funcionario) throws DaoException;

	public List<Funcionario> buscarTodosFuncionario() throws DaoException;

	public void removerFuncionario(Funcionario funcionario) throws DaoException;

}
