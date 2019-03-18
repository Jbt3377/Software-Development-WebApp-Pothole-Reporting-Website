package model;
import java.io.Serializable;
import java.util.ArrayList;

public class Report implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public String reportID;
	public String location;
	public String description;
	public Categories category;
	public String details;
	public String filePathToImage;

	public String usernameOfUserWhoReported;

}
