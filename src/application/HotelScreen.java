package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import logic.ALaCarte;
import logic.User;

public class HotelScreen {
	private VBox rootPane;
	private Scene HotelScreenScene;
	private ImageView homeBtn;
	private ImageView signOutBtn;
	
	public HotelScreen(ArrayList<Object> hotel) {
		rootPane = new VBox(10);
		rootPane.setPadding(new Insets(25, 25, 25, 25));
		rootPane.setStyle("-fx-background-color:BLANCHEDALMOND;");
		
		VBox time = new VBox(15);
		time.setAlignment(Pos.CENTER_LEFT);
		DigitalClock clock = new DigitalClock();
		Label date = new Label(new Date().toString().substring(0, 10));
		time.getChildren().addAll(date, clock);

		//rootPane.getChildren().add(time);
		
		User currentUser = Main.controller.getCurrentUser();
		if (currentUser != null) {
			VBox profile = new VBox(15);
			Label username = new Label(currentUser.getUsername());
			Label userInfo = new Label(currentUser.getName() + " " + currentUser.getLastName());
			profile.getChildren().addAll(username,userInfo);
			HBox header = new HBox(120);
			header.getChildren().addAll(time,profile);
			rootPane.getChildren().addAll(header);
		}
		else {
			rootPane.getChildren().add(time);
		}

	                    
		VBox vpane = new VBox();
		vpane.setPrefSize(700, 500);
		vpane.setAlignment(Pos.TOP_CENTER);
		vpane.setPadding(new Insets(20, 0, 0, 100));
		vpane.setSpacing(5);
		
		for(Object hotel: hotel) {
			Hotel hotel = new HotelPane(hotel);
			vpane.getChildren().add(pane);
		}
		
		
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
		rootPane.getChildren().addAll(vpane,hbBtn);
		
		ScrollPane scrollPane = new ScrollPane(rootPane);
	    scrollPane.setFitToWidth(true);
	    scrollPane.setFitToHeight(true);
	    scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
	    scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	    VBox.setVgrow(scrollPane, Priority.ALWAYS);
	    HBox.setHgrow(scrollPane, Priority.ALWAYS);
		
	    HotelScreenScene = new Scene(scrollPane,700,500);
	
	}

	public VBox getRootPane() {
		return rootPane;
	}

	public Scene getHotelScreenScene() {
		return HotelScreenScene;
	}
}
