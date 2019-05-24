package boundary;

import java.util.ArrayList;
import java.util.List;

import controller.CtrItensPedido;
import controller.CtrVenda;
import entity.ItensPedido;
import entity.Produto;
import entity.Venda;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ManterVenda extends Application {

	private CtrVenda ctrVenda = new CtrVenda();
	// private CtrProduto ctrProduto = new CtrProduto();
	private CtrItensPedido ctrItensPedido = new CtrItensPedido();

	private int codigoDaVendaSelecionada = -1;

	private List<ItensPedido> listItensPedidosParaAdicionar = new ArrayList<>();

	private TextField txtfCpf_funcionario;

	private TextField txtfCpf_cliente;

	private ComboBox<Produto> cmbProdutos;

	private Spinner<Integer> spQuantidade;

	private Button btnLimpar;

	private Button btnAdicionarItem;

	private Button btnRemoverItem;

	private Button btnCadastrar;

	private Button btnPesquisar;

	private Button btnAlterar;

	private Button btnRemover;

	private TableView<Venda> tableResultados;

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane gridRoot = new GridPane();

		GridPane grid = criarGridCadastro();

		HBox hbBotoesCadastro = criarHboxBotoesCadastro();

		HBox hbBotoesTabela = criarHboxBotoesTabela();

		criarTableView();

		definirAcaoTabela();

		definirAcaoBotoes();

		gridRoot.add(grid, 0, 0);
		gridRoot.add(hbBotoesCadastro, 0, 1);
		gridRoot.add(tableResultados, 0, 2);
		gridRoot.add(hbBotoesTabela, 0, 3);

		primaryStage.setTitle("Cadastrar Tipo de Produto");
		primaryStage.setScene(new Scene(gridRoot));
		primaryStage.show();

	}

	private HBox criarHboxBotoesItem() {
		HBox hbBotoesItem = new HBox();
		hbBotoesItem.setAlignment(Pos.CENTER_RIGHT);

		btnAdicionarItem = new Button("+");

		btnRemoverItem = new Button("-");

		hbBotoesItem.getChildren().addAll(btnAdicionarItem, btnRemoverItem);

		return hbBotoesItem;
	}

	private void definirAcaoTabela() {
		tableResultados.getSelectionModel().selectedItemProperty().addListener((event) -> {

			Venda venda = tableResultados.getSelectionModel().getSelectedItem();

			if (venda != null) {
				codigoDaVendaSelecionada = venda.getCodigo();
				txtfCpf_funcionario.setText(venda.getCpf_funcionario());
				txtfCpf_cliente.setText(venda.getCpf_cliente());
			}

		});
	}

	private GridPane criarGridCadastro() {
		GridPane grid = new GridPane();

		txtfCpf_funcionario = new TextField();

		txtfCpf_cliente = new TextField();

		ObservableList<Produto> olProdutos = FXCollections
				.observableArrayList(/* ctrProduto.pesquisarTodosProduto() */);
		cmbProdutos = new ComboBox<>(olProdutos);

		spQuantidade = new Spinner<>();

		HBox hbBotoesItem = criarHboxBotoesItem();

		grid.add(new Label("Cpf do funcionario:"), 0, 0);
		grid.add(txtfCpf_funcionario, 1, 0);
		grid.add(new Label("Cpf do cliente:"), 0, 1);
		grid.add(txtfCpf_cliente, 1, 1);
		grid.add(new Label("Produto:"), 0, 2);
		grid.add(cmbProdutos, 1, 2);
		grid.add(new Label("Quantidade:"), 2, 2);
		grid.add(spQuantidade, 3, 2);
		grid.add(hbBotoesItem, 4, 2);
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

		btnAdicionarItem.setOnAction((event) -> {
			
			ItensPedido itemPedido = new ItensPedido();
			Produto auxProduto =
					cmbProdutos.getSelectionModel().getSelectedItem();
			
			itemPedido.setCodigo_produto(auxProduto.getCodigo());
			itemPedido.setQuantidade(spQuantidade.getValue());
			itemPedido.setValorUnitario(auxProduto.getValor());
			listItensPedidosParaAdicionar.add(itemPedido);

		});

		btnRemoverItem.setOnAction((event) -> {

		});

		btnLimpar.setOnAction((event) -> {

			limparCampos();

		});

		btnCadastrar.setOnAction((event) -> {

			Venda venda = new Venda();

			venda.setCpf_funcionario(txtfCpf_funcionario.getText());
			venda.setCpf_cliente(txtfCpf_cliente.getText());

			ctrVenda.cadastrarVenda(venda);

			limparCampos();

			tableResultados.getSelectionModel();

			atualizarTabela(ctrVenda.pesquisarTodosVenda());

		});

		btnPesquisar.setOnAction((event) -> {

			Venda venda = new Venda();

			venda.setCpf_funcionario(txtfCpf_funcionario.getText());
			venda.setCpf_cliente(txtfCpf_cliente.getText());

			atualizarTabela(ctrVenda.pesquisarVenda(venda));

		});

		btnAlterar.setOnAction((event) -> {

			Venda vendaSelecionado = tableResultados.getSelectionModel().getSelectedItem();

			Venda venda = new Venda();

			venda.setCpf_funcionario(txtfCpf_funcionario.getText());
			venda.setCpf_cliente(txtfCpf_cliente.getText());

			ctrVenda.mudarVenda(vendaSelecionado, venda);

			limparCampos();

			atualizarTabela(ctrVenda.pesquisarTodosVenda());

		});

		btnRemover.setOnAction((event) -> {

			Venda venda = new Venda();

			venda.setCodigo(codigoDaVendaSelecionada);
			venda.setCpf_funcionario(txtfCpf_funcionario.getText());
			venda.setCpf_cliente(txtfCpf_cliente.getText());

			ctrVenda.apagarVenda(venda);

			atualizarTabela(ctrVenda.pesquisarTodosVenda());

		});
	}

	private void atualizarTabela(List<Venda> listVendas) {
		ObservableList<Venda> olItens = FXCollections.observableArrayList(listVendas);
		tableResultados.setItems(olItens);
		tableResultados.refresh();
	}

	private void limparCampos() {
		txtfCpf_funcionario.setText("");
		txtfCpf_cliente.setText("");
	}

	private void criarTableView() {

		ObservableList<Venda> olItens = FXCollections.observableArrayList();

		tableResultados = new TableView<>(olItens);

		TableColumn<Venda, Integer> tcCodigo = new TableColumn<>("Código");
		tcCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		tcCodigo.setPrefWidth(180);

		TableColumn<Venda, String> tcCpf_funcionario = new TableColumn<>("Cpf_funcionario");
		tcCpf_funcionario.setCellValueFactory(new PropertyValueFactory<>("Cpf_funcionario"));
		tcCpf_funcionario.setPrefWidth(180);

		TableColumn<Venda, String> tcCpf_cliente = new TableColumn<>("Cpf do cliente");
		tcCpf_cliente.setCellValueFactory(new PropertyValueFactory<>("Cpf_cliente"));
		tcCpf_cliente.setPrefWidth(180);

		tableResultados.getColumns().add(tcCodigo);
		tableResultados.getColumns().add(tcCpf_funcionario);
		tableResultados.getColumns().add(tcCpf_cliente);

		tableResultados.autosize();

	}

}
