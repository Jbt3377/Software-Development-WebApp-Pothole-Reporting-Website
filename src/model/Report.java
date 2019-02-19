package model;
import java.io.Serializable;
import java.util.ArrayList;

public class Report implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public String description;
	public String details;
	public ProblemType type;
	public String filePathToImage;
	public ArrayList<String> reports = new ArrayList<String>();
	

}
