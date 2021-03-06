package boundary;

import java.util.List;

import controller.ControlException;
import controller.CtrFornecedor;
import entity.Fornecedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ManterFornecedor {

	private CtrFornecedor ctrFornecedor = new CtrFornecedor();

	private TextField txtfNome;

	private TextField txtfCnpj;
	
	private TextField txtfEndereco;
	
	private TextArea txtaDescricao;

	private Button btnLimpar;

	private Button btnCadastrar;

	private Button btnPesquisar;

	private Button btnAlterar;

	private Button btnRemover;

	
	private TableView<Fornecedor> tableResultados;

	private Fornecedor fornecedorSelecionado;

	

	public Node criarManterFornecedor() {
		GridPane gridRoot = new GridPane();

		GridPane grid = criarGridCadastro();

		HBox hbBotoesCadastro = criarHboxBotoesCadastro();

		HBox hbBotoesTabela = criarHboxBotoesTabela();

		criarTableView();
		try {
			atualizarTabela(ctrFornecedor.pesquisarTodosFornecedor());
		} catch (ControlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		definirAcaoTabela();
		
		definirAcaoBotoes();

		gridRoot.add(grid, 0, 0);
		gridRoot.add(hbBotoesCadastro, 0, 1);
		gridRoot.add(tableResultados, 0, 2);
		gridRoot.add(hbBotoesTabela, 0, 3);
		
		return gridRoot;


	}

	private void definirAcaoTabela() {
		tableResultados.getSelectionModel().selectedItemProperty().addListener(
				(event)->{
					
					fornecedorSelecionado = tableResultados.getSelectionModel().getSelectedItem();
					
					if (fornecedorSelecionado != null) {
						txtfCnpj.setText(fornecedorSelecionado.getCnpj());
						txtfNome.setText(fornecedorSelecionado.getNome());
						txtfEndereco.setText(fornecedorSelecionado.getEndereco());
						txtaDescricao.setText(fornecedorSelecionado.getDescricao());
					}
					
					
				});
	}

	private GridPane criarGridCadastro() {
		GridPane grid = new GridPane();

		txtfNome = new TextField();
		txtfCnpj = new TextField();
		txtfEndereco = new TextField();		
		txtaDescricao = new TextArea();

		grid.add(new Label("Nome:"), 0, 0);
		grid.add(txtfNome, 1, 0);
		grid.add(new Label("Cnpj:"), 0, 1);
		grid.add(txtfCnpj, 1, 1);
		grid.add(new Label("Endereço:"), 0, 2);
		grid.add(txtfEndereco, 1, 2);
		grid.add(new Label("Descrição:"), 0, 3);
		grid.add(txtaDescricao, 1, 3);
		
		return grid;
	}

	private HBox criarHboxBotoesTabela() {
		HBox hbBotoesTabela = new HBox();
		hbBotoesTabela.setAlignment(Pos.CENTER_RIGHT);

		btnAlterar = new Button("Alterar");

		btnRemover = new Button("Remover");

		hbBotoesTabela.getChildren().addAll(btnAlterar, btnRemover);

		return hbBotoesTabela;
	}

	private HBox criarHboxBotoesCadastro() {
		HBox hbBotoesCadastro = new HBox();
		hbBotoesCadastro.setAlignment(Pos.CENTER_RIGHT);

		btnLimpar = new Button("Limpar");

		btnCadastrar = new Button("Cadastrar");

		btnPesquisar = new Button("Pesquisar");

		hbBotoesCadastro.getChildren().addAll(btnLimpar, btnCadastrar, btnPesquisar);

		return hbBotoesCadastro;
	}

	private void definirAcaoBotoes() {
		btnLimpar.setOnAction((event) -> {

			limparCampos();

		});

		btnCadastrar.setOnAction((event) -> {

			Fornecedor fornecedor = new Fornecedor();

			fornecedor.setCnpj(txtfCnpj.getText());
			fornecedor.setNome(txtfNome.getText());
			fornecedor.setEndereco(txtfEndereco.getText());
			fornecedor.setDescricao(txtaDescricao.getText());

			try {
				ctrFornecedor.cadastrarFornecedor(fornecedor);
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			limparCampos();

			tableResultados.getSelectionModel();

			try {
				atualizarTabela(ctrFornecedor.pesquisarTodosFornecedor());
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		//Isso
		btnPesquisar.setOnAction((event) -> {

			Fornecedor fornecedor = new Fornecedor();

			fornecedor.setCnpj(txtfCnpj.getText());
			fornecedor.setNome(txtfNome.getText());
			fornecedor.setEndereco(txtfEndereco.getText());
			fornecedor.setDescricao(txtaDescricao.getText());

			try {
				atualizarTabela(ctrFornecedor.pesquisarFornecedor(fornecedor));
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		btnAlterar.setOnAction((event) -> {

			fornecedorSelecionado = 
					tableResultados.getSelectionModel().getSelectedItem();

			Fornecedor fornecedor = new Fornecedor();

			fornecedor.setCnpj(txtfCnpj.getText());
			fornecedor.setNome(txtfNome.getText());
			fornecedor.setEndereco(txtfEndereco.getText());
			fornecedor.setDescricao(txtaDescricao.getText());

			try {
				ctrFornecedor.mudarFornecedor(fornecedorSelecionado, fornecedor);
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			limparCampos();

			try {
				atualizarTabela(ctrFornecedor.pesquisarTodosFornecedor());
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		btnRemover.setOnAction((event)->{
			
			Fornecedor fornecedor = new Fornecedor();
			
			fornecedor.setCnpj(txtfCnpj.getText());
			fornecedor.setNome(txtfNome.getText());
			fornecedor.setEndereco(txtfEndereco.getText());
			fornecedor.setDescricao(txtaDescricao.getText());
			
			try {
				ctrFornecedor.apagarFornecedor(fornecedor);
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				atualizarTabela(ctrFornecedor.pesquisarTodosFornecedor());
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
	}

	
	private void atualizarTabela(List<Fornecedor> listFornecedor) {
		ObservableList<Fornecedor> olItens = FXCollections.observableArrayList(listFornecedor);
		tableResultados.setItems(olItens);
		tableResultados.refresh();
	}

	private void limparCampos() {
		txtfCnpj.setText("");
		txtfNome.setText("");
		txtfEndereco.setText("");
		txtaDescricao.setText("");
	}

	
	private void criarTableView() {

		ObservableList<Fornecedor> olItens = FXCollections.observableArrayList();

		tableResultados = new TableView<>(olItens);

		TableColumn<Fornecedor, String> tcCnpj = new TableColumn<>("Cnpj");
		tcCnpj.setCellValueFactory(new PropertyValueFactory<>("Cnpj"));
		tcCnpj.setPrefWidth(180);
		
		TableColumn<Fornecedor, String> tcNome = new TableColumn<>("Nome");
		tcNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		tcNome.setPrefWidth(180);
		
		TableColumn<Fornecedor, String> tcEndereco = new TableColumn<>("Endereço");
		tcEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		tcEndereco.setPrefWidth(180);
		
		TableColumn<Fornecedor, String> tcDescricao = new TableColumn<>("Descrição");
		tcDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
		tcDescricao.setPrefWidth(180);
		
		tableResultados.getColumns().add(tcCnpj);
		tableResultados.getColumns().add(tcNome);
		tableResultados.getColumns().add(tcEndereco);
		tableResultados.getColumns().add(tcDescricao);

		tableResultados.setPrefHeight(200);

	}

}
