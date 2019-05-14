package application;

import java.util.Date;
import java.util.Optional;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import logic.ApplicationLogic;

public class RestaurantOptionPane {
	private Scene RestaurantOptionScene;
	private VBox rootPane;
	private ImageView dessertBtn;
	private ImageView aLaCarteBtn;
	private ImageView buffetBtn;
	private ImageView homeBtn;
	private Button signOutBtn;

	public RestaurantOptionPane() {
		rootPane = new VBox(50);
		rootPane.setPadding(new Insets(25, 25, 25, 25));
		rootPane.setStyle("-fx-background-color:MISTYROSE;");

		VBox time = new VBox(15);
		time.setAlignment(Pos.CENTER_LEFT);
		DigitalClock clock = new DigitalClock();
		Label date = new Label(new Date().toString().substring(0, 10));
		time.getChildren().addAll(date, clock);

		rootPane.getChildren().add(time);

		Pane menu = new Pane();
		dessertBtn = new ImageView(new Image(ClassLoader.getSystemResource("Dessert.png").toString()));
		dessertBtn.setFitHeight(100);
		dessertBtn.setFitWidth(100);

		dessertBtn.setLayoutX(335);
		dessertBtn.setLayoutY(110);

		dessertBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		dessertBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		dessertBtn.setOnMouseClicked(e -> {
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			// change to other scene
			ApplicationLogic logic = new ApplicationLogic();
			DessertScreen dessert = new DessertScreen(logic.getAllDesserts());
			Main.sceneController.changeScene(dessert.getDessertScreenScene());
		});

		aLaCarteBtn = new ImageView(new Image(ClassLoader.getSystemResource("Alacarte.png").toString()));
		aLaCarteBtn.setFitHeight(100);
		aLaCarteBtn.setFitWidth(100);

		aLaCarteBtn.setLayoutX(220);
		aLaCarteBtn.setLayoutY(50);

		aLaCarteBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		aLaCarteBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		aLaCarteBtn.setOnMouseClicked(e -> {
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			// change to other scene
			SignUpPane signUp = new SignUpPane();
			Main.sceneController.changeScene(signUp.getSignUpscene());
		});

		buffetBtn = new ImageView(new Image(ClassLoader.getSystemResource("Buffet.png").toString()));
		buffetBtn.setFitHeight(100);
		buffetBtn.setFitWidth(100);

		buffetBtn.setLayoutX(100);
		buffetBtn.setLayoutY(0);

		buffetBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		buffetBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		buffetBtn.setOnMouseClicked(e -> {
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			// change to other scene
			SignUpPane signUp = new SignUpPane();
			Main.sceneController.changeScene(signUp.getSignUpscene());
		});

		homeBtn = new ImageView(new Image(ClassLoader.getSystemResource("Home.png").toString()));
		homeBtn.setFitHeight(100);
		homeBtn.setFitWidth(100);

		homeBtn.setLayoutX(450);
		homeBtn.setLayoutY(150);

		homeBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		homeBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		homeBtn.setOnMouseClicked(e -> {
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			// change to other scene
			HomePane home = new HomePane();
			Main.sceneController.changeScene(home.getHomeScene());
		});

		Label des = new Label("Dessert");
		des.setLayoutX(335);
		des.setLayoutY(220);

		Label buf = new Label("Buffet");
		buf.setLayoutX(100);
		buf.setLayoutY(100);

		Label ala = new Label("A La Carte");
		ala.setLayoutX(220);
		ala.setLayoutY(160);

		Label home = new Label("Back to Homepage");
		home.setLayoutX(450);
		home.setLayoutY(260);

		menu.getChildren().addAll(buffetBtn, buf, aLaCarteBtn, ala, dessertBtn, des, homeBtn, home);
		rootPane.getChildren().add(menu);

		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		signOutBtn = new Button("Sign out");
		signOutBtn.setPrefWidth(75);
		signOutBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				signOutBtn.setPrefWidth(85);
			}
		});
		signOutBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				signOutBtn.setPrefWidth(75);
			}
		});
		signOutBtn.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			// alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure for signing out?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				// ... user chose OK -> change to sign in scene

				SignInPane signIn = new SignInPane();
				Main.sceneController.changeScene(signIn.getSignInScene());
			}
		});

		hbBtn.getChildren().add(signOutBtn);

		rootPane.getChildren().add(hbBtn);

		RestaurantOptionScene = new Scene(rootPane, 700, 500);

	}

	public Scene getRestaurantOptionScene() {
		return RestaurantOptionScene;
	}

	public VBox getRootPane() {
		return rootPane;
	}

}
