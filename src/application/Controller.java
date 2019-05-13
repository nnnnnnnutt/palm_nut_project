package application;

import logic.User;

public class Controller {
	private User currentUser;
	private boolean isSignedIn = false;
	
	public UserInfo userInfo;
	
	public Controller() {
		this.userInfo = new UserInfo();
	}
	
	public void setCurrentUser(User user) {
		this.currentUser = user;
	}
	public User getCurrentUser() {
		return this.currentUser;
	}
	
	public UserInfo getUserInfo() {
		return this.userInfo;
	}
	
	public void setSignedIn(boolean signedIn) {
		this.isSignedIn = signedIn;
	}
	public boolean getSignedIn() {
		return this.isSignedIn;
	}
	
	
}
