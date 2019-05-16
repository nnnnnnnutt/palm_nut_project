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

public class HomePane {
	private Scene homeScene;
	private VBox rootPane;
	private ImageView signOutBtn;
	private ImageView accommodationBtn;
	private ImageView restaurantBtn;
	private ImageView voucherBtn;
	private ImageView carBtn;
	private ImageView historyBtn;

	public HomePane() {

		rootPane = new VBox(50);
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
			HBox image = new HBox(10);
			ImageView img = new ImageView(new Image(ClassLoader.getSystemResource(currentUser.getUsername() +".png").toString())); 
			img.setFitHeight(80);
			img.setFitWidth(80);
			image.getChildren().addAll(profile,img);
			HBox header = new HBox(20);
			header.getChildren().addAll(time,image);
			rootPane.getChildren().addAll(header);
		}
		else {
			rootPane.getChildren().add(time);
		}

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
		
		hbBtn.getChildren().add(signOutBtn);

		GridPane menu = new GridPane();
		menu.setAlignment(Pos.CENTER);
		menu.setHgap(55);
		menu.setVgap(15);
		accommodationBtn = new ImageView(new Image(ClassLoader.getSystemResource("Accommodation.png").toString()));
		accommodationBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		accommodationBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		accommodationBtn.setOnMouseClicked(e -> {
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			// change to Accomodation choose scene

			AccommodationOptionPane accOp = new AccommodationOptionPane();
			Main.sceneController.changeScene(accOp.getAccommodationOptionScene());
		});
		accommodationBtn.setFitHeight(100);
		accommodationBtn.setFitWidth(100);

		restaurantBtn = new ImageView(new Image(ClassLoader.getSystemResource("Restaurant.png").toString()));
		restaurantBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		restaurantBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		restaurantBtn.setOnMouseClicked(e -> {
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			// change to Restaurant choose scene
			RestaurantOptionPane resOp = new RestaurantOptionPane();
			Main.sceneController.changeScene(resOp.getRestaurantOptionScene());
		});
		restaurantBtn.setFitHeight(100);
		restaurantBtn.setFitWidth(100);
		
		carBtn = new ImageView(new Image(ClassLoader.getSystemResource("car.png").toString()));
		carBtn.setFitHeight(100);
		carBtn.setFitWidth(100);
		carBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		carBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		carBtn.setOnMouseClicked(e -> {
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			// change to Accomodation choose scene
			
			Main.sceneController.changeScene(CarScreen.getCarScreenScene());
		});
		
		historyBtn = new ImageView(new Image(ClassLoader.getSystemResource("history.png").toString()));
		historyBtn.setFitHeight(100);
		historyBtn.setFitWidth(100);
		historyBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		historyBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		historyBtn.setOnMouseClicked(e -> {
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			// change to Accomodation choose scene

			AccommodationOptionPane accOp = new AccommodationOptionPane();
			Main.sceneController.changeScene(accOp.getAccommodationOptionScene());
		});
		
		voucherBtn = new ImageView(new Image(ClassLoader.getSystemResource("Voucher.png").toString()));
		voucherBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		voucherBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});
		voucherBtn.setOnMouseClicked(e -> {
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			// change to Restaurant choose scene
			VoucherPane voucher = new VoucherPane();
			Main.sceneController.changeScene(voucher.getVoucherPaneScene());
		});
		voucherBtn.setFitHeight(100);
		voucherBtn.setFitWidth(100);

		Label acc = new Label("Accommodation");
		Label res = new Label("Restaurant");
		Label vou = new Label("Voucher");
		Label car = new Label("Car");
		Label his = new Label("History");
		
		menu.add(accommodationBtn, 0, 0);
		menu.add(acc, 0, 1);
		menu.add(restaurantBtn, 1, 0);
		menu.add(res, 1, 1);
		menu.add(carBtn, 2, 0);
		menu.add(car, 2, 1);
		menu.add(voucherBtn, 0, 2);
		menu.add(vou, 0, 3);
		menu.add(historyBtn, 1, 2);
		menu.add(his, 1, 3);
		
		rootPane.getChildren().addAll(menu, hbBtn);

		homeScene = new Scene(rootPane, 700, 500);
	}

	public Scene getHomeScene() {
		return homeScene;
	}


	public VBox getRootPane() {
		return rootPane;
	}

}
