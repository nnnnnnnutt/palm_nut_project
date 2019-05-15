package application;

import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import logic.SignIn;
import logic.User;

public class SignInPane {
	private Scene signInScene;

	private GridPane rootPane;
	private TextField userTextField;
	private PasswordField pwBox;
	private Button signInBtn;
	private Button signUpBtn;
	
	private SignIn signInLogic = new SignIn();

	public SignInPane() {
		rootPane = new GridPane();
		rootPane.setAlignment(Pos.CENTER);
		rootPane.setHgap(10);
		rootPane.setVgap(10);
		rootPane.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("LOGO");
		rootPane.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("Username:");
		rootPane.add(userName, 0, 1);

		userTextField = new TextField();
		rootPane.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		rootPane.add(pw, 0, 2);

		pwBox = new PasswordField();
		rootPane.add(pwBox, 1, 2);

		// add signInBtn and signUpBtn
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		signInBtn = new Button("Sign in");
		signInBtn.setPrefWidth(65);
		signUpBtn = new Button("Sign up");
		signUpBtn.setPrefWidth(65);
		hbBtn.getChildren().addAll(signInBtn, signUpBtn);

		rootPane.add(hbBtn, 1, 4);
		rootPane.setPrefSize(700, 500);

		signInScene = new Scene(rootPane, 700, 500);

		// set style
		rootPane.setStyle("-fx-background-color:BLANCHEDALMOND;");
		scenetitle.setStyle("-fx-font-size: 32px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
//		signInBtn.setStyle(
//				"-fx-text-fill: black; -fx-font-weight: bold; -fx-font-family: \"Arial Narrow\"; -fx-background-color: LEMONCHIFFON;");
//		signUpBtn.setStyle(
//				"-fx-text-fill: black; -fx-font-weight: bold; -fx-font-family: \"Arial Narrow\"; -fx-background-color: LEMONCHIFFON;");

		// add handler
		// press ESC to clear user text field
		userTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.ESCAPE) {
					userTextField.setText("");
				}
			}
		});

		// change button width when mouse over
		signInBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				signInBtn.setPrefWidth(75);
			}
		});
		signInBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				signInBtn.setPrefWidth(65);
			}
		});
		signUpBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				signUpBtn.setPrefWidth(75);
			}
		});
		signUpBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				signUpBtn.setPrefWidth(65);
			}
		});

		HomePane home = new HomePane();
		// action when click button
		signInBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {	
					Map<String, String> userDetails = signInLogic.signIn(getUserTextField(), getPwBoxText());
					System.out.println("Login Success");
					Main.controller.setCurrentUser(new User(userDetails));
					Main.sceneController.changeScene(home.getHomeScene());
				} catch (Exception e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("Login failed");
					alert.show();
				}
			}
		});
		signUpBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// change to signUp scene
				SignUpPane signUp = new SignUpPane();
				Main.sceneController.changeScene(signUp.getSignUpscene());
			}

		});
	}

	public String getUserTextField() {
		return userTextField.getText();
	}

	public String getPwBoxText() {
		return pwBox.getText();
	}

	public GridPane getRootPane() {
		return rootPane;
	}

	public Scene getSignInScene() {
		return signInScene;
	}

	public Button getSignInBtn() {
		return signInBtn;
	}

	public Button getSignUpBtn() {
		return signUpBtn;
	}

}
