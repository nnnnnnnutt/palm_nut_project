package logic;

import java.util.ArrayList;

public class ApplicationLogic {
	private ArrayList<Dessert> allDesserts;
	private ArrayList<Buffet> allBuffets;
	private ArrayList<ALaCarte> allALaCartes;
	
	
	
	public ApplicationLogic() {
		allDesserts = (new Dessert().makeList());
		allBuffets = (new Buffet().makeList());
		allALaCartes = (new ALaCarte().makeList());
	}

	public ArrayList<Dessert> getAllDesserts() {
		return allDesserts;
	}

	public void setAllDesserts(ArrayList<Dessert> allDesserts) {
		this.allDesserts = allDesserts;
	}

	public ArrayList<Buffet> getAllBuffets() {
		return allBuffets;
	}

	public void setAllBuffets(ArrayList<Buffet> allBuffets) {
		this.allBuffets = allBuffets;
	}

	public ArrayList<ALaCarte> getAllALaCartes() {
		return allALaCartes;
	}

	public void setAllALaCartes(ArrayList<ALaCarte> allALaCartes) {
		this.allALaCartes = allALaCartes;
	}
	
	
	
	
}
