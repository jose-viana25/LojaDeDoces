package dao;

import java.util.List;

import entity.Venda;

public interface IDaoVenda {
	
	public void criarVenda(Venda venda);
	
	public void alterarVenda(Venda vendaSelecionado,Venda venda);
	
	public List<Venda> buscarVenda(Venda venda);
	
	public List<Venda> buscarTodosVenda();
	
	public void removerVenda(Venda venda);
	
}
