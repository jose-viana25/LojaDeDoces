package boundary;

import java.util.List;

import controller.ControlException;
import controller.CtrCliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import entity.Cliente;



public class ManterCliente {
	CtrCliente ctrCliente = new CtrCliente();
	private AnchorPane pane;

	private TextField txNome;
	private TextField txEmail;
	private TextField txCPF;
	private TextField txTelefone;
	private Label lblNome;
	private Label lblEmail;
	private Label lblTelefone;
	private Label lblCPF;
	private Button btnLimpar;
	private Button btnCadastrar;
	private TableView<Cliente> tabelaCliente;

	private Button btnPesquisar;
	private static Stage stage;

	
	public Node criarManterCliente() {
	
		iniComponentes();
		iniButton();
		iniLayout();
		criarTabela();
		
		return pane;		

	}

	

	private void criarTabela() {
		ObservableList<Cliente> obsCliente = FXCollections.observableArrayList();
		tabelaCliente = new TableView<>(obsCliente);
		
		TableColumn<Cliente, String> tcEmail = new TableColumn<>("Email");
		tcEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		tcEmail.setPrefWidth(180);
		
		TableColumn<Cliente, String> tcNome = new TableColumn<>("Nome");
		tcNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		tcNome.setPrefWidth(180);
		
		TableColumn<Cliente, String> tcCPF = new TableColumn<>("CPF");
		tcCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		tcCPF.setPrefWidth(180);
		
		TableColumn<Cliente, String> tcTelefone = new TableColumn<>("Telefone");
		tcTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		tcTelefone.setPrefWidth(180);

		tabelaCliente.getColumns().add(tcCPF);
		tabelaCliente.getColumns().add(tcNome);
		tabelaCliente.getColumns().add(tcEmail);
		tabelaCliente.getColumns().add(tcTelefone);

		tabelaCliente.autosize();


	}

		
	

	private void iniLayout() {
		lblNome.setLayoutX(((pane.getWidth() - lblNome.getWidth()) / 2) + 20);
		lblNome.setLayoutY(23);
		txNome.setLayoutX(((pane.getWidth() - txNome.getWidth()) / 2) + 70);
		txNome.setLayoutY(15);
		lblCPF.setLayoutX(((pane.getWidth() - lblCPF.getWidth()) / 2) + 300);
		lblCPF.setLayoutY(23);
		txCPF.setLayoutX(((pane.getWidth() - txCPF.getWidth()) / 2) + 350);
		txCPF.setLayoutY(15);
		lblEmail.setLayoutX(((pane.getWidth() - lblEmail.getWidth()) / 2) + 20);
		lblEmail.setLayoutY(53);
		txEmail.setLayoutX(((pane.getWidth() - txEmail.getWidth()) / 2) + 70);
		txEmail.setLayoutY(43);
		lblTelefone.setLayoutX(((pane.getWidth() - lblTelefone.getWidth()) / 2) + 300);
		lblTelefone.setLayoutY(53);
		txTelefone.setLayoutX(((pane.getWidth() - txTelefone.getWidth()) / 2) + 400);
		txTelefone.setLayoutY(43);
		btnCadastrar.setLayoutX(((pane.getWidth() - btnCadastrar.getWidth()) / 2) + 450);
		btnCadastrar.setLayoutY(200);
		btnLimpar.setLayoutX(((pane.getWidth() - btnLimpar.getWidth()) / 2) + 550);
		btnLimpar.setLayoutY(200);
		btnPesquisar.setLayoutX(((pane.getWidth() - btnPesquisar.getWidth()) / 2) + 350);
		btnPesquisar.setLayoutY(200);

	}

	public static Stage getStage() {
		return stage;
	}

	private void iniButton() {
		Cliente cliente= new Cliente();
		btnCadastrar.setOnAction((event) -> {
			cadastrarCliente();
		});
		btnLimpar.setOnAction((event) -> {
			limparCampos();
		});
		
		btnPesquisar.setOnAction((event) -> {

			

			cliente.setCpf(txCPF.getText());
			cliente.setNome(txNome.getText());
			cliente.setEmail(txEmail.getText());
			cliente.setTelefone(txTelefone.getText());
			System.out.println(txCPF);
			try {
				atualizarTabela(ctrCliente.pesquisarClientes());
			} catch (ControlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			limparCampos();

		});
		btnAlterar.setOnAction((event) -> {

			
cliente.setCpf(txCPF.getText());
			cliente.setNome(txNome.getText());
			cliente.setEmail(txEmail.getText());
			cliente.setTelefone(txTelefone.getText());
			System.out.println(txCPF);
			try {
				//ctrFornecedor.mudarFornecedor(fornecedorSelecionado, fornecedor);
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
			cliente.setCpf(txCPF.getText());
			cliente.setNome(txNome.getText());
			cliente.setEmail(txEmail.getText());
			cliente.setTelefone(txTelefone.getText());
			System.out.println(txCPF);
			
			try {
				//ctrFornecedor.apagarFornecedor(fornecedor);
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
	private HBox criarBotoesTabela() {
		HBox hbBotoesTabela = new HBox();
		hbBotoesTabela.setAlignment(Pos.CENTER_RIGHT);

		btnAlterar = new Button("Alterar");

		btnRemover = new Button("Remover");

		hbBotoesTabela.getChildren().addAll(btnAlterar, btnRemover);

		return hbBotoesTabela;
	}

	private void atualizarTabela(List<Cliente> listCliente) {
	/*ObservableList<Cliente> obsCliente = FXCollections.observableArrayList(listCliente);
	tabelaCliente.setItems(obsCliente);
	tabelaCliente.refresh();
		*/for (Cliente cliente : listCliente) {
			System.out.println("CPF: "+cliente.getCpf());
			System.out.println("Nome: "+cliente.getNome());
			System.out.println("EMail: "+cliente.getEmail());
			System.out.println("Telefone: "+cliente.getTelefone());
			
		}
	}
	

	private void limparCampos() {
		txNome.setText("");
		txEmail.setText("");
		txCPF.setText("");
		txTelefone.setText("");
	}

	private void cadastrarCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome(txNome.getText());
		cliente.setEmail(txEmail.getText());
		cliente.setCpf(txCPF.getText());
		cliente.setTelefone(txTelefone.getText());
		try {
			ctrCliente.cadastrarCliente(cliente);
		} catch (ControlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		limparCampos();
		
		

	}

	private void iniComponentes() {
		pane = new AnchorPane();

		txCPF = new TextField();
		txEmail = new TextField();
		txNome = new TextField();
		txTelefone = new TextField();
		pane.setPrefSize(700, 300);
		pane.setStyle(
				"-fx-background-color: linear-gradient(from  0% 0% to 100%  100%, SteelBlue 100%, DarkTurquoise 100%);");
		txCPF.setPromptText("Insira seu CPF");
		txEmail.setPromptText("Insira seu email");
		txTelefone.setPromptText("Insira seu telefone");
		txNome.setPromptText("Insira seu nome");
		btnPesquisar = new Button("Pesquisar");
		btnCadastrar = new Button("Cadastrar");
		btnLimpar = new Button("Limpar");
		lblNome = new Label("Nome :");
		lblEmail = new Label("Email :");
		lblCPF = new Label("CPF : ");
		lblTelefone = new Label("Telefone : ");
		pane.getChildren().addAll(txCPF, txEmail, txTelefone, txNome, btnCadastrar, btnLimpar, lblNome, lblEmail,
				lblTelefone, lblCPF, btnPesquisar);

	}
	

	/*public static void main(String[] args) {
		launch(args);
	}*/

}
