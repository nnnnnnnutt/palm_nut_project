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
import logic.ALaCarte;

public class ALaCartePane extends HBox {

	public ALaCartePane(ALaCarte ala) {
		super(10);
		setPrefWidth(500);
		setPrefHeight(100);
		setAlignment(Pos.CENTER_LEFT);
		setStyle("-fx-background-color:BLANCHEDALMOND;");
		setPadding(new Insets(5,20,5,20));
		setSpacing(20);
		
		String url;
		switch(ala.getName()) {
			case "Marugame Seimen" : url = "Marugame Seimen.jpg"; break;
			case "SEEFAH" : url = "SEEFAH.jpg"; break;
			case "Shinkanzen Sushi" : url = "Shinkanzen Sushi.jpg"; break;
			case "The Bibimbab"	: url = "The Bibimbab.jpg"; break;
			default : url = "Cafe Pla.jpg";
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
		
		Label name = new Label(ala.getName());
		name.setFont(new Font(16));
		name.setMinWidth(200);
		
		Label location = new Label(" " +ala.getLocation());
		location.setFont(new Font(12));
		
		Label queue = new Label(String.valueOf(ala.getQueue()));
		queue.setFont(new Font(22));
		
		
		VBox vBox = new VBox(); 
		vBox.setAlignment(Pos.TOP_LEFT);
		vBox.getChildren().addAll(name,location);
		
		getChildren().addAll(img,vBox,queue);
		
	}
}