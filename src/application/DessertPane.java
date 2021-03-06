package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import logic.ALaCarte;
import logic.Restaurant;

public class DessertPane extends HBox {

	public DessertPane(ALaCarte dessert) {
		super(10);
		setPrefWidth(700);
		setPrefHeight(100);
		setAlignment(Pos.CENTER_LEFT);
		setStyle("-fx-background-color:BLANCHEDALMOND;");
		setPadding(new Insets(5,20,5,20));
		setSpacing(20);
		
		ImageView img = new ImageView(new Image(ClassLoader.getSystemResource((dessert.getUrl())+".jpg").toString()));
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
//			TablePane table = new TablePane();
//			Main.sceneController.changeScene(table.getTablePaneScene());
			Restaurant res = new Restaurant();
			if(!res.isWaiting()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("Yeah");
				alert.show();
			}
		});

		
		Label name = new Label(dessert.getName());
		name.setFont(new Font(16));
		name.setMinWidth(200);
		
		Label location = new Label(" " +dessert.getLocation());
		location.setFont(new Font(12));
		
		Label queue = new Label(String.valueOf(dessert.getQueue()));
		queue.setFont(new Font(22));
		
		
		VBox vBox = new VBox(); 
		vBox.setAlignment(Pos.TOP_LEFT);
		vBox.setPrefWidth(250);
		vBox.getChildren().addAll(name,location);
		
		getChildren().addAll(img,vBox,queue);
		
	}
	
}
