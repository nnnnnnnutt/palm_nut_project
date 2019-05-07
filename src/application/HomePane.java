package application;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class HomePane {
	private Scene homeScene;
	
	public HomePane() {
		HBox rootPane = new HBox();
		rootPane.setStyle("-fx-background-color:MISTYROSE;");
		homeScene = new Scene(rootPane,700,500);
	}

	public Scene getHomeScene() {
		return homeScene;
	}
	
	
}
