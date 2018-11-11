package insulease.model;



public class Users {
	private String UserName;
	private String UserPassword;
	private ContactInfo contactInfo;
	
	/*
	 * Constructor
	 */
	public Users (String UserName, String UserPassword, ContactInfo contactInfo) {
		this.UserName=UserName;
		this.UserPassword=UserPassword;
		this.contactInfo=contactInfo;
	}
	
	
	//Getters
	public String getUserName() {return this.UserName;}
	public String getUserPassword() {return this.UserPassword;}
	public ContactInfo getContactInfo() {return this.contactInfo;}
	
	//Setters
	public void setUserPassword(String newUserPassword) {this.UserPassword=newUserPassword;}
	
	
}
