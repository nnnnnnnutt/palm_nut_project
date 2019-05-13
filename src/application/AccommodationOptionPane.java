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

public class AccommodationOptionPane {
	private Scene AccommodationOptionScene;
	private VBox rootPane;
	private ImageView guestHouseBtn;
	private ImageView hostelBtn;
	private ImageView hotelBtn;
	private ImageView homeBtn;
	private Button signOutBtn;

	public AccommodationOptionPane() {
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
		guestHouseBtn = new ImageView(new Image(ClassLoader.getSystemResource("Guesthouse.png").toString()));
		guestHouseBtn.setFitHeight(100);
		guestHouseBtn.setFitWidth(100);

		guestHouseBtn.setLayoutX(335);
		guestHouseBtn.setLayoutY(110);

		guestHouseBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		guestHouseBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		guestHouseBtn.setOnMouseClicked(e -> {
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			// change to other scene
			SignUpPane signUp = new SignUpPane();
			Main.sceneController.changeScene(signUp.getSignUpscene());
		});

		hostelBtn = new ImageView(new Image(ClassLoader.getSystemResource("Hostel.png").toString()));
		hostelBtn.setFitHeight(100);
		hostelBtn.setFitWidth(100);

		hostelBtn.setLayoutX(220);
		hostelBtn.setLayoutY(50);

		hostelBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		hostelBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		hostelBtn.setOnMouseClicked(e -> {
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			// change to other scene
			SignUpPane signUp = new SignUpPane();
			Main.sceneController.changeScene(signUp.getSignUpscene());
		});

		hotelBtn = new ImageView(new Image(ClassLoader.getSystemResource("Hotel.png").toString()));
		hotelBtn.setFitHeight(100);
		hotelBtn.setFitWidth(100);

		hotelBtn.setLayoutX(100);
		hotelBtn.setLayoutY(0);

		hotelBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		hotelBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		hotelBtn.setOnMouseClicked(e -> {
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

		Label gus = new Label("Guesthouse");
		gus.setLayoutX(335);
		gus.setLayoutY(220);

		Label hotel = new Label("Hotel");
		hotel.setLayoutX(100);
		hotel.setLayoutY(100);

		Label hos = new Label("Hostel");
		hos.setLayoutX(220);
		hos.setLayoutY(160);

		Label home = new Label("Back to Homepage");
		home.setLayoutX(450);
		home.setLayoutY(260);

		menu.getChildren().addAll(hotelBtn, hotel, hostelBtn, hos, guestHouseBtn, gus, homeBtn, home);
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

		AccommodationOptionScene = new Scene(rootPane, 700, 500);

	}

	public Scene getAccommodationOptionScene() {
		return AccommodationOptionScene;
	}

	public VBox getRootPane() {
		return rootPane;
	}

}
