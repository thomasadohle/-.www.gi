package insulease.model;



public class Users {
	private String UserName;
	private String UserPassword;
	private int ContactInfoId;
	
	/*
	 * Constructor
	 */
	public Users (String UserName, String UserPassword, int ContactInfoId) {
		this.UserName=UserName;
		this.UserPassword=UserPassword;
		this.ContactInfoId=ContactInfoId;
	}
	
	
	//Getters
	public String getUserName() {return this.UserName;}
	public String getUserPassword() {return this.UserPassword;}
	public int getContactInfoId() {return this.ContactInfoId;}
	
	//Setters
	public void setUserPassword(String newUserPassword) {this.UserPassword=newUserPassword;}
	
	
}
