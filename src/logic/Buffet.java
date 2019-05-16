package logic;

public class Buffet extends Restaurant implements Discountable {

	private int price;
	private int discount = 0;
	
	public Buffet(String name, String location, int queue, int price, String url) {
		super(name, location, queue, url);
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}
	
	public int getDiscount() {
		return this.discount;
	}
	
	@Override
	public boolean discount(int amount) {
		// TODO Auto-generated method stub
		if (amount >= 0) {
			this.discount = amount;
		}
		return true;
	}	
}
