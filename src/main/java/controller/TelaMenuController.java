package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class TelaMenuController implements Initializable {
	
	

    @FXML
    private Button btnVendas;

    @FXML
    private Button btnProdutos;

    @FXML
    private Button btnRelatorios;

    @FXML
    private Button btnFaturamento;

    @FXML
    private Button btnCadastroCliente;
    
    @FXML
    public HBox conteudo;

    @FXML
    private void cadastrar(ActionEvent event) throws Exception {
    	
    	Parent prime = FXMLLoader.load(getClass().getResource("../view/TelaCadastroDeProduto.fxml"));
    	conteudo.getChildren().clear();
    	conteudo.getChildren().add(prime);
 
   

    }

    @FXML
    public void estocar(ActionEvent event) throws Exception {

    	Parent prime = FXMLLoader.load(getClass().getResource("../view/TelaEstoque.fxml"));
    	conteudo.getChildren().clear();
    	conteudo.getChildren().add(prime);
    }

    @FXML
    void faturamento(ActionEvent event) throws Exception {
    	Parent prime = FXMLLoader.load(getClass().getResource("../view/TelaEstoque.fxml"));
    	conteudo.getChildren().clear();
    	conteudo.getChildren().add(prime);

    }

    @FXML
    void relatorios(ActionEvent event) {

    }

    @FXML
    void vendas(ActionEvent event) throws Exception {
    	
    	Parent prime = FXMLLoader.load(getClass().getResource("../view/TelaVendas.fxml"));
    	conteudo.getChildren().clear();
    	conteudo.getChildren().add(prime);

    }

	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
