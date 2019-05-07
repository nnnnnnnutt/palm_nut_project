package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class User {
//	private static Path path = Paths.get("User.csv");
	private static String username;
	private static String password;
	private Map<String, String> userInfo = new HashMap<String, String>();
//	private Map<String, String> profile = new HashMap<String, String>();

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getCsv() {
		return "Users.csv";
	}

	public Map<String, String> makeList() {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		//ArrayList<User> data = new ArrayList<User>();
		try {
			InputStream in = ClassLoader.getSystemResourceAsStream(this.getCsv());
			br = new BufferedReader(new InputStreamReader(in));
			while ((line = br.readLine()) != null) {
				String[] csvdata = line.split(cvsSplitBy);
				String username = csvdata[0];
				String password = csvdata[1];
				
				userInfo.put(username, password);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(userInfo);
		return userInfo;
	}

	public Map<String, String> getUserInfo() {
		return userInfo;
	}
	
	
}
