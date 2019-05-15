package logic;

import java.util.ArrayList;

public class Restaurant extends IncludeImage implements Discountable{
	private ArrayList<Restaurant> restaurant;
	private int queue;
	private String name;
	private String location;
	private boolean isWaiting = false;

	public Restaurant() {
		super();
	}
	public Restaurant(String name, String location, int queue) {
		
		this.name = name;
		this.location = location;
		this.queue = queue;
		
	}
	

	public ArrayList<Restaurant> getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(ArrayList<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}

	public int getQueue() {
		return queue;
	}

	public void setQueue(int queue) {
		this.queue = queue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public boolean isWaiting() {
		return isWaiting;
	}
	public void setWaiting(boolean isWaiting) {
		if(getQueue() > 0) {
			this.isWaiting = true;
		}
		else {
			this.isWaiting = false;
		}
	}
	@Override
	public void discount() {
		// TODO Auto-generated method stub
		
	}	
	

}
