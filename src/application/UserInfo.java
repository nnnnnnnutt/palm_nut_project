package application;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserInfo {
	private Map<String, Map<String, String>> Users;
	
	public UserInfo() {
		Map<String, Map<String, String>> profiles = new HashMap<>();
		
		Map<String, String> details = new HashMap<>();
		details.put("password", "nnut98");
		details.put("name", "Pimkunut");
		details.put("lastName","Theerathitayankul");
		
		profiles.put("nnut98", details);
		
		Map<String, String> other = new HashMap<>();
		other.put("password", "palm");
		other.put("name", "Palmmanee");
		other.put("lastName","Kaitao");
		
		profiles.put("palm", other);
		
		Users = Collections.unmodifiableMap(profiles);
	}
	
	//getters & setters
	public Map<String, Map<String, String>> getUsers() {
		return Users;
	}
}
