package boundary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.ControlException;
import controller.CtrFornecedor;
import controller.CtrProduto;
import controller.CtrTipoDeProduto;
import entity.Fornecedor;
import entity.Produto;
import entity.TipoDeProduto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

public class ManterProduto {

	private List<Fornecedor> listFornecedores;
	
	private List<TipoDeProduto> listTipoDeProduto;
	
	private CtrProduto ctrProduto = new CtrProduto();

	private CtrFornecedor ctrFornecedor = new CtrFornecedor();

	private CtrTipoDeProduto ctrTipoDeProduto = new CtrTipoDeProduto();

	private TextField txtfNome;

	private Spinner<Integer> spQuantidadeEmEstoque;

	private TextField txtfValor;

	private TextField txtfValidade;

	private ComboBox<String> cmbFornecedores;

	private ComboBox<String> cmbTiposDeProdutos;

	private Button btnLimpar;

	private Button btnCadastrar;

	private Button btnPesquisar;

	private Button btnAlterar;

	private Button btnRemover;

	private TableView<Produto> tableResultados;

	private Produto produtoSelecionado;

	
	public Node criarManterProduto() {
		
		GridPane gridRoot = new GridPane();

		GridPane grid = criarGridCadastro();

		HBox hbBotoesCadastro = criarHboxBotoesCadastro();

		HBox hbBotoesTabela = criarHboxBotoesTabela();

		criarTableView();
		try {
			atualizarTabela(ctrProduto.pesquisarTodosProduto());
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
		tableResultados.getSelectionModel().selectedItemProperty().addListener((event) -> {

			produtoSelecionado = tableResultados.getSelectionModel().getSelectedItem();

			if (produtoSelecionado != null) {
				txtfNome.setText(produtoSelecionado.getNome());
				txtfValidade.setText(converterDataParaTexto(produtoSelecionado.getValidade()));
				txtfValor.setText(String.valueOf(produtoSelecionado.getValor()));
				spQuantidadeEmEstoque.getValueFactory().setValue(
						produtoSelecionado.getQuantidadeEmEstoque());
				
				cmbTiposDeProdutos.getSelectionModel().select(produtoSelecionado.getNome_tipoDeProduto());

				//Corrigir aqui
				cmbFornecedores.getSelectionModel().select(encontrarNomeFornecedorPorCnpj(
						produtoSelecionado.getCnpj_fornecedor()));
			}

		});
	}


	private String encontrarNomeFornecedorPorCnpj(String cnpj_fornecedor) {
		
		for (Fornecedor fornecedor : listFornecedores) {
			if (fornecedor.getCnpj().equals(cnpj_fornecedor)) {
				return fornecedor.getNome();
			}
		}
		
		return "";
	}

	private String converterDataParaTexto(Date data) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}

	private Date converterTextoParaData(String data) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date novaData = null;
		
		novaData = sdf.parse(data);

		return novaData;
	}

	private GridPane criarGridCadastro() {
		GridPane grid = new GridPane();

		txtfNome = new TextField();
		spQuantidadeEmEstoque = new Spinner<>(0, 100, 0);
		spQuantidadeEmEstoque.setEditable(true);
		txtfValidade = new TextField();
		txtfValor = new TextField();

		try {
			listTipoDeProduto = ctrTipoDeProduto.pesquisarTodosTipoDeProduto();
			listFornecedores = ctrFornecedor.pesquisarTodosFornecedor();
		} catch (ControlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		try {
			listTipoDeProduto = ctrTipoDeProduto.pesquisarTodosTipoDeProduto();
		} catch (ControlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObservableList<String> olTiposDeProdutos = 
				FXCollections.observableArrayList(
						listTipoDeProdutoParaString(listTipoDeProduto));
		cmbTiposDeProdutos = new ComboBox<>(olTiposDeProdutos);
		cmbTiposDeProdutos.getSelectionModel().select(0);

		
		try {
			listFornecedores = ctrFornecedor.pesquisarTodosFornecedor();
		} catch (ControlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ObservableList<String> olFornecedores = FXCollections
				.observableArrayList(
						listFornecedorParaString(listFornecedores));
		cmbFornecedores = new ComboBox<>(olFornecedores);
		cmbFornecedores.getSelectionModel().select(0);

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

	private List<String> listTipoDeProdutoParaString(List<TipoDeProduto> pesquisarTodosTipoDeProduto) {

		List<String> listaTipoDeProduto = new ArrayList<>();

		for (TipoDeProduto tipoDeProduto : pesquisarTodosTipoDeProduto) {
			listaTipoDeProduto.add(tipoDeProduto.getNome());
		}

		return listaTipoDeProduto;
	}

	private List<String> listFornecedorParaString(List<Fornecedor> pesquisarTodosFornecedor) {

		List<String> listaTipoDeProduto = new ArrayList<>();

		for (Fornecedor fornecedor : pesquisarTodosFornecedor) {
			listaTipoDeProduto.add(fornecedor.getNome());
		}

		return listaTipoDeProduto;
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

			produto.setNome(txtfNome.getText().toLowerCase());
			produto.setQuantidadeEmEstoque(spQuantidadeEmEstoque.getValue());
			produto.setValor(Double.parseDouble(txtfValor.getText()));
			try {
				produto.setValidade(converterTextoParaData(txtfValidade.getText()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				produto.setValidade(new Date());
			}
			
			Fornecedor auxFornecedor = listFornecedores.get(
					cmbFornecedores.getSelectionModel().getSelectedIndex());
			
			produto.setCnpj_fornecedor(auxFornecedor.getCnpj());
			
			TipoDeProduto auxTipoDeProduto = listTipoDeProduto.get(
					cmbFornecedores.getSelectionModel().getSelectedIndex());
			
			produto.setNome_tipoDeProduto(auxTipoDeProduto.getNome());

			try {
				ctrProduto.cadastrarProduto(produto);
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			limparCampos();

			try {
				atualizarTabela(ctrProduto.pesquisarTodosProduto());
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		btnPesquisar.setOnAction((event) -> {

			Produto produto = new Produto();

			produto.setNome(txtfNome.getText().toLowerCase());
			/*produto.setQuantidadeEmEstoque(spQuantidadeEmEstoque.getValue());
			try {
				produto.setValor(Double.parseDouble(txtfValor.getText()));
			} catch (NumberFormatException e2) {
				produto.setValor(0);
			}
			try {
				produto.setValidade(converterTextoParaData(txtfValidade.getText()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				System.out.println("Deu ruim na data");
				produto.setValidade(new Date());
			}
			
			Fornecedor auxFornecedor = listFornecedores.get(
					cmbFornecedores.getSelectionModel().getSelectedIndex());
			//remover
			System.out.println("Forncedor:" + auxFornecedor.toString());
			produto.setCnpj_fornecedor(auxFornecedor.getCnpj());
			
			TipoDeProduto auxTipoDeProduto = listTipoDeProduto.get(
					cmbFornecedores.getSelectionModel().getSelectedIndex());
			
			System.out.println("Tipo:" + auxTipoDeProduto.toString());
			produto.setNome_tipoDeProduto(auxTipoDeProduto.getNome());
			System.out.println(produto.toString());*/
			try {
				atualizarTabela(ctrProduto.pesquisarProduto(produto));
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		btnAlterar.setOnAction((event) -> {

			produtoSelecionado = tableResultados.getSelectionModel().getSelectedItem();

			Produto produto = new Produto();

			produto.setNome(txtfNome.getText());
			produto.setQuantidadeEmEstoque(spQuantidadeEmEstoque.getValue());
			produto.setValor(Double.parseDouble(txtfValor.getText()));
			try {
				produto.setValidade(converterTextoParaData(txtfValidade.getText()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				produto.setValidade(new Date());
			}
			
			Fornecedor auxFornecedor = listFornecedores.get(
					cmbFornecedores.getSelectionModel().getSelectedIndex());
			
			produto.setCnpj_fornecedor(auxFornecedor.getCnpj());

			produto.setNome_tipoDeProduto(
					cmbTiposDeProdutos.getSelectionModel().getSelectedItem());
			//Teste
			System.out.println("Teste: "+produto.getNome_tipoDeProduto());
			try {
				ctrProduto.mudarProduto(produtoSelecionado, produto);
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			limparCampos();

			try {
				atualizarTabela(ctrProduto.pesquisarTodosProduto());
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		btnRemover.setOnAction((event) -> {

			Produto produto = new Produto();

			produto.setNome(txtfNome.getText());
			produto.setQuantidadeEmEstoque(spQuantidadeEmEstoque.getValue());
			produto.setValor(Double.parseDouble(txtfValor.getText()));
			try {
				produto.setValidade(converterTextoParaData(txtfValidade.getText()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				produto.setValidade(new Date());
			}
			
			Fornecedor auxFornecedor = listFornecedores.get(
					cmbFornecedores.getSelectionModel().getSelectedIndex());
			
			produto.setCnpj_fornecedor(auxFornecedor.getCnpj());
			
			TipoDeProduto auxTipoDeProduto = listTipoDeProduto.get(
					cmbFornecedores.getSelectionModel().getSelectedIndex());

			produto.setNome_tipoDeProduto(auxTipoDeProduto.getNome());
			try {
				ctrProduto.apagarProduto(produto);
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				atualizarTabela(ctrProduto.pesquisarTodosProduto());
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
	}

	private void atualizarTabela(List<Produto> listProdutos) {
		try {
			listTipoDeProduto = ctrTipoDeProduto.pesquisarTodosTipoDeProduto();
			listFornecedores = ctrFornecedor.pesquisarTodosFornecedor();
		} catch (ControlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObservableList<Produto> olItens = FXCollections.observableArrayList(listProdutos);
		tableResultados.setItems(olItens);
		tableResultados.refresh();
	}

	private void limparCampos() {
		txtfNome.setText("");
		spQuantidadeEmEstoque.getValueFactory().setValue(0);
		txtfValor.setText("");
		txtfValidade.setText("");
		cmbFornecedores.getSelectionModel().select(0);
		cmbTiposDeProdutos.getSelectionModel().select(0);
	}

	private void criarTableView() {

		ObservableList<Produto> olItens = FXCollections.observableArrayList();

		tableResultados = new TableView<>(olItens);

		TableColumn<Produto, String> tcNome = new TableColumn<>("Nome");
		tcNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		tcNome.setPrefWidth(180);

		TableColumn<Produto, Date> tcValidade = new TableColumn<>("Validade");
		tcValidade.setCellValueFactory(new PropertyValueFactory<>("Validade"));
		tcValidade.setPrefWidth(180);
		
		TableColumn<Produto, Date> tcTipoDeProduto = new TableColumn<>("Tipo:");
		tcTipoDeProduto.setCellValueFactory(new PropertyValueFactory<>("nome_tipoDeProduto"));
		tcTipoDeProduto.setPrefWidth(180);
		
		TableColumn<Produto, Date> tcFornecedor = new TableColumn<>("Fornecedor");
		tcFornecedor.setCellValueFactory(new PropertyValueFactory<>("Cnpj_fornecedor"));
		tcFornecedor.setPrefWidth(180);

		TableColumn<Produto, Date> tcValor = new TableColumn<>("Valor");
		tcValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
		tcValor.setPrefWidth(180);

		TableColumn<Produto, Date> tcQuantidadeEmEstoque = new TableColumn<>("Quantidade:");
		tcQuantidadeEmEstoque.setCellValueFactory(new PropertyValueFactory<>("QuantidadeEmEstoque"));
		tcQuantidadeEmEstoque.setPrefWidth(180);

		tableResultados.getColumns().add(tcNome);
		tableResultados.getColumns().add(tcValor);
		tableResultados.getColumns().add(tcValidade);
		tableResultados.getColumns().add(tcTipoDeProduto);
		tableResultados.getColumns().add(tcFornecedor);
		tableResultados.getColumns().add(tcQuantidadeEmEstoque);

		tableResultados.autosize();

	}

}
