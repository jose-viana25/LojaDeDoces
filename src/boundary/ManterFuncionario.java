package boundary;

import java.util.List;

import controller.ControlException;
import controller.CtrFuncionario;
import entity.Funcionario;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ManterFuncionario /*extends Application*/ {

	private CtrFuncionario ctrFuncionario = new CtrFuncionario();

	private TextField txtfNome;

	private TextField txtfCpf;
	
	private TextField txtfEmail;
	
	private TextField txtfTelefone;
	
	private PasswordField passfSenha;

	private Button btnLimpar;

	private Button btnCadastrar;

	private Button btnPesquisar;

	private Button btnAlterar;

	private Button btnRemover;

	private TableView<Funcionario> tableResultados;

	/*public static void main(String[] args) {

		launch(args);

	}*/

	//@Override
	//public void start(Stage primaryStage) throws Exception {
	public Node criarManterFuncionario() {
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

		return gridRoot;
		/*primaryStage.setTitle("Cadastrar Funcionário");
		primaryStage.setScene(new Scene(gridRoot));
		primaryStage.show();*/

	}

	private void definirAcaoTabela() {
		tableResultados.getSelectionModel().selectedItemProperty().addListener(
				(event)->{
					
					Funcionario funcionario = 
							tableResultados.getSelectionModel().getSelectedItem();
					
					if (funcionario != null) {
						txtfCpf.setText(funcionario.getCpf());
						txtfNome.setText(funcionario.getNome());
						txtfEmail.setText(funcionario.getEmail());
						txtfTelefone.setText(funcionario.getTelefone());
					}
					
					
				});
	}

	private GridPane criarGridCadastro() {
		GridPane grid = new GridPane();

		txtfNome = new TextField();
		txtfCpf = new TextField();
		txtfEmail = new TextField();		
		txtfTelefone = new TextField();
		passfSenha = new PasswordField();

		grid.add(new Label("Nome:"), 0, 0);
		grid.add(txtfNome, 1, 0);
		grid.add(new Label("Cpf:"), 0, 1);
		grid.add(txtfCpf, 1, 1);
		grid.add(new Label("Email:"), 0, 2);
		grid.add(txtfEmail, 1, 2);
		grid.add(new Label("Telefone:"), 0, 3);
		grid.add(txtfTelefone, 1, 3);
		grid.add(new Label("Senha:"), 0, 4);
		grid.add(passfSenha, 1, 4);
		
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

			Funcionario funcionario = new Funcionario();

			funcionario.setCpf(txtfCpf.getText());
			funcionario.setNome(txtfNome.getText());
			funcionario.setSenha(passfSenha.getText());
			funcionario.setEmail(txtfEmail.getText());
			funcionario.setTelefone(txtfTelefone.getText());

			try {
				ctrFuncionario.cadastrarFuncionario(funcionario);
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			limparCampos();

			tableResultados.getSelectionModel();

			try {
				atualizarTabela(ctrFuncionario.pesquisarTodosFuncionario());
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		btnPesquisar.setOnAction((event) -> {

			Funcionario funcionario = new Funcionario();

			funcionario.setCpf(txtfCpf.getText());
			funcionario.setNome(txtfNome.getText());
			funcionario.setEmail(txtfEmail.getText());
			funcionario.setTelefone(txtfTelefone.getText());

			try {
				atualizarTabela(ctrFuncionario.pesquisarFuncionario(funcionario));
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		btnAlterar.setOnAction((event) -> {

			Funcionario funcionarioSelecionado = 
					tableResultados.getSelectionModel().getSelectedItem();

			Funcionario funcionario = new Funcionario();

			funcionario.setCpf(txtfCpf.getText());
			funcionario.setNome(txtfNome.getText());
			funcionario.setEmail(txtfEmail.getText());
			funcionario.setTelefone(txtfTelefone.getText());

			try {
				ctrFuncionario.mudarFuncionario(funcionarioSelecionado, funcionario);
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			limparCampos();

			try {
				atualizarTabela(ctrFuncionario.pesquisarTodosFuncionario());
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		btnRemover.setOnAction((event)->{
			
			Funcionario funcionario = new Funcionario();
			
			funcionario.setCpf(txtfCpf.getText());
			funcionario.setNome(txtfNome.getText());
			funcionario.setEmail(txtfEmail.getText());
			funcionario.setTelefone(txtfTelefone.getText());
			
			try {
				ctrFuncionario.apagarFuncionario(funcionario);
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				atualizarTabela(ctrFuncionario.pesquisarTodosFuncionario());
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
	}

	private void atualizarTabela(List<Funcionario> listFuncionario) {
		ObservableList<Funcionario> olItens = FXCollections.observableArrayList(listFuncionario);
		tableResultados.setItems(olItens);
		tableResultados.refresh();
	}

	private void limparCampos() {
		txtfCpf.setText("");
		txtfNome.setText("");
		txtfEmail.setText("");
		txtfTelefone.setText("");
		passfSenha.setText("");
	}

	private void criarTableView() {

		ObservableList<Funcionario> olItens = FXCollections.observableArrayList();

		tableResultados = new TableView<>(olItens);

		TableColumn<Funcionario, String> tcCpf = new TableColumn<>("Cpf");
		tcCpf.setCellValueFactory(new PropertyValueFactory<>("Cpf"));
		tcCpf.setPrefWidth(180);
		
		TableColumn<Funcionario, String> tcNome = new TableColumn<>("Nome");
		tcNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		tcNome.setPrefWidth(180);
		
		TableColumn<Funcionario, String> tcEmail = new TableColumn<>("Email");
		tcEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		tcEmail.setPrefWidth(180);
		
		TableColumn<Funcionario, String> tcTelefone = new TableColumn<>("Telefone");
		tcTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		tcTelefone.setPrefWidth(180);

		tableResultados.getColumns().add(tcCpf);
		tableResultados.getColumns().add(tcNome);
		tableResultados.getColumns().add(tcEmail);
		tableResultados.getColumns().add(tcTelefone);

		tableResultados.autosize();


	}

}
