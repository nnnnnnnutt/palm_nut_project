
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.Voucher;

public class VoucherPane extends HBox {
	
	public VoucherPane(Voucher v) {
		super(10);
		setPrefWidth(500);
		setPrefHeight(100);
		setAlignment(Pos.CENTER_LEFT);
		setStyle("-fx-background-color:BLANCHEDALMOND;");
		setPadding(new Insets(5,20,5,20));
		setSpacing(20);
		
		
		ImageView img = new ImageView(new Image(ClassLoader.getSystemResource("discount.png").toString()));
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
		});
		
		Button btn = new Button("Use");
		btn.setOnAction(e->{
			Main.controller.setCurrentVoucher(v);
			Voucher currentVoucher = Main.controller.getCurrentVoucher();
			if (currentVoucher != null) {
				VBox vouBox = new VBox(15);
				Label vou = new Label(currentVoucher.getPromoCode());
				vouBox.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
				vouBox.getChildren().add(vou);
				getChildren().addAll(vouBox);
			}
		});
		
		Label name = new Label(v.getPromoCode());
		name.setFont(new Font(16));
		name.setMinWidth(200);
		
		Label description = new Label(v.getDescription());
		description.setFont(new Font(12));
		
		
		
		VBox vBox = new VBox(); 
		vBox.setAlignment(Pos.TOP_LEFT);
		vBox.getChildren().addAll(name,description);
		
		getChildren().addAll(img,vBox);
	}
}
