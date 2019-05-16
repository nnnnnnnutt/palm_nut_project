package logic;

import java.util.HashMap;
import java.util.Map;

public class VoucherInfo {
	private static Map<String, String> promoCode= new HashMap<>();
	
	public VoucherInfo(){
		promoCode.put("promo", "code10%");
		promoCode.put("resPromo", "drink50");
	}
	public static Map<String, String> getPromoCodes() {
		return promoCode;
	}
}
