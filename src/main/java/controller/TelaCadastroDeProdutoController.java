package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TelaCadastroDeProdutoController implements Initializable {

	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	private GerenciadorDeVendas gerenciador = GerenciadorDeVendas.getInstance();

	@FXML
	private TextField txt_name_product;

	@FXML
	private TextField txt_value_cost;

	@FXML
	private TextField txt_value_sale;

	@FXML
	private TextField txt_amount;

	@FXML
	private TextField txt_dateRegister;

	@FXML
	private Button btn_save;

	@FXML
	private Button btn_voltarTela;

	@FXML
	private void salvarProduto(ActionEvent event) {
		if (txt_name_product.getText().length() == 0) {
			criaAlert(AlertType.INFORMATION, "Informação",
					"Por favor, preencha os dados solicitados para inserir produto.").show();
		} else if (txt_value_cost.getText().length() == 0) {
			criaAlert(AlertType.INFORMATION, "Informação",
					"Por favor, preencha os dados solicitados para inserir produto.").show();
		} else if (txt_value_sale.getText().length() == 0) {
			criaAlert(AlertType.INFORMATION, "Informação",
					"Por favor, preencha os dados solicitados para inserir produto.").show();
		} else if (txt_amount.getText().length() == 0) {
			criaAlert(AlertType.INFORMATION, "Informação",
					"Por favor, preencha os dados solicitados para inserir produto.").show();

		} else {

			Produto produto = new Produto();
			produto.setDescricao(txt_name_product.getText());
			produto.setQuantidade(Integer.parseInt(txt_amount.getText()));
			produto.setValorCusto(Double.parseDouble(txt_value_cost.getText()));
			produto.setValorVenda(Double.parseDouble(txt_value_sale.getText()));
			produto.setDataCadastro(txt_dateRegister.getText());

			gerenciador.adicionarProdutos(produto);
			criaAlert(AlertType.INFORMATION, "Informação",
					"Produto " + txt_name_product.getText() + ", cadastrado com sucesso").show();

		}

	}

	@FXML
	private void voltarTela(ActionEvent event) throws Exception {
		((Node) (event.getSource())).getScene().getWindow().hide();	
		
	}

	private Alert criaAlert(AlertType tipo, String string, String string2) {
		Alert a = new Alert(tipo);
		a.setTitle(string);
		a.setHeaderText(string2);
		return a;
	}

	public void initialize(URL location, ResourceBundle resources) {
		txt_dateRegister.setText(formatador.format(calendar.getTime()));

	}

}
