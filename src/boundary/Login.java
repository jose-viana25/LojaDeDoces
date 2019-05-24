package boundary;

import javax.swing.JOptionPane;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login extends Application {

	private AnchorPane pane;
	private TextField txLogin;
	private PasswordField txSenha;
	private Button btnEntrar, btnSair;
	private static Stage stage;
	private Label lblSenha;
	private Label lblLogin;

	public void start(Stage stage) throws Exception {
		iniComponentes();
		iniButton();
		Scene scene = new Scene(pane);
		
		lblLogin.setLayoutX(((pane.getWidth()-lblLogin.getWidth())/2)+250);
		lblLogin.setLayoutY(50);
		txLogin.setLayoutX(((pane.getWidth() - txLogin.getWidth()) / 2)+200);
		txLogin.setLayoutY(100);
		lblSenha.setLayoutX(((pane.getWidth() - txLogin.getWidth()) / 2)+250);
		lblSenha.setLayoutY(150);
		txSenha.setLayoutX(((pane.getWidth() - txLogin.getWidth()) / 2)+200);
		txSenha.setLayoutY(200);
		btnEntrar.setLayoutX(((pane.getWidth() - txLogin.getWidth()) / 2)+250);
		btnEntrar.setLayoutY(250);
		btnSair.setLayoutX(((pane.getWidth() - txLogin.getWidth()) / 2)+260);
		btnSair.setLayoutY(300);
		
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
		stage.setTitle("Login - Sweet Dreams");
		
	}

	public static Stage getStage() {
		return stage;
	}

	private void iniComponentes() {
		pane = new AnchorPane();
		
		txLogin = new TextField();
		txSenha = new PasswordField();
		pane.setPrefSize(600,350);
		pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, red 0%, Indigo 100%);");
		txLogin.setPromptText("Digite seu login");
		txSenha.setPromptText("Digite sua senha..");
		btnEntrar = new Button("Entrar");
		btnSair = new Button("Sair");
		lblLogin = new Label("Login :");
		lblSenha = new Label("Senha :");
		pane.getChildren().addAll(txLogin, txSenha, btnEntrar, btnSair,lblLogin,lblSenha);

	}

	private void iniButton() {
		btnSair.setOnAction((event) -> {

			fecharAplicacao();
		});
		btnEntrar.setOnAction((event) -> {
			logar();

		});

	}

	private void logar() {
		if (txLogin.getText().equals("admin") && txSenha.getText().equals("admin")) {

		} else {
			JOptionPane.showMessageDialog(null, "Login e/ou Senha Inválida", "Erro", JOptionPane.ERROR_MESSAGE);
			
		}

	}

	private void fecharAplicacao() {
		System.exit(0);
	}

	public static void main(String[] args) {
		launch(args);
	}

}