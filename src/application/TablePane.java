package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TablePane extends GridPane {
	private TextField numberOfPeople;
	private Label label;
	private Button button;
	
	
	
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
