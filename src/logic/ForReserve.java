package logic;

public abstract class ForReserve {
	public abstract boolean reserve(int amount, int duration);
	public abstract boolean cancel(int amount);
	
	protected String name;
	protected int price;
	protected String url;
	protected int reserveDuration;
	
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public String getUrl() {
		return this.url;
	}
}
