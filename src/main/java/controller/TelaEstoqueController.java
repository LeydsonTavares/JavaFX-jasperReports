package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TelaEstoqueController implements Initializable {

	private GerenciadorDeVendas gerenciador = GerenciadorDeVendas.getInstance();
	
	

	@FXML
	private Hyperlink hl_NovoProduto;

	@FXML
	private TableView<Produto> tb_Produtos;

    @FXML
    private Hyperlink hl_atualizarEstoque;

    @FXML
    private TextField txt_pesquisaProduto;

 
	public ObservableList<Produto> obsProdutos = FXCollections.observableArrayList();
	

	public TelaEstoqueController() {
		obsProdutos.addAll(gerenciador.produtos);
		
	}

	@FXML
	private void cadastrarProduto(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("../view/TelaCadastroDeProduto.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("");
		stage.show();

	}

	  @FXML
	   private void atualizaEstoque(ActionEvent event) {
		obsProdutos.clear();
		obsProdutos.addAll(gerenciador.produtos);
			
	}

	@SuppressWarnings("unchecked")
	private void colunas() {

		TableColumn<Produto, String> cln_nome = new TableColumn<Produto, String>("Nome Produto");
		cln_nome.setCellValueFactory(new PropertyValueFactory<Produto, String>("descricao"));
		TableColumn<Produto, Integer> cln_quantidade = new TableColumn<Produto, Integer>("Quantidade");
		cln_quantidade.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("quantidade"));
		TableColumn<Produto, Double> cln_valorVenda = new TableColumn<Produto, Double>("Valor Venda");
		cln_valorVenda.setCellValueFactory(new PropertyValueFactory<Produto, Double>("valorVenda"));
		TableColumn<Produto, Double> cln_valorCusto = new TableColumn<Produto, Double>("Valor Custo");
		cln_valorCusto.setCellValueFactory(new PropertyValueFactory<Produto, Double>("valorCusto"));
		TableColumn<Produto, String> cln_data = new TableColumn<Produto, String>("Data cadastro");
		cln_data.setCellValueFactory(new PropertyValueFactory<Produto, String>("dataCadastro"));

		tb_Produtos.setItems(obsProdutos);
		tb_Produtos.getColumns().addAll(cln_nome, cln_quantidade, cln_valorVenda, cln_valorCusto, cln_data);
		cln_nome.setPrefWidth(300);
		cln_nome.setResizable(false);
		cln_quantidade.setPrefWidth(199);
		cln_quantidade.setResizable(false);
		cln_valorVenda.setPrefWidth(200);
		cln_valorVenda.setResizable(false);
		cln_valorCusto.setPrefWidth(200);
		cln_valorCusto.setResizable(false);
		cln_data.setPrefWidth(200);
		cln_data.setResizable(false);

	}
	@FXML 
	public void letraDigitada(KeyEvent evt) {
		String nome = txt_pesquisaProduto.getText();
		obsProdutos.clear();
		if(nome.length() > 0){
			for(Produto produto : gerenciador.produtos){
				if(produto.getDescricao().toLowerCase().startsWith(nome.toLowerCase())){
					obsProdutos.add(produto);
				}
			}
		}else{
			obsProdutos.addAll(gerenciador.produtos);
		}
	}
	@FXML
	public void mouseClicado(MouseEvent e) throws Exception{
		
		
	}
	
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		colunas();
	}

}
