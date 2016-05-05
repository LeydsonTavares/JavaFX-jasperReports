package controller;

import java.util.Timer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	Timer timer = new Timer();

	static Scene SCENE;

	@Override
	public void start(Stage stage) throws Exception {
		Parent prime = FXMLLoader.load(getClass().getResource("../view/TelaLogin.fxml"));
		Scene cena = new Scene(prime);
		stage.setScene(cena);
		SCENE = cena;
		stage.setTitle("");
		stage.setResizable(false);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
