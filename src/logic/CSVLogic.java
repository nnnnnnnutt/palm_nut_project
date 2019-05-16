package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CSVLogic {
	private ArrayList<Object> allDesserts;
	private ArrayList<Object> allBuffets;
	private ArrayList<Object> allALaCartes;
	private ArrayList<Object> allCars;

	public CSVLogic() {
		allDesserts = this.makeList("dessert");
		allBuffets = this.makeList("buffet");
		allALaCartes = this.makeList("alacarte");
		allCars = this.makeList("car");
	}

	public ArrayList<Object> getAllDesserts() {
		return allDesserts;
	}

	public ArrayList<Object> getAllBuffets() {
		return allBuffets;
	}

	public ArrayList<Object> getAllALaCartes() {
		return allALaCartes;
	}
	public ArrayList<Object> getAllCars() {
		return allCars;
	}

	private ArrayList<Object> makeList(String type) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<Object> data = new ArrayList<Object>();

		String fileName = new String();
		switch (type) {
		case "dessert":
			fileName = "Dessert.csv";
			break;
		case "alacarte":
			fileName = "ALaCarte.csv";
			break;
		case "buffet":
			fileName = "Buffet.csv";
			break;
		case "car":
			fileName = "Car.csv";
			break;
		default:
			return data;
		}

		try {
			InputStream in = ClassLoader.getSystemResourceAsStream(fileName);
			br = new BufferedReader(new InputStreamReader(in));
			while ((line = br.readLine()) != null) {
				String[] csvdata = line.split(cvsSplitBy);

				String name = new String();
				String location = new String();
				String url = new String();
				int queue = 0;
				int price = 0;
				Object newdata;

				String licensePlate = new String();

				switch (type) {
				case "dessert":
				case "alacarte":
					name = csvdata[0];
					location = csvdata[1];
					queue = Integer.parseInt(csvdata[2]);
					url = csvdata[3];
					newdata = new ALaCarte(name, location, queue, url);
					data.add(newdata);
					break;
				case "buffet":
					name = csvdata[0];
					location = csvdata[1];
					queue = Integer.parseInt(csvdata[2]);
					url = csvdata[3];
					price = Integer.parseInt(csvdata[4]);
					newdata = new Buffet(name, location, queue, price, url);
					data.add(newdata);
					break;
				case "car":
					name = csvdata[0];
					licensePlate = csvdata[1];
					url = csvdata[2];
					price = Integer.parseInt(csvdata[3]);
					newdata = new Car(name, price, url, licensePlate, false);
					data.add(newdata);
					break;
				default:
					return data;
				}
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
		return data;
	}

}
