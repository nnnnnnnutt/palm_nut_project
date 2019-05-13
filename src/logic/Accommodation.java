package logic;

public class Accommodation implements Reservable,CsvAvailable {

	@Override
	public String getCsv() {
		// TODO Auto-generated method stub
		return "accommodation.csv";
	}

	@Override
	public void reserve() {
		// TODO Auto-generated method stub
		
	}

}
