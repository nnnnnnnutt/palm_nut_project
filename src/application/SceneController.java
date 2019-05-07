package application;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
	private Stage stage;

	public SceneController(Stage stage) {
		this.stage = stage;
	}
	public void changeScene(Scene scene) {
		this.stage.setScene(scene);
	}
}
