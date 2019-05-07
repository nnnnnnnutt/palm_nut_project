package logic;

import java.util.Map;

import application.Main;

public class SignIn {
	public Map<String, String> signIn(String username, String password) throws Exception {
		boolean check = this.check(username, password);
		if (!check) {
			throw new Exception("Login failed.");
		}
		return this.getSingleUser(username);
	}
	
	private Map<String, String> getSingleUser(String username) {
		Map<String, String> userDetails = Main.controller.getUserInfo().getUsers().get(username);
		userDetails.put("username", username);
		return userDetails;
	}

	private boolean check(String username, String password) {
		if (!Main.controller.getUserInfo().getUsers().containsKey(username)) {
			return false;
		}
		
		String correctPassword = Main.controller.getUserInfo().getUsers().get(username).get("password");
		
		if (password.equals(correctPassword)) return true;
		else return false;
	}
	
	
}
