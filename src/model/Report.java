package model;
import java.io.Serializable;
import java.util.ArrayList;

public class Report implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public String reportID;
	
	// Attributes derived from form
	public String location;
	public String description;
	public Categories category;
	public String details;
	public String filePathToImage;
	
	// Auto handled variables
	public String usernameOfUserWhoReported, timeStamp;
	public boolean isSolved;


}
