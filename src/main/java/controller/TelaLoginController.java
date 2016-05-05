package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class TelaLoginController implements Initializable {

	@FXML
	private TextField loginUsuario;

	@FXML
	private PasswordField senhaUsuario;

	@FXML
	private Button botaoChamarTelaUsuario;

	@FXML
	private Button botaoChamaTelaCriarUsuario;

	@FXML
	private Button botaoLimparText;

	@FXML
	public void ChamaTelaCriarUsuario(ActionEvent event) throws Exception {

	}

	@FXML
	public void ChamarTelaUsuario(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("../view/TelaMenu.fxml"));
		Main.SCENE.setRoot(parent);

	}

	@SuppressWarnings("unused")
	private Alert criaAlert(AlertType tipo, String string, String string2) {
		Alert a = new Alert(tipo);
		a.setTitle(string);
		a.setHeaderText(string2);
		return a;
	}

	@FXML
	public void LimparText(ActionEvent event) throws Exception {
		loginUsuario.clear();
		senhaUsuario.clear();
	}

	@FXML
	public void senhaDigitada(KeyEvent event) throws Exception {

	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		loginUsuario.setText("Leydson");
		senhaUsuario.setText("153468");

	}
}
