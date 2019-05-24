package entity;

import java.util.Date;
import java.util.List;

public class Venda {
	
	private int codigo;
	private Date data;
	private String cpf_funcionario;
	private String cpf_cliente;
	private List<ItensPedido> itensPedido;
	
	public List<ItensPedido> getItensPedido() {
		return itensPedido;
	}
	public void setItensPedido(List<ItensPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getCpf_funcionario() {
		return cpf_funcionario;
	}
	public void setCpf_funcionario(String cpf_funcionario) {
		this.cpf_funcionario = cpf_funcionario;
	}
	public String getCpf_cliente() {
		return cpf_cliente;
	}
	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}
	
	

}
