package logic;

public class Restaurant implements Reservable,CsvAvailable{

	@Override
	public String getCsv() {
		// TODO Auto-generated method stub
		return "restaurant.csv";
	}

	@Override
	public void reserve() {
		// TODO Auto-generated method stub
		
	}

}
