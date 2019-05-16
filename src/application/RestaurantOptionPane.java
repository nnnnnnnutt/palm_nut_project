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
import logic.User;

public class RestaurantOptionPane {
	private Scene RestaurantOptionScene;
	private VBox rootPane;
	private ImageView dessertBtn;
	private ImageView aLaCarteBtn;
	private ImageView buffetBtn;
	private ImageView homeBtn;
	private ImageView signOutBtn;

	public RestaurantOptionPane() {
		rootPane = new VBox(120);
		rootPane.setPadding(new Insets(25, 25, 25, 25));
		rootPane.setStyle("-fx-background-color:BLANCHEDALMOND;");

		VBox time = new VBox(15);
		time.setAlignment(Pos.CENTER_LEFT);
		DigitalClock clock = new DigitalClock();
		Label date = new Label(new Date().toString().substring(0, 10));
		time.getChildren().addAll(date, clock);
		
		User currentUser = Main.controller.getCurrentUser();
		if (currentUser != null) {
			VBox profile = new VBox(15);
			Label username = new Label(currentUser.getUsername());
			Label userInfo = new Label(currentUser.getName() + " " + currentUser.getLastName());
			profile.getChildren().addAll(username,userInfo);
			HBox header = new HBox(20);
			header.getChildren().addAll(time);
			rootPane.getChildren().addAll(header);
		}
		else {
			rootPane.getChildren().add(time);
		}
		
		//rootPane.getChildren().add(time);

		GridPane menu = new GridPane();
		menu.setAlignment(Pos.CENTER);
		menu.setHgap(55);
		menu.setVgap(15);
		
		dessertBtn = new ImageView(new Image(ClassLoader.getSystemResource("Dessert.png").toString()));
		dessertBtn.setFitHeight(100);
		dessertBtn.setFitWidth(100);
//		dessertBtn.setLayoutX(335);
//		dessertBtn.setLayoutY(110);

		dessertBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		dessertBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		dessertBtn.setOnMouseClicked(e -> {
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			// change to other scene
			DessertScreen dessert = new DessertScreen(Main.controller.data.getAllDesserts());
			Main.sceneController.changeScene(dessert.getDessertScreenScene());
		});
		

		aLaCarteBtn = new ImageView(new Image(ClassLoader.getSystemResource("Alacarte.png").toString()));
		aLaCarteBtn.setFitHeight(100);
		aLaCarteBtn.setFitWidth(100);

//		aLaCarteBtn.setLayoutX(220);
//		aLaCarteBtn.setLayoutY(50);

		aLaCarteBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		aLaCarteBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		aLaCarteBtn.setOnMouseClicked(e -> {
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			// change to other scene
			ALaCarteScreen ala = new ALaCarteScreen(Main.controller.data.getAllALaCartes());
			Main.sceneController.changeScene(ala.getALaCarteScreenScene());
		});

		buffetBtn = new ImageView(new Image(ClassLoader.getSystemResource("Buffet.png").toString()));
		buffetBtn.setFitHeight(100);
		buffetBtn.setFitWidth(100);

//		buffetBtn.setLayoutX(100);
//		buffetBtn.setLayoutY(0);

		buffetBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		buffetBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		buffetBtn.setOnMouseClicked(e -> {
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			// change to other scene
			BuffetScreen buffet = new BuffetScreen(Main.controller.data.getAllBuffets());
			Main.sceneController.changeScene(buffet.getBuffetScreenScene());
		});

		homeBtn = new ImageView(new Image(ClassLoader.getSystemResource("Home.png").toString()));
		homeBtn.setFitHeight(40);
		homeBtn.setFitWidth(40);

//		homeBtn.setLayoutX(450);
//		homeBtn.setLayoutY(150);

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
		des.setAlignment(Pos.CENTER);

		Label buf = new Label("Buffet");
		buf.setAlignment(Pos.CENTER);

		Label ala = new Label("A La Carte");
		ala.setAlignment(Pos.CENTER);
		
		menu.add(buffetBtn, 0, 0);
		menu.add(buf, 0, 1);
		menu.add(aLaCarteBtn, 1, 0);
		menu.add(ala, 1, 1);
		menu.add(dessertBtn, 2, 0);
		menu.add(des, 2, 1);
//		menu.getChildren().addAll(buffetBtn, buf, aLaCarteBtn, ala, dessertBtn, des, homeBtn, home);
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

		hbBtn.getChildren().addAll(homeBtn, signOutBtn);

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
