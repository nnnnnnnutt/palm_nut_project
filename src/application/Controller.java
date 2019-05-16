package application;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import logic.CSVLogic;
import logic.User;
import logic.Voucher;

public class Controller {
	private User currentUser;
	private Voucher voucher;
	private boolean isSignedIn = false;
	public CSVLogic data = new CSVLogic();
	
	private ArrayList<Object> history;

	public UserInfo userInfo;

	private static Thread thread;
	public static boolean alertcheck = false;

	public Controller() {
		this.userInfo = new UserInfo();
		this.history = new ArrayList<Object>();
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
		if(signedIn) {
			startThread();
		}
	}

	public boolean getSignedIn() {
		return this.isSignedIn;
	}

	public static void startThread() {
		thread = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(1000);
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
	
	public void addToHistory(Object o) {
		history.add(o);
	}
	public ArrayList<Object> getHistory() {
		return this.history;
	}
	public void removeFromHistory(Object o) {
		history.remove(o);
	}
	

	public Voucher getVoucher() {
		return voucher;
	}

	public static void stopThread() {
		thread.interrupt();
	}

}
