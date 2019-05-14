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
import logic.Dessert;

public class DessertPane extends HBox {

	public DessertPane(Dessert dessert) {
		super(10);
		setPrefWidth(500);
		setPrefHeight(100);
		setAlignment(Pos.CENTER_LEFT);
		setStyle("-fx-background-color:MISTYROSE;");
		setPadding(new Insets(5,20,5,20));
		setSpacing(20);
		
		String url;
		switch(dessert.getName()) {
			case "Sweet Circle" : url = "Sweet Circle.jpg"; break;
			case "MO & MOSHI" : url = "MO & MOSHI.jpg"; break;
			case "Coffee Beans By Dao" : url = "Coffee Beans By Dao.jpg"; break;
			case "Creamery Boutique Ice Creams"	: url = "Creamery Boutique Ice Creams.jpg"; break;
			default : url = "After you Dessert Cafe.jpg";
		}
		
		ImageView img = new ImageView(new Image(ClassLoader.getSystemResource(url).toString()));
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
		
		Label name = new Label(dessert.getName());
		name.setFont(new Font(16));
		name.setMinWidth(200);
		
		Label location = new Label(" " +dessert.getLocation());
		location.setFont(new Font(12));
		
		Label queue = new Label(String.valueOf(dessert.getQueue()));
		queue.setFont(new Font(22));
		
		
		VBox vBox = new VBox(); 
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(name,location);
		
		getChildren().addAll(img,vBox,queue);
		
	}

}
