
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

public class VoucherPane {
	private Scene VoucherPane;
	private VBox rootPane;
	private ImageView discountBtn;
	private ImageView freeBtn;
	private ImageView homeBtn;
	private ImageView signOutBtn;

	public VoucherPane() {
		rootPane = new VBox(70);
		rootPane.setPadding(new Insets(25, 25, 25, 25));
		rootPane.setStyle("-fx-background-color:BLANCHEDALMOND;");

		VBox time = new VBox(15);
		time.setAlignment(Pos.CENTER_LEFT);
		DigitalClock clock = new DigitalClock();
		Label date = new Label(new Date().toString().substring(0, 10));
		time.getChildren().addAll(date, clock);

		rootPane.getChildren().add(time);

		GridPane menu = new GridPane();
		menu.setAlignment(Pos.CENTER);
		menu.setHgap(55);
		menu.setVgap(15);

		discountBtn = new ImageView(new Image(ClassLoader.getSystemResource("discount.png").toString()));
		discountBtn.setFitHeight(100);
		discountBtn.setFitWidth(100);

		discountBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		discountBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});

		freeBtn = new ImageView(new Image(ClassLoader.getSystemResource("juice.png").toString()));
		freeBtn.setFitHeight(100);
		freeBtn.setFitWidth(100);

		freeBtn.setOnMouseEntered(e -> {
			rootPane.setCursor(Cursor.HAND);
		});
		freeBtn.setOnMouseExited(e -> {
			rootPane.setCursor(Cursor.DEFAULT);
		});

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
		Label acc = new Label("code: may10%");

		Label res = new Label("code: drink50");


		menu.add(discountBtn, 0, 0);
		menu.add(acc, 1, 0);
		menu.add(freeBtn, 0, 1);
		menu.add(res, 1, 1);

		rootPane.getChildren().add(menu);

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

		rootPane.getChildren().add(hbBtn);

		VoucherPane = new Scene(rootPane, 700, 500);

	}

	public Scene getVoucherPaneScene() {
		return VoucherPane;
	}

	public VBox getRootPane() {
		return rootPane;
	}
}
