package logic;

import javafx.scene.image.Image;

public abstract class IncludeImage {
	private static final String noimage = "NoImageAvailable.png";
	private String imagename;
	private Image image;
		
	public void setImagePath(String imagename) {
		this.imagename = imagename;
	}
	
	public void setImagetoBasic() {
		setImage(noimage);
	}

	public Image getImage() {
		return image;
	}
	
	public String getImagename() {
		return imagename;
	}

	public void setImage(String imagename) {
		this.imagename = imagename;
		this.image = new Image(ClassLoader.getSystemResource(imagename).toString());
		if(this.image == null) {
			this.image = new Image(ClassLoader.getSystemResource(noimage).toString());
		}
	}
	
}