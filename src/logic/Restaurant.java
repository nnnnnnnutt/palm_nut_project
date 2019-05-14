//package logic;
//
//import java.util.ArrayList;
//
//import javafx.application.Platform;
//
//public class Restaurant extends IncludeImage implements Reservable{
//	private ArrayList<Restaurant> restaurant;
//	private int queue;
//	private String name;
//	private String location;
//	private boolean isReserved = false;
//
//	public Restaurant() {
//		super();
//	}
//	public Restaurant(String name, String location, int queue) {
//		
//		this.name = name;
//		this.location = location;
//		this.queue = queue;
//		initialise();
//		
//	}
//	
//	public ArrayList<Restaurant> initialise(){
//		restaurant = new ArrayList<Restaurant>();
//		Restaurant res = new Restaurant(name, location, queue);
//		restaurant.add(res);
//		return restaurant;
//	}
//	
////	public boolean CheckIfEmpty(ArrayList<Restaurant> restaurant) {
////		if(queue > 0) {
////			return false;
////		}
////		return true;
////	}
//
//
//
//	@Override
//	public void reserve() {
//		// TODO Auto-generated method stub
//		if(queue == 0) {
//			isReserved = true;
//		}
//		else {
//			isReserved = false;
//			Thread thread = new Thread(new Runnable() {
//
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					try {
//						Thread.sleep(1000);
//					}
//					catch(InterruptedException e){
//						
//					}
//					Platform.runLater(new Runnable() {
//
//						@Override
//						public void run() {
//							// TODO Auto-generated method stub
//							queue--;
//						}
//						
//					});
//				}
//				
//			});
//		}
//		
//	}
//
//	public ArrayList<Restaurant> getRestaurant() {
//		return restaurant;
//	}
//
//	public void setRestaurant(ArrayList<Restaurant> restaurant) {
//		this.restaurant = restaurant;
//	}
//
//	public int getQueue() {
//		return queue;
//	}
//
//	public void setQueue(int queue) {
//		this.queue = queue;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}
//	
//	
//	
//
//}
