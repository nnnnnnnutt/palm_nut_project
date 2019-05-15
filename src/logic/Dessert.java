package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dessert extends IncludeImage implements CsvAvailable {
	
	private String name;
	private String location;
	private int queue;
	private String url;
	
	public Dessert() {
		super();
	}
	public Dessert(String name, String location, int queue,String url) {
		//super(location, location, queue);
		this.name = name;
		this.location = location;
		this.queue = queue;
		this.url = url;
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
	
	

	public String getUrl() {
		return url;
	}
	@Override
	public String getCsv() {
		// TODO Auto-generated method stub
		return "Dessert.csv";
	}
	
	public ArrayList<Dessert> makeList() {
		  BufferedReader br = null;
		  String line = "";
		  String cvsSplitBy = ",";
		  ArrayList<Dessert> data = new ArrayList<Dessert>();
		  try {
			  InputStream in = ClassLoader.getSystemResourceAsStream(this.getCsv());
		      br = new BufferedReader(new InputStreamReader(in));
		      while ((line = br.readLine()) != null) {
		          String[] csvdata = line.split(cvsSplitBy);
		          //----------------------
		    		  String name = csvdata[0];
		    		  String location = csvdata[1];
		    		  int queue = Integer.parseInt(csvdata[2]);
		    		  String url = csvdata[3];
		    		  Dessert newdata = new Dessert(name,location,queue,url);
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
