package controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TelaVendasController implements Initializable {
	
	DecimalFormat deci = new DecimalFormat("0,00");

	private GerenciadorDeVendas gerenciador = GerenciadorDeVendas.getInstance();

	Produto produtoSelecionado;

	private boolean moveCaretToPos = false;
	private int caretPos;

	@FXML
	private ComboBox<Produto> cb_produtos;

	@FXML
	private TableView<Produto> tb_ProdutosInseridos;

	@FXML
	private TextField txt_desconto;

	@FXML
	private Button btn_EfetuarVenda;

	@FXML
	private Button btn_CancelarVenda;

	@FXML
	private Button btn_InserirProduto;

	@FXML
	private Label lb_nomeCliente;

	@FXML
	private TextField txt_valorRecebido;

	@FXML
	private TextField txf_quantidade;

	@FXML
	private TextField txf_cpfCliente;

	@FXML
	private TextField txf_nomeCliente;

	@FXML
	private CheckBox cb_cadatrado;

	@FXML
	private CheckBox cb_NaoCadastrado;

	@FXML
	private Button btn_RemoverItem;

	@FXML
	private Label lb_totalCusto;

	@FXML
	private Label lb_valorAcobrar;

	@FXML
	private Label lb_totalVenda;

	@FXML
	private Label lb_valorTroco;

	@FXML
	void clienteCadastrado(ActionEvent event) {

	}

	@FXML
	void clienteNaoCadastrado(ActionEvent event) {

	}

	public ObservableList<Produto> obsProdutos1 = FXCollections.observableArrayList();

	public ObservableList<Produto> obsProdutos2 = FXCollections.observableArrayList();

	Double totalCusto = 0.0;

	Double totalVenda = 0.0;

	@FXML
	void cancelarVenda(ActionEvent event) {

		lb_valorTroco.setText("");
		lb_totalVenda.setText("");
		lb_totalCusto.setText("");
		lb_valorAcobrar.setText("");
		obsProdutos2.clear();
		cb_produtos.getItems().clear();
		tb_ProdutosInseridos.getItems().clear();

	}

	@FXML
	void efetuarVenda(ActionEvent event) throws Exception {

		if (obsProdutos2.size() == 0) {

			criaAlert(AlertType.INFORMATION, "Informação", "Por favor, selecione o produto.").show();

		} else if (txf_quantidade.getText().length() == 0) {
			criaAlert(AlertType.INFORMATION, "Informação", "Por favor,inserir quantidade do produto.").show();

		} else if (txt_valorRecebido.getText().length() == 0) {

			criaAlert(AlertType.INFORMATION, "Informação", "Por favor,inserir o valor recebido.").show();

		} else {

			for (int i = 0; i < obsProdutos2.size(); i++) {
				Produto p = obsProdutos2.get(i);

				for (Produto p1 : gerenciador.produtos) {

					if (p1.equals(p) == true) {

						p1.setQuantidade(p1.getQuantidade() - p.getQuantidade());

					}

				}

			}

			lb_valorTroco.setText("$" + (Double.parseDouble(txt_valorRecebido.getText()) - totalVenda));
			ControllerECF relatorio = new ControllerECF();
			relatorio.imprimir(gerenciador.produtos);
		}

	}

	private void inserirProduto() {

		if (txf_quantidade.getText().length() > 0) {

			int newQuantidade = Integer.parseInt(txf_quantidade.getText());
			Produto newProduto = new Produto();
			for (Produto produto : gerenciador.produtos) {
				if (produto.getDescricao().equals(cb_produtos.getValue())) {

					newProduto.setDescricao(produto.getDescricao());
					newProduto.setValorCusto(produto.getValorCusto() * newQuantidade);
					newProduto.setValorVenda(produto.getValorVenda());
					newProduto.setQuantidade(newQuantidade);

					totalCusto += (newProduto.getValorCusto());
					totalVenda += (newProduto.getValorVenda() * newQuantidade);

					obsProdutos2.add(newProduto);
					cb_produtos.getEditor().clear();
					txf_quantidade.clear();

					lb_totalCusto.setText(NumberFormat.getCurrencyInstance().format(totalCusto));
					lb_totalVenda.setText(NumberFormat.getCurrencyInstance().format(totalVenda));
					lb_valorAcobrar.setText(NumberFormat.getCurrencyInstance().format(totalVenda));
					
					

				}

			}

		} else {

			criaAlert(AlertType.INFORMATION, "Informação",
					"Por favor, preencha o campo QUANTIDADE para inserir produto.").show();

		}

	}

	@FXML
	public void EnterAcionado(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			inserirProduto();
		}

	}

	@FXML
	void removerItem(ActionEvent event) {
		obsProdutos2.remove(tb_ProdutosInseridos.getSelectionModel().getSelectedItem());

	}

	@FXML
	public void letraDigitada(KeyEvent event) {
		if (event.getCode() == KeyCode.UP) {
			caretPos = -1;
			moveCaret(cb_produtos.getEditor().getText().length());
			return;
		} else if (event.getCode() == KeyCode.DOWN) {
			if (!cb_produtos.isShowing()) {
				cb_produtos.show();
			}
			caretPos = -1;
			moveCaret(cb_produtos.getEditor().getText().length());
			return;
		} else if (event.getCode() == KeyCode.BACK_SPACE) {
			moveCaretToPos = true;
			caretPos = cb_produtos.getEditor().getCaretPosition();
		} else if (event.getCode() == KeyCode.DELETE) {
			moveCaretToPos = true;
			caretPos = cb_produtos.getEditor().getCaretPosition();

		} else if (event.getCode() == KeyCode.ENTER) {
			txf_quantidade.requestFocus();
		}

		if (event.isControlDown() || event.getCode() == KeyCode.BACK_SPACE || event.getCode() == KeyCode.RIGHT
				|| event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.DELETE
				|| event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.HOME || event.getCode() == KeyCode.END
				|| event.getCode() == KeyCode.TAB)
			return;

		ObservableList<Produto> list = FXCollections.observableArrayList();
		for (int i = 0; i < gerenciador.produtos.size(); i++)

		{
			if (((List<Produto>) gerenciador.produtos).get(i).toString().toLowerCase()
					.startsWith(cb_produtos.getEditor().getText().toLowerCase())) {
				list.add(((List<Produto>) gerenciador.produtos).get(i));
			}
		}

		String t = cb_produtos.getEditor().getText();

		cb_produtos.setItems(list);
		cb_produtos.getEditor().setText(t);

		if (!moveCaretToPos)

		{
			caretPos = -1;
		}

		moveCaret(t.length());
		if (!list.isEmpty()) {
			cb_produtos.show();
		}

	}

	private void moveCaret(int textLength) {
		if (caretPos == -1) {
			cb_produtos.getEditor().positionCaret(textLength);
		} else {
			cb_produtos.getEditor().positionCaret(caretPos);
		}
		moveCaretToPos = false;
	}

	@SuppressWarnings("unchecked")
	private void coluna() {

		TableColumn<Produto, String> cln_nome = new TableColumn<Produto, String>("Produto");
		cln_nome.setCellValueFactory(new PropertyValueFactory<Produto, String>("descricao"));
		TableColumn<Produto, Integer> cln_quantidade = new TableColumn<Produto, Integer>("Quantidade");
		cln_quantidade.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("quantidade"));
		TableColumn<Produto, Double> cln_valorVenda = new TableColumn<Produto, Double>("Valor venda");
		cln_valorVenda.setCellValueFactory(new PropertyValueFactory<Produto, Double>("valorVenda"));
		TableColumn<Produto, Double> cln_valorCusto = new TableColumn<Produto, Double>("Total unitário");
		cln_valorCusto.setCellValueFactory(new PropertyValueFactory<Produto, Double>("valorCusto"));

		tb_ProdutosInseridos.setItems(obsProdutos2);
		tb_ProdutosInseridos.getColumns().addAll(cln_nome, cln_valorVenda, cln_quantidade, cln_valorCusto);
		cln_nome.setPrefWidth(317);
		cln_nome.setResizable(false);
		cln_quantidade.setPrefWidth(100);
		cln_quantidade.setResizable(false);
		cln_valorVenda.setPrefWidth(150);
		cln_valorVenda.setResizable(false);
		cln_valorCusto.setPrefWidth(152);
		cln_valorCusto.setResizable(false);

	}

	private Alert criaAlert(AlertType tipo, String string, String string2) {
		Alert a = new Alert(tipo);
		a.setTitle(string);
		a.setHeaderText(string2);
		return a;
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		coluna();
		cb_produtos.setEditable(true);

	}
}
