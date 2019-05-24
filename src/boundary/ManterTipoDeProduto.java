package boundary;

import java.util.List;

import controller.CtrTipoDeProduto;
import entity.TipoDeProduto;
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

public class ManterTipoDeProduto extends Application {
	
	CtrTipoDeProduto ctrTipoDeProduto = new CtrTipoDeProduto();

	private TextField txtfNome;

	private TextArea txtaDescricao;

	private Button btnLimpar;

	private Button btnCadastrar;

	private Button btnPesquisar;

	private Button btnAlterar;

	private Button btnRemover;

	private TableView<TipoDeProduto> tableResultados;
	
	public static void main(String[] args) {
		
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane gridRoot = new GridPane();
		
		GridPane grid = new GridPane();
		
		Label lblNome = new Label("Nome:");
		
		txtfNome = new TextField();
		
		txtaDescricao = new TextArea();
		
		HBox hbBotoesCadastro = criarHboxBotoesCadastro();
		
		HBox hbBotoesTabela = criarHboxBotoesTabela();
		
		tableResultados = criarTableView();
		
		definirAcaoBotoes();
		
		grid.add(lblNome, 0, 0);
		grid.add(txtfNome, 1, 0);
		grid.add(new Label("Descrição"), 0, 1);
		grid.add(txtaDescricao, 1, 1);
		
		gridRoot.add(grid,0,0);
		gridRoot.add(hbBotoesCadastro,0,1);
		gridRoot.add(tableResultados, 0, 2);
		gridRoot.add(hbBotoesTabela, 0, 3);
		
		primaryStage.setTitle("Cadastrar Tipo de Produto");
		primaryStage.setScene(new Scene(gridRoot));
		primaryStage.show();
		
	}

	private HBox criarHboxBotoesTabela() {
		HBox hbBotoesTabela = new HBox();
		hbBotoesTabela.setAlignment(Pos.CENTER_RIGHT);
		
		btnAlterar = new Button("Alterar");
		
		btnRemover = new Button("Remover");
		
		hbBotoesTabela.getChildren().addAll(btnAlterar,btnRemover);
		
		return hbBotoesTabela;
	}

	private HBox criarHboxBotoesCadastro() {
		HBox hbBotoesCadastro = new HBox();
		hbBotoesCadastro.setAlignment(Pos.CENTER_RIGHT);
		
		btnLimpar = new Button("Limpar");
		
		btnCadastrar = new Button("Cadastrar");
				
		btnPesquisar = new Button("Pesquisar");
		
		hbBotoesCadastro.getChildren().addAll(btnLimpar,btnCadastrar,btnPesquisar);
		
		return hbBotoesCadastro;
	}

	private void definirAcaoBotoes() {
		btnLimpar.setOnAction((event)->{
			
			limparCampos();
			
		});
		
		btnCadastrar.setOnAction((event)->{
			
			TipoDeProduto tipoDeProduto = new TipoDeProduto();
			
			tipoDeProduto.setNome(txtfNome.getText());
			tipoDeProduto.setDescricao(txtaDescricao.getText());
			
			ctrTipoDeProduto.cadastrarTipoDeProduto(tipoDeProduto);
			
			limparCampos();
			
			tableResultados.getSelectionModel();
			
			atualizarTabela(tableResultados,
					ctrTipoDeProduto.pesquisarTodosTipoDeProduto());
			
			
		});
		
		btnPesquisar.setOnAction((event)->{
			
			TipoDeProduto tipoDeProduto = new TipoDeProduto();
			
			tipoDeProduto.setNome(txtfNome.getText());
			tipoDeProduto.setDescricao(txtaDescricao.getText());
			
			atualizarTabela(tableResultados, 
					ctrTipoDeProduto.pesquisarTipoDeProduto(tipoDeProduto));
			
		});
		
		btnAlterar.setOnAction((event)->{
			
			TipoDeProduto tipoDeProdutoSelecionado = 
					tableResultados.getSelectionModel().getSelectedItem();
			
			TipoDeProduto tipoDeProduto = new TipoDeProduto();			

			tipoDeProduto.setNome(txtfNome.getText());
			tipoDeProduto.setDescricao(txtaDescricao.getText());
			
			ctrTipoDeProduto.mudarTipoDeProduto(tipoDeProdutoSelecionado,
					tipoDeProduto);
			
			limparCampos();
			
			atualizarTabela(tableResultados, 
					ctrTipoDeProduto.pesquisarTodosTipoDeProduto());
			
		});
	}

	private void atualizarTabela(TableView<TipoDeProduto> tableResultados,
			List<TipoDeProduto> listTipoDeProdutos) {
		ObservableList<TipoDeProduto> olItens = 
				FXCollections.observableArrayList(listTipoDeProdutos);
		tableResultados.setItems(olItens);
		tableResultados.refresh();
	}

	private void limparCampos() {
		txtfNome.setText("");
		txtaDescricao.setText("");
	}
	
	private TableView<TipoDeProduto> criarTableView() {

		ObservableList<TipoDeProduto> olItens = 
				FXCollections.observableArrayList();
		
		TableView<TipoDeProduto> tbResultados = 
				new TableView<>(olItens);

		TableColumn<TipoDeProduto, Integer> tcCodigo = new TableColumn<>("Código");
		tcCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		tcCodigo.setPrefWidth(180);

		TableColumn<TipoDeProduto, String> tcNome = new TableColumn<>("Nome");
		tcNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		tcNome.setPrefWidth(180);

		TableColumn<TipoDeProduto, String> tcDescricao = new TableColumn<>("Descrição");
		tcDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
		tcDescricao.setPrefWidth(180);

		tbResultados.getColumns().add(tcCodigo);
		tbResultados.getColumns().add(tcNome);
		tbResultados.getColumns().add(tcDescricao);
		
		tbResultados.autosize();

		return tbResultados;

	}

}
