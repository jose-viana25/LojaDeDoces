package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaPrincipal extends Application {

	

	private Tab tabManterTipoDeProduto;
	private Tab tabManterFornecedor;
	private Tab tabManterProduto;
	private Tab tabManterCliente;
	private Tab tabManterFuncionario;
	private Tab tabManterVenda;
	private TabPane tpTelas;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane paneRoot = new Pane();
		
		criarTabPane();
		
		paneRoot.getChildren().add(tpTelas);
		
		primaryStage.setTitle("Loja de Doces");
		primaryStage.setScene(new Scene(paneRoot));
		primaryStage.show();
	}
	
	private void criarTabPane() {
		
		tpTelas = new TabPane();
		
		tabManterTipoDeProduto = new Tab("Manter Tipo de Produto");
		tabManterTipoDeProduto.setContent(
				new ManterTipoDeProduto().criarManterTipoDeProduto());
		tabManterTipoDeProduto.setClosable(false);
		
		tabManterFornecedor = new Tab("Manter Fornecedor");
		tabManterFornecedor.setContent(new ManterFornecedor().criarManterFornecedor());
		tabManterFornecedor.setClosable(false);
		
		tabManterProduto = new Tab("Manter Produto");
		tabManterProduto.setContent(new ManterProduto().criarManterProduto());
		tabManterProduto.setClosable(false);
		
		tabManterCliente = new Tab("Manter Cliente");
		tabManterCliente.setContent(new ManterCliente().criarManterCliente());
		tabManterCliente.setClosable(false);
		
		tabManterFuncionario = new Tab("Manter Funcionario");
		tabManterFuncionario.setContent(new ManterFuncionario().criarManterFuncionario());
		tabManterFuncionario.setClosable(false);
		
		tabManterVenda = new Tab("Manter Venda");
		tabManterVenda.setContent(new ManterVenda().criarManterVenda());
		tabManterVenda.setClosable(false);
		
		tpTelas.setOnMouseClicked((event)->{			
			tabManterTipoDeProduto.setContent(
					new ManterTipoDeProduto().criarManterTipoDeProduto());
			
			tabManterFornecedor.setContent(
					new ManterFornecedor().criarManterFornecedor());
			
			tabManterProduto.setContent(
					new ManterProduto().criarManterProduto());
			
			tabManterCliente.setContent(
					new ManterCliente().criarManterCliente());			

			tabManterFuncionario.setContent(
					new ManterFuncionario().criarManterFuncionario());
			
			tabManterVenda.setContent(
					new ManterVenda().criarManterVenda());
		});
		tpTelas.getTabs().addAll(tabManterTipoDeProduto,
									tabManterFornecedor,
									tabManterProduto,
									tabManterCliente,
									tabManterFuncionario,
									tabManterVenda);
				
	}

}
