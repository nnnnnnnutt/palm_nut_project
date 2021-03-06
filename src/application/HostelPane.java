package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import logic.Accommodation;

public class HostelPane extends HBox{
	public HostelPane(Accommodation hostel) {
		super(10);
		setPrefWidth(500);
		setPrefHeight(100);
		setAlignment(Pos.CENTER_LEFT);
		setStyle("-fx-background-color:BLANCHEDALMOND;");
		setPadding(new Insets(5,20,5,20));
		setSpacing(20);
		
		
		ImageView img = new ImageView(new Image(ClassLoader.getSystemResource(hostel.getName()+ ".jpg").toString()));
		img.setFitHeight(80); 
		img.setFitWidth(80);
		img.setPreserveRatio(true);
		
		img.setOnMouseEntered(e -> {
			setCursor(Cursor.HAND);
		});
		img.setOnMouseExited(e -> {
			setCursor(Cursor.DEFAULT);
		});
		img.setOnMouseClicked(e -> {
			setCursor(javafx.scene.Cursor.HAND);
			// change to other scene
			HomePane home = new HomePane();
			Main.sceneController.changeScene(home.getHomeScene());
		});
		
		Label name = new Label(hostel.getName());
		name.setFont(new Font(16));
		name.setMinWidth(200);
		
		Label rating = new Label(String.valueOf(hostel.getRating()));
		name.setFont(new Font(16));
		name.setMinWidth(200);
		
		Label location = new Label(hostel.getLocation());
		name.setFont(new Font(16));
		name.setMinWidth(200);
		
		Label price = new Label(String.valueOf(hostel.getPrice()));
		name.setFont(new Font(16));
		name.setMinWidth(200);
		
		Label info = new Label(hostel.getInfo());
		name.setFont(new Font(16));
		name.setMinWidth(200);
		
		
		VBox vBox = new VBox(); 
		vBox.setAlignment(Pos.TOP_LEFT);
		vBox.getChildren().addAll(name,location,rating,location,price,info);
		
		getChildren().addAll(img,vBox);
		
	}
}
