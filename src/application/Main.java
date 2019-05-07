package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Main extends Application {

	private static Stage stage;

	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;

		try {
			VBox root = new VBox(10);

			SignInPane signIn = new SignInPane();
			root.getChildren().add(signIn.getRootPane());

			Scene scene = new Scene(root, 700, 500);

			stage.setScene(scene);
			stage.setTitle("palm_nut");
			stage.setResizable(false);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void changeScene(Scene scene) {
		stage.setScene(scene);
	}

	public static void main(String[] args) {
		launch(args);
	}

//	public static Stage getStage() {
//		return stage;
//	}
}
