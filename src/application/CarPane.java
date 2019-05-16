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
import logic.Car;

public class CarPane extends HBox {

	public CarPane(Car car) {
		super(10);
		setPrefWidth(500);
		setPrefHeight(100);
		setAlignment(Pos.CENTER_LEFT);
		setStyle("-fx-background-color:BLANCHEDALMOND;");
		setPadding(new Insets(5,20,5,20));
		setSpacing(20);
		
		ImageView img = new ImageView(new Image(ClassLoader.getSystemResource(car.getUrl()+".jpg").toString()));
		img.setFitHeight(100); 
		img.setFitWidth(100);
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
		
		Label name = new Label(car.getName());
		name.setFont(new Font(16));
		name.setMinWidth(200);
		
		Label location = new Label(car.getLicensePlate());
		location.setFont(new Font(12));
				
		
		VBox vBox = new VBox(); 
		vBox.setAlignment(Pos.TOP_LEFT);
		vBox.getChildren().addAll(name,location);
		
		getChildren().addAll(img,vBox);
		
	}
}