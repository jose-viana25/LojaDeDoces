package boundary;

import java.util.List;

import controller.CtrFornecedor;
import entity.Fornecedor;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ManterFornecedor extends Application {
	
	CtrFornecedor ctrFornecedor = new CtrFornecedor();

	private TextField txtfNome;

	private TextArea txtaDescricao;

	private TextField txtfEndereco;

	private TextField txtfCnpj;
	
	public static void main(String[] args) {
		
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane gridRoot = new GridPane();
		
		GridPane grid = new GridPane();
		
		txtfNome = new TextField();
		
		txtfCnpj = new TextField();
		
		txtfEndereco = new TextField();
		
		txtaDescricao = new TextArea();
		
		HBox hbBotoes = new HBox();
		hbBotoes.setAlignment(Pos.CENTER_RIGHT);
		
		Button btnLimpar = new Button("Limpar");
		
		Button btnCadastrar = new Button("Cadastrar");
				
		Button btnPesquisar = new Button("Pesquisar");
		
		
		TableView<Fornecedor> tableResultados = criarTableView();
		
		btnLimpar.setOnAction((event)->{
			
			limparCampos();
			
		});
		
		btnCadastrar.setOnAction((event)->{
			
			Fornecedor fornecedor = new Fornecedor();
			
			fornecedor.setNome(txtfNome.getText());
			fornecedor.setCnpj(txtfCnpj.getText());
			fornecedor.setEndereco(txtfEndereco.getText());
			fornecedor.setDescricao(txtaDescricao.getText());
			
			ctrFornecedor.cadastrarFornecedor(fornecedor);
			
			limparCampos();
			
			atualizarTabela(tableResultados,
					ctrFornecedor.pesquisarFornecedor());
			
			
		});
		
		btnPesquisar.setOnAction((event)->{
			
			Fornecedor fornecedor = new Fornecedor();
			
			fornecedor.setNome(txtfNome.getText());
			fornecedor.setCnpj(txtfCnpj.getText());
			fornecedor.setEndereco(txtfEndereco.getText());
			fornecedor.setDescricao(txtaDescricao.getText());
			
			atualizarTabela(tableResultados, 
					ctrFornecedor.pesquisarFornecedor(fornecedor));
			
		});
		
		
		grid.add(new Label("Nome:"), 0, 0);
		grid.add(txtfNome, 1, 0);
		grid.add(new Label("Cnpj:"), 0, 1);
		grid.add(txtfCnpj, 1, 1);
		grid.add(new Label("Endereço:"), 0, 2);
		grid.add(txtfEndereco, 1, 2);
		grid.add(new Label("Descrição:"), 0, 3);
		grid.add(txtaDescricao, 1, 3);
		hbBotoes.getChildren().addAll(btnLimpar,btnCadastrar,btnPesquisar);
		
		
		gridRoot.add(grid,0,0);
		gridRoot.add(hbBotoes,0,1);
		gridRoot.add(tableResultados, 0, 2);
		
		primaryStage.setTitle("Cadastrar Tipo de Produto");
		primaryStage.setScene(new Scene(gridRoot));
		primaryStage.show();
		
	}

	private void atualizarTabela(TableView<Fornecedor> tableResultados,
			List<Fornecedor> listFornecedor) {
		ObservableList<Fornecedor> olItens = 
				FXCollections.observableArrayList(listFornecedor);
		tableResultados.setItems(olItens);
		tableResultados.refresh();
	}

	private void limparCampos() {
		txtfNome.setText("");
		txtfCnpj.setText("");
		txtfEndereco.setText("");
		txtaDescricao.setText("");
	}
	
	private TableView<Fornecedor> criarTableView() {

		ObservableList<Fornecedor> olItens = 
				FXCollections.observableArrayList();
		TableView<Fornecedor> tbResultados = 
				new TableView<>(olItens);

		TableColumn<Fornecedor, Integer> tcCodigo = new TableColumn<>("Código");
		tcCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo_fornecedor"));
		tcCodigo.setPrefWidth(180);

		TableColumn<Fornecedor, String> tcNome = new TableColumn<>("Nome");
		tcNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		tcNome.setPrefWidth(180);
		
		TableColumn<Fornecedor, String> tcCnpj = new TableColumn<>("Cnpj");
		tcCnpj.setCellValueFactory(new PropertyValueFactory<>("Cnpj"));
		tcCnpj.setPrefWidth(180);

		TableColumn<Fornecedor, String> tcEndereco = new TableColumn<>("Endereço");
		tcEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		tcEndereco.setPrefWidth(180);
		
		TableColumn<Fornecedor, String> tcDescricao = new TableColumn<>("Descrição");
		tcDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
		tcDescricao.setPrefWidth(180);

		tbResultados.getColumns().add(tcCodigo);
		tbResultados.getColumns().add(tcNome);
		tbResultados.getColumns().add(tcCnpj);
		tbResultados.getColumns().add(tcEndereco);
		tbResultados.getColumns().add(tcDescricao);
		
		tbResultados.autosize();

		return tbResultados;

	}

}
