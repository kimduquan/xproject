package xproject.xui.impl;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NewRegistry {

	private AppController appController;
	
	public NewRegistry(AppController controller) {
		appController = controller;
	}
	
	public void main() throws Exception {
		Class<?> cls = getClass();
		String clsName = cls.getSimpleName();
		Object obj = FXMLLoader.load(cls.getResource(clsName + ".fxml"));
		Pane pane = (Pane)obj;
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(cls.getResource(clsName + ".css").toExternalForm());
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle(clsName);
		stage.show();
	}
}
