package application;

import java.util.Date;
import java.util.Optional;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AccommodationOptionPane {
	private Scene AccommodationOptionScene;
	private VBox rootPane;
	private ImageView guestHouseBtn;
	private ImageView hostelBtn;
	private ImageView hotelBtn;
	private ImageView homeBtn;
	private ImageView signOutBtn;

	public AccommodationOptionPane() {
		rootPane = new VBox(120);
		rootPane.setPadding(new Insets(25, 25, 25, 25));
		rootPane.setStyle("-fx-background-color:MISTYROSE;");

		VBox time = new VBox(15);
		time.setAlignment(Pos.CENTER_LEFT);
		DigitalClock clock = new DigitalClock();
		Label date = new Label(new Date().toString().substring(0, 10));
		time.getChildren().addAll(date, clock);

		rootPane.getChildren().add(time);

		GridPane menu = new GridPane();
		menu.setAlignment(Pos.CENTER);
		menu.setHgap(55);
		menu.setVgap(15);
		
		guestHouseBtn = new ImageView(new Image(ClassLoader.getSystemResource("Guesthouse.png").toString()));
		guestHouseBtn.setFitHeight(100);
		guestHouseBtn.setFitWidth(100);

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
		homeBtn.setFitHeight(40);
		homeBtn.setFitWidth(40);


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

		Label hotel = new Label("Hotel");

		Label hos = new Label("Hostel");

//		Label home = new Label("Back to Homepage");
//		home.setLayoutX(450);
//		home.setLayoutY(260);
		
		menu.add(hotelBtn, 0, 0);
		menu.add(hotel, 0, 1);
		menu.add(guestHouseBtn, 1, 0);
		menu.add(gus, 1, 1);
		menu.add(hostelBtn, 2, 0);
		menu.add(hos, 2, 1);
		
		rootPane.getChildren().add(menu);

		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		signOutBtn = new ImageView(new Image(ClassLoader.getSystemResource("logout.png").toString()));
		signOutBtn.setFitHeight(40);
		signOutBtn.setFitWidth(40);


		signOutBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		signOutBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		signOutBtn.setOnMouseClicked(e -> {
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			// change to other scene
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

		hbBtn.getChildren().addAll(homeBtn,signOutBtn);

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
