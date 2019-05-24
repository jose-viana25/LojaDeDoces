package dao;

import java.util.List;

import entity.TipoDeProduto;

public interface IDaoTipoDeProduto {
	
	public void criarTipoDeProduto(TipoDeProduto tipoDeProduto);
	
	public void alterarTipoDeProduto(TipoDeProduto tipoDeProdutoSelecionado,TipoDeProduto tipoDeProduto);
	
	public List<TipoDeProduto> buscarTipoDeProduto(TipoDeProduto tipoDeProduto);
	
	public List<TipoDeProduto> buscarTodosTipoDeProduto();
	
	public void removerTipoDeProduto(TipoDeProduto tipoDeProduto);
	
}
