package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaCliente extends Application {

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

	private Button btnPesquisar;
	private static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		iniComponentes();
		iniButton();
		iniLayout();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
		stage.setTitle("Login - Sweet Dreams");

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
		btnCadastrar.setOnAction((event) -> {
			cadastrarCliente();
		});
		btnLimpar.setOnAction((event) -> {
			txNome.setText("");
			txEmail.setText("");
			txCPF.setText("");
			txTelefone.setText("");
		});
	}

	private void cadastrarCliente() {
		// TODO Auto-generated method stub

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

	public static void main(String[] args) {
		launch(args);
	}

}
