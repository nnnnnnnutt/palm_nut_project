package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class HistoryPane extends HBox {

	public HistoryPane(Object history) {
		super(10);
		setPrefWidth(500);
		setPrefHeight(100);
		setAlignment(Pos.CENTER_LEFT);
		setStyle("-fx-background-color:BLANCHEDALMOND;");
		setPadding(new Insets(5,20,5,20));
		setSpacing(20);
		
		
		
		Label list = new Label(Main.controller.getHistory().toString());
		list.setFont(new Font(16));
		list.setMinWidth(200);
		
		
		VBox vBox = new VBox(); 
		vBox.setAlignment(Pos.TOP_LEFT);
		vBox.getChildren().addAll(list);
		
		getChildren().addAll(list);
		
	}
}