package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Main extends Application {

	private static Stage stage;
	public static Controller controller;
	public static SceneController sceneController;

	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		controller = new Controller();
		sceneController = new SceneController(stage);

		try {
			VBox root = new VBox(10);

			SignInPane signIn = new SignInPane();
			root.getChildren().add(signIn.getRootPane());
			
//			HomePane home = new HomePane();
//			root.getChildren().add(home.getRootPane());
			Scene scene = new Scene(root, 700, 500);

			stage.setScene(scene);
			stage.setTitle("palm_nut");
			stage.setResizable(false);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
