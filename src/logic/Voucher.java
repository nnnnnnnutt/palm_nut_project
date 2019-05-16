package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Voucher implements CsvAvailable{
	private String promoCode;	
	
	public Voucher(String promoCode) {
		this.promoCode = promoCode;
	}
	

	public String getPromoCode() {
		return promoCode;
	}


	@Override
	public String getCsv() {
		// TODO Auto-generated method stub
		return "Voucher.csv";
	}
	
	public ArrayList<Voucher> makeList() {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<Voucher> data = new ArrayList<Voucher>();
		try {
			InputStream in = ClassLoader.getSystemResourceAsStream(this.getCsv());
			br = new BufferedReader(new InputStreamReader(in));
			while ((line = br.readLine()) != null) {
				String[] csvdata = line.split(cvsSplitBy);
				// ----------------------
				String code = csvdata[0];
				Voucher newdata = new Voucher(code);
				data.add(newdata);
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
