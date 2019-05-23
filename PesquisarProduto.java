package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PesquisarProduto extends Application {

	//main é o metodo principal
	public static void main(String[] args) {
		//launch é o método usado para iniciar o método start com os argumentos de main
		launch(args);
	}

	/*@Override serve para avisar que o método será sobreescrito
	  Sobrescrita é quando a gente pega um método e escreve um novo código pra ele
	  Por exemplo:
	  public String pesquisarProduto(){
		System.out.println("pesquisando alguma coisa...");
	  }
	  
	  Sobrescrita
	  
	  @Override
	  public String pesquisarProduto(){
		System.out.println("pesquisando produtos...");
	  }
	*/
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane produto = new GridPane();
		
		Scene pesquisa = new Scene(produto);
		
		Label lblNome = new Label("Nome");
		TextField nome = new TextField();
		
		Label lblCodigo = new Label("Código");
		TextField codigo = new TextField();
		
		Button pesquisar = new Button("PESQUISAR");
		
		pesquisar.setOnAction((event)->
		{
			// Listar Produtos.
			
			
		});
		
		produto.add(nome, 1, 0);
		produto.add(codigo, 4, 0);
		produto.add(lblNome , 0, 0);
		produto.add(lblCodigo, 3, 0);
		produto.add(pesquisar, 2, 3);
		
		primaryStage.setTitle("Pesquisar Produto");
		primaryStage.setScene(pesquisa);
		primaryStage.show();
		
	}

}
