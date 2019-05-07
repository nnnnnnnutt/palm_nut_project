package logic;

import java.util.Map;

public class User {
	private String username;
	private String password;
	private String name;
	private String lastName;

	public User(Map<String, String> userDetails) {
		this.username = userDetails.get("username");
		this.password = userDetails.get("password");
		this.name = userDetails.get("name");
		this.lastName = userDetails.get("lastName");
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	
	
	
}
