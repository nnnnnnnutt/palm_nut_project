package application;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logic.User;

public class Controller {
	private User currentUser;
	private boolean isSignedIn = false;

	public UserInfo userInfo;

	private static Thread thread;
	public static boolean alertcheck = false;

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
		startThread();
	}

	public boolean getSignedIn() {
		return this.isSignedIn;
	}

	public static void startThread() {
		thread = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(600000);
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							try {
								if (!alertcheck) {
									Alert alert = new Alert(AlertType.ERROR);
									alert.setTitle("Out of Time");
									alert.setContentText(
											"You have stayed in the page for 10 minutes without doing anything." + "\n"
													+ "Please sign in again.");
									alert.showAndWait().ifPresent(type -> {
										SignInPane signIn = new SignInPane();
										Main.sceneController.changeScene(signIn.getSignInScene());
									});
									alertcheck = true;
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();

				}
			}

		});
		thread.start();
	}

	public static void stopThread() {
		thread.interrupt();
	}

}
