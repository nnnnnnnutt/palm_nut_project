package logic;

import application.Main;

public class Restaurant {
	private int queue;
	private String name;
	private String location;
	private String url;
	private boolean isInLine;

	public Restaurant() {
		super();
	}
	public Restaurant(String name, String location, int queue, String url) {
		this.name = name;
		this.location = location;
		this.queue = queue;
		this.url = url;
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
	public String getLocation() {
		return location;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public boolean getIsInLine() {
		return this.isInLine;
	}
	public void setIsInLine(boolean isInLine) {
		this.isInLine = isInLine;
		if (isInLine) {
			Main.controller.addToHistory(this);
		} else {
			Main.controller.addToHistory(this);
		}
	}
	
	public boolean isWaiting() {
		return this.getQueue() > 0;
	}

}
