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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomePane {
	private Scene homeScene;
	private VBox rootPane;
	private Button signOutBtn;
	private ImageView accommodationBtn;
	private ImageView restaurantBtn;
	private ImageView voucherBtn;
	public HomePane() {
		
		rootPane = new VBox(120);
		rootPane.setPadding(new Insets(25, 25, 25, 25));
		rootPane.setStyle("-fx-background-color:MISTYROSE;");
		
		
		VBox time = new VBox(15);
		time .setAlignment(Pos.CENTER_LEFT);
		DigitalClock clock = new DigitalClock();
		Label date = new Label(new Date().toString().substring(0, 10));
		time.getChildren().addAll(date,clock);
		
//		VBox profile = new VBox(15);
//		Label username = new Label(Main.controller.getCurrentUser().getUsername().toString());
//		Label userInfo = new Label(Main.controller.getCurrentUser().getUsername().toString());// + " " + Main.controller.getCurrentUser().getLastName());
//		profile.getChildren().addAll(username,userInfo);
		
//		HBox header = new HBox(100);
//		header.getChildren().addAll(time,profile);
		
		rootPane.getChildren().add(time);
//		rootPane.getChildren().add(profile);
		
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
		signOutBtn.setOnAction(e ->{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			//alert.setHeaderText("Look, a Confirmation Dialog");
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
		accommodationBtn = new ImageView("Accommodation.png");
		accommodationBtn.setOnMouseEntered(e->{
			rootPane.setCursor(Cursor.HAND);
		});
		accommodationBtn.setOnMouseExited(e->{
			rootPane.setCursor(Cursor.DEFAULT);
		});
		accommodationBtn.setOnMouseClicked(e->{
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			//change to Accomodation choose scene
			
			AccommodationOptionPane accOp = new AccommodationOptionPane();
			Main.sceneController.changeScene(accOp.getAccommodationOptionScene());
		});
		accommodationBtn.setFitHeight(100);
		accommodationBtn.setFitWidth(100);
		
		
		restaurantBtn = new ImageView("Restaurant.png");
		restaurantBtn.setOnMouseEntered(e->{
			rootPane.setCursor(Cursor.HAND);
		});
		restaurantBtn.setOnMouseExited(e->{
			rootPane.setCursor(Cursor.DEFAULT);
		});
		restaurantBtn.setOnMouseClicked(e->{
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			//change to Restaurant choose scene
			RestaurantOptionPane resOp = new RestaurantOptionPane();
			Main.sceneController.changeScene(resOp.getRestaurantOptionScene());
		});
		restaurantBtn.setFitHeight(100);
		restaurantBtn.setFitWidth(100);
		
		voucherBtn = new ImageView("Voucher.png");
		voucherBtn.setOnMouseEntered(e->{
			rootPane.setCursor(Cursor.HAND);
		});
		voucherBtn.setOnMouseExited(e->{
			rootPane.setCursor(Cursor.DEFAULT);
		});
		voucherBtn.setOnMouseClicked(e->{
			rootPane.setCursor(javafx.scene.Cursor.HAND);
			//change to Restaurant choose scene
			SignUpPane signUp = new SignUpPane();
			Main.sceneController.changeScene(signUp.getSignUpscene());
		});
		voucherBtn.setFitHeight(100);
		voucherBtn.setFitWidth(100);
		
		Label acc = new Label("Accommodation");
		Label res = new Label("Restaurant");
		Label vou = new Label("Voucher");
		menu.add(accommodationBtn, 0, 0);
		menu.add(acc, 0, 1);
		menu.add(restaurantBtn, 1, 0);
		menu.add(res, 1, 1);
		menu.add(voucherBtn, 2, 0);
		menu.add(vou, 2, 1);
		rootPane.getChildren().addAll(menu,hbBtn);
		
		homeScene = new Scene(rootPane,700,500);
	}

	public Scene getHomeScene() {
		return homeScene;
	}
	

	public Button getSignOutBtn() {
		return signOutBtn;
	}

	public VBox getRootPane() {
		return rootPane;
	}
	
	
}
