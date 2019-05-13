package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class Main extends Application {

	private static Stage stage;
	public static Controller controller;
	public static SceneController sceneController;
	private static Thread thread;
	public static boolean alertcheck = false;

	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		controller = new Controller();
		sceneController = new SceneController(stage);

		try {
			VBox root = new VBox(10);

//			SignInPane signIn = new SignInPane();
//			root.getChildren().add(signIn.getRootPane());
			
			HomePane home = new HomePane();
			root.getChildren().add(home.getRootPane());
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
	
	public static void startThread() {
		thread = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(600000);
					Platform.runLater(new Runnable() {
					    @Override
					    public void run() {
					    	try {
					    		if(!Main.alertcheck) {
					    			Alert alert = new Alert(AlertType.ERROR);
					    			alert.setTitle("Out of Time");
					    			alert.setContentText("You have stayed in the page for 10 minutes without doing anything."+"\n"+"Please sign in again.");
					    			alert.showAndWait().ifPresent(type->{
					    				SignInPane signIn = new SignInPane();
					    				Main.sceneController.changeScene(signIn.getSignInScene());
					    			});
								Main.alertcheck = true;
					    		}
					    	}catch (Exception e){
					    		e.printStackTrace();
					    	}
					}
					});
				} catch (Exception e) {
					e.printStackTrace();
	
				}
			}
			
		});
		thread.start();
	}
    
    public static void stopThread() {
    	thread.interrupt();
    }
}
