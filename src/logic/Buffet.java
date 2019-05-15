package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Buffet extends IncludeImage implements CsvAvailable {
	
	private String name;
	private String location;
	private int queue;
	private int price;
	
	
	public Buffet() {
		super();
	}
	public Buffet(String name, String location, int queue,int price) {
		//super(location, location, queue);
		this.name = name;
		this.location = location;
		this.queue = queue;
		this.price = price;
		try {
			setImage(getName()+".jpg");
		} catch (NullPointerException e) {
            setImagetoBasic();
		}
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public int getQueue() {
		return queue;
	}
	
	

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setQueue(int queue) {
		this.queue = queue;
	}
	@Override
	public String getCsv() {
		// TODO Auto-generated method stub
		return "Buffet.csv";
	}
	
	public ArrayList<Buffet> makeList() {
		  BufferedReader br = null;
		  String line = "";
		  String cvsSplitBy = ",";
		  ArrayList<Buffet> data = new ArrayList<Buffet>();
		  try {
			  InputStream in = ClassLoader.getSystemResourceAsStream(this.getCsv());
		      br = new BufferedReader(new InputStreamReader(in));
		      while ((line = br.readLine()) != null) {
		          String[] csvdata = line.split(cvsSplitBy);
		          //----------------------
		    		  String name = csvdata[0];
		    		  String location = csvdata[1];
		    		  int queue = Integer.parseInt(csvdata[2]);
		    		 // int price = Integer.parseInt(csvdata[3]);
		    		  Buffet newdata = new Buffet(name,location,queue,price);
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
