package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class TablePane {
	private TextField numberOfPeople;
	private Label label;
	private Button button;
	private GridPane rootPane;
	private Scene tablePaneScene;
	
	public TextField getNumberOfPeople() {
		return numberOfPeople;
	}
	public GridPane getRootPane() {
		return rootPane;
	}
	public Scene getTablePaneScene() {
		return tablePaneScene;
	}
	public TablePane() {
		rootPane = new GridPane();
		rootPane.setAlignment(Pos.CENTER);
		rootPane.setHgap(10);
		rootPane.setVgap(10);
		rootPane.setPadding(new Insets(25, 25, 25, 25));
		rootPane.setStyle("-fx-background-color:BLANCHEDALMOND;");
		label = new Label("Number of people: ");
		numberOfPeople = new TextField();
		
		rootPane.add(label, 0, 1);
		rootPane.add(numberOfPeople, 1, 1);
		
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		button = new Button("OK");
		button.setPrefWidth(65);
		
		button.setOnAction(e->{
			DessertScreen des = new DessertScreen();
			Main.sceneController.changeScene(des.getDessertScreenScene());
		});

		hbBtn.getChildren().addAll(button);

		rootPane.add(hbBtn, 1, 4);
		tablePaneScene = new Scene(rootPane,700,500);
	}
	public String getNumberOfPeopleText() {
		return numberOfPeople.getText();
	}
	public void setNumberOfPeople(TextField numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	public Button getButton() {
		return button;
	}
	public void setButton(Button button) {
		this.button = button;
	}
	
	
	
}
