package logic;

import java.util.ArrayList;

public class ApplicationLogic {
	private ArrayList<Dessert> allDesserts;

	
	
	
	public ApplicationLogic() {
		allDesserts = (new Dessert().makeList());
	}

	public ArrayList<Dessert> getAllDesserts() {
		return allDesserts;
	}

	public void setAllDesserts(ArrayList<Dessert> allDesserts) {
		this.allDesserts = allDesserts;
	}
	
}
