package logic;

public class Buffet extends Restaurant {

	private int price;
	
	public Buffet(String name, String location, int queue, int price, String url) {
		super(name, location, queue, url);
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}
}
