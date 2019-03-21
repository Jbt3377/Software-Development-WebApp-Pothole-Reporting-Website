package model;
import java.io.Serializable;

public class Profile implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public String filePathToProfilePicture;
	public String name;
	public String username;
	public String email;
	public String password;
	public String address;
	public int numOfReports;
}
