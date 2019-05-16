package logic;

import application.Main;

public class Accommodation extends ForReserve implements Discountable {
	private int rating;
	private String location;
	private String info;

	private int discount = 0;
	private int totalRooms;
	private int reservedRooms;
	
	public Accommodation(
			String name, 
			int price, 
			String url,
			int rating, 
			String location, 
			String info,
			int totalRooms,
			int reservedRooms
		) {
		this.name = name;
		this.price = price;
		this.url = url;
		this.rating = rating;
		this.location = location;
		this.info = info;
		this.totalRooms = totalRooms;
		this.reservedRooms = reservedRooms;
	}

	public boolean reserve(int amount, int duration) {
		// TODO Auto-generated method stub
		if (duration > 0 && duration <= 7 && canReserve(amount)) {
			this.reserveDuration = duration;
			setReservedRooms(this.reservedRooms + amount);
			Main.controller.addToHistory(this);
			return true;
		}
		return false;
	}

	private boolean canReserve(int amount) {
		return this.reservedRooms + amount < this.totalRooms;
	}

	public boolean cancel(int amount) {
		setReservedRooms(this.reservedRooms - amount);
		Main.controller.removeFromHistory(this);
		return true;
	}

	@Override
	public boolean discount(int amount) {
		// TODO Auto-generated method stub
		setDiscount(amount);
		return true;
	}

	public int getRating() {
		return rating;
	}

	public String getLocation() {
		return location;
	}
	public String getInfo() {
		return info;
	}

	public int getDiscount() {
		return discount;
	}

	public int getTotalRooms() {
		return totalRooms;
	}

	public int getReservedRooms() {
		return reservedRooms;
	}

	private void setDiscount(int discount) {
		this.discount = discount;
		if (discount >= 0) {
			this.discount = discount;
		}
	}

	private void setReservedRooms(int reservedRooms) {
		this.reservedRooms = reservedRooms;
		if (reservedRooms <= this.totalRooms) {
			this.reservedRooms = reservedRooms;
		}
	}

}
