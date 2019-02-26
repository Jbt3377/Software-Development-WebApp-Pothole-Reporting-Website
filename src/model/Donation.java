package model;

import java.util.ArrayList;

public class Donation extends SmartSerializable
{
	private static final long serialVersionUID = 1L;
	
	public String name;
	public String amount;
	public ArrayList<String> donator = new ArrayList<String>();

}