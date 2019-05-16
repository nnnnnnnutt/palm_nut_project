package logic;

import application.Main;

public class Car extends ForReserve implements Discountable {
	private String licensePlate;
	private boolean isReserved;
	
	private int discount = 0;
	
	public Car(
			String name, 
			int price, 
			String url,
			String licensePlate,
			boolean isReserved
		) {
		this.name = name;
		this.price = price;
		this.url = url;
		this.licensePlate = licensePlate;
		this.isReserved = isReserved;
	}
	
	public String getLicensePlate() {
		return this.licensePlate;
	}
	
	public int getDiscount() {
		return this.discount;
	}
	
	public boolean getIsReserved() {
		return this.isReserved;
	}

	@Override
	public boolean discount(int amount) {
		if (amount >= 0) this.discount = amount;
		return true;
	}

	@Override
	public boolean reserve(int amount, int duration) {
		this.isReserved = true;
		if (duration > 0 && duration <= 7) {
			this.reserveDuration = duration;
			Main.controller.addToHistory(this);
		}
		return true;
	}

	@Override
	public boolean cancel(int amount) {
		this.isReserved = false;
		Main.controller.removeFromHistory(this);
		return true;
	}
	
}
