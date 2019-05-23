package boundary;


import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login extends Application {
	private static final javafx.event.EventHandler<ActionEvent> ActionEvent = null;
	private AnchorPane pane;
	private TextField txLogin;
	private PasswordField txSenha;
	private Button btnEntrar, btnSair;
	private static Stage stage;

	public void start(Stage stage) throws Exception {
		iniComponentes();
		iniButton();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
		stage.setTitle("Login - Sweet Dreams");
		Login.stage = stage;
		
		txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth())/2);
		txLogin.setLayoutY(50);
		txSenha.setLayoutX((pane.getWidth() - txLogin.getWidth())/2);
		txSenha.setLayoutY(100);
		btnEntrar.setLayoutX((pane.getWidth() - txLogin.getWidth())/2);
		btnEntrar.setLayoutY(150);
		btnSair.setLayoutX((pane.getWidth() - txLogin.getWidth())/2);
		btnSair.setLayoutY(200);
	}

	public static Stage getStage() {
		return stage;
	}

	private void iniComponentes() {
		pane = new AnchorPane();
		pane.setPrefSize(600, 600);
		pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, red 0%, Indigo 100%);");
		txLogin.setPromptText("Digite seu login");
		txSenha.setPromptText("Digite sua senha..");
		btnEntrar = new Button("Entrar");
		btnSair = new Button("Sair");
		pane.getChildren().addAll(txLogin, txSenha, btnEntrar, btnSair);

	}

	private void iniButton() {
		btnSair.setOnAction((event)->{
			
			fecharAplicacao();
		});
		btnEntrar.setOnAction((event)->{
			logar();

			}

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
