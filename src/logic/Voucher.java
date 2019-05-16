package logic;

import application.Main;

public class Voucher {
	private String promoCode;
	private int percent;
	private String description;
	private int uses;
	private int type;
	
	public Voucher(
			String promoCode, 
			int percent, 
			String description,
			int uses,
			int type
		) {
		this.promoCode = promoCode;
		this.percent = percent;
		this.description = description;
		this.uses = uses;
		this.type = type;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public int getPercent() {
		return percent;
	}

	public String getDescription() {
		return description;
	}

	public int getUses() {
		return uses;
	}

	public int getType() {
		return type;
	}
	
	public boolean use(Object o) {
		if ( this.uses <= 0) return false;
		if (o instanceof Discountable) {
			Discountable d = (Discountable) o;
			// Check type
			boolean valid = false;
			if (d instanceof Accommodation && this.type == 2) {
				valid = true;
			} else if (d instanceof Buffet && this.type == 0) {
				valid = true;
			} else if (d instanceof Car && this.type == 3) {
				valid = true;
			}
			
			if (valid) d.discount(this.percent);
			else return false;
		} else {
			// Type 1 can only be used with a la carte
			if (this.type != 1) {
				return false;
			}
		}

		this.uses -= 1;
		Main.controller.addToHistory(this);
		return true;
	}
	
}
