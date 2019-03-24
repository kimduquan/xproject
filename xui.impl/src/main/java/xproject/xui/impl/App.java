package xproject.xui.impl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args )
    {
    	launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Class<?> cls = getClass();
		String clsName = cls.getSimpleName();
		Object obj = FXMLLoader.load(cls.getResource(clsName + ".fxml"));
		BorderPane pane = (BorderPane)obj;
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(cls.getResource(clsName + ".css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
