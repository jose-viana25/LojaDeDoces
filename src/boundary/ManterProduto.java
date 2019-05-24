package boundary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import controller.CtrFornecedor;
import controller.CtrProduto;
import controller.CtrTipoDeProduto;
import entity.Fornecedor;
import entity.Produto;
import entity.TipoDeProduto;
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

public class ManterProduto extends Application {

	private int codigoDoProdutoSelecionado = -1;

	private CtrProduto ctrProduto = new CtrProduto();

	private CtrFornecedor ctrFornecedor = new CtrFornecedor();

	private CtrTipoDeProduto ctrTipoDeProduto = new CtrTipoDeProduto();

	private TextField txtfNome;

	private Spinner<Integer> spQuantidadeEmEstoque;

	private TextField txtfValor;
	
	private TextField txtfValidade;

	private ComboBox<Fornecedor> cmbFornecedores;

	private ComboBox<TipoDeProduto> cmbTiposDeProdutos;

	private Button btnLimpar;

	private Button btnCadastrar;

	private Button btnPesquisar;

	private Button btnAlterar;

	private Button btnRemover;

	private TableView<Produto> tableResultados;

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

	private void definirAcaoTabela() {
		tableResultados.getSelectionModel().selectedItemProperty().addListener((event) -> {

			Produto produto = tableResultados.getSelectionModel().getSelectedItem();

			if (produto != null) {
				codigoDoProdutoSelecionado = produto.getCodigo();
				txtfNome.setText(produto.getNome());
				txtfValidade.setText(converterDataParaTexto(
						produto.getValidade()));
				spQuantidadeEmEstoque.getValueFactory().setValue(
						produto.getQuantidadeEmEstoque());
				
				TipoDeProduto auxTipoDeProduto = new TipoDeProduto();
				auxTipoDeProduto.setCodigo(produto.getCodigo_tipo());
				cmbTiposDeProdutos.getSelectionModel().select(
						ctrTipoDeProduto.pesquisarTipoDeProduto(
								auxTipoDeProduto).get(0));
				
				Fornecedor auxFornecedor = new Fornecedor();
				auxFornecedor.setCnpj(produto.getCnpj_fornecedor());
				cmbFornecedores.getSelectionModel().select(
						ctrFornecedor.pesquisarFornecedor(
								auxFornecedor).get(0));
			}

		});
	}

	private String converterDataParaTexto(Date data) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}

	private Date converterTextoParaData(String data) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date novaData = null; 
		try {
			novaData = sdf.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return novaData;
	}

	private GridPane criarGridCadastro() {
		GridPane grid = new GridPane();

		txtfNome = new TextField();
		spQuantidadeEmEstoque = new Spinner<>();
		txtfValidade = new TextField();
		txtfValor = new TextField();
		
		//converter tipo de produto para String
		ObservableList<TipoDeProduto> olTiposDeProdutos = FXCollections
				.observableArrayList(ctrTipoDeProduto.pesquisarTodosTipoDeProduto());
		cmbTiposDeProdutos = new ComboBox<>(olTiposDeProdutos);

		//converter fornecedor para String
		ObservableList<Fornecedor> olFornecedores = FXCollections
				.observableArrayList(ctrFornecedor.pesquisarTodosFornecedor());
		cmbFornecedores = new ComboBox<>(olFornecedores);

		grid.add(new Label("Nome:"), 0, 0);
		grid.add(txtfNome, 1, 0);
		grid.add(new Label("Quantidade:"), 0, 1);
		grid.add(spQuantidadeEmEstoque, 1, 1);
		grid.add(new Label("Valor:"), 0, 2);
		grid.add(txtfValor, 1, 2);
		grid.add(new Label("Validade"), 0, 3);
		grid.add(txtfValidade, 1, 3);
		grid.add(new Label("Tipo de produto:"), 0, 4);
		grid.add(cmbTiposDeProdutos, 1, 4);
		grid.add(new Label("Fornecedor:"), 0, 5);
		grid.add(cmbFornecedores, 1, 5);
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

			Produto produto = new Produto();

			produto.setNome(txtfNome.getText());
			produto.setQuantidadeEmEstoque(spQuantidadeEmEstoque.getValue());
			produto.setValor(Double.parseDouble(txtfValor.getText()));
			produto.setValidade(converterTextoParaData(txtfValidade.getText()));
			produto.setCnpj_fornecedor(
					cmbFornecedores.getSelectionModel().getSelectedItem().getCnpj());
			produto.setCodigo_tipo(
					cmbTiposDeProdutos.getSelectionModel().getSelectedItem().getCodigo());
			
			ctrProduto.cadastrarProduto(produto);

			limparCampos();

			tableResultados.getSelectionModel();

			atualizarTabela(ctrProduto.pesquisarTodosProduto());

		});

		btnPesquisar.setOnAction((event) -> {

			Produto produto = new Produto();

			produto.setNome(txtfNome.getText());
			produto.setQuantidadeEmEstoque(spQuantidadeEmEstoque.getValue());
			produto.setValor(Double.parseDouble(txtfValor.getText()));
			produto.setValidade(converterTextoParaData(txtfValidade.getText()));
			produto.setCnpj_fornecedor(
					cmbFornecedores.getSelectionModel().getSelectedItem().getCnpj());
			produto.setCodigo_tipo(
					cmbTiposDeProdutos.getSelectionModel().getSelectedItem().getCodigo());

			atualizarTabela(ctrProduto.pesquisarProduto(produto));

		});

		btnAlterar.setOnAction((event) -> {

			Produto produtoSelecionado = tableResultados.getSelectionModel().getSelectedItem();

			Produto produto = new Produto();

			produto.setNome(txtfNome.getText());
			produto.setQuantidadeEmEstoque(spQuantidadeEmEstoque.getValue());
			produto.setValor(Double.parseDouble(txtfValor.getText()));
			produto.setValidade(converterTextoParaData(txtfValidade.getText()));
			produto.setCnpj_fornecedor(
					cmbFornecedores.getSelectionModel().getSelectedItem().getCnpj());
			produto.setCodigo_tipo(
					cmbTiposDeProdutos.getSelectionModel().getSelectedItem().getCodigo());

			ctrProduto.mudarProduto(produtoSelecionado, produto);

			limparCampos();

			atualizarTabela(ctrProduto.pesquisarTodosProduto());

		});

		btnRemover.setOnAction((event) -> {

			Produto produto = new Produto();

			produto.setCodigo(codigoDoProdutoSelecionado);
			produto.setNome(txtfNome.getText());
			produto.setQuantidadeEmEstoque(spQuantidadeEmEstoque.getValue());
			produto.setValor(Double.parseDouble(txtfValor.getText()));
			produto.setValidade(converterTextoParaData(txtfValidade.getText()));
			produto.setCnpj_fornecedor(
					cmbFornecedores.getSelectionModel().getSelectedItem().getCnpj());
			produto.setCodigo_tipo(
					cmbTiposDeProdutos.getSelectionModel().getSelectedItem().getCodigo());

			ctrProduto.apagarProduto(produto);

			atualizarTabela(ctrProduto.pesquisarTodosProduto());

		});
	}

	private void atualizarTabela(List<Produto> listProdutos) {
		ObservableList<Produto> olItens = FXCollections.observableArrayList(listProdutos);
		tableResultados.setItems(olItens);
		tableResultados.refresh();
	}

	private void limparCampos() {
		txtfNome.setText("");
		txtfValidade.setText("");
	}

	private void criarTableView() {

		ObservableList<Produto> olItens = FXCollections.observableArrayList();

		tableResultados = new TableView<>(olItens);

		TableColumn<Produto, Integer> tcCodigo = new TableColumn<>("Código");
		tcCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		tcCodigo.setPrefWidth(180);

		TableColumn<Produto, String> tcNome = new TableColumn<>("Nome");
		tcNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		tcNome.setPrefWidth(180);

		TableColumn<Produto, Date> tcValidade = new TableColumn<>("Validade");
		tcValidade.setCellValueFactory(new PropertyValueFactory<>("Validade"));
		tcValidade.setPrefWidth(180);
		
		TableColumn<Produto, Date> tcValor = new TableColumn<>("Valor");
		tcValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
		tcValor.setPrefWidth(180);
		
		TableColumn<Produto, Date> tcQuantidadeEmEstoque = 
				new TableColumn<>("Quantidade:");
		tcQuantidadeEmEstoque.setCellValueFactory(
				new PropertyValueFactory<>("QuantidadeEmEstoque"));
		tcQuantidadeEmEstoque.setPrefWidth(180);
		
		

		tableResultados.getColumns().add(tcCodigo);
		tableResultados.getColumns().add(tcNome);
		tableResultados.getColumns().add(tcValor);
		tableResultados.getColumns().add(tcValidade);
		tableResultados.getColumns().add(tcQuantidadeEmEstoque);

		tableResultados.autosize();

	}

}
