package insulease.model;

import java.sql.Date;

 
public class ContactInfo {
	private int ContactInfoId;
	private String FirstName;
	private String LastName;
	private Date DOB;
	private String Street1;
	private String Street2;
	private String City;
	private String State;
	private int ZipCode;
	private String Email;
	private String Gender;
	private String ContactImage; //Needs to be updated to be compatible with BLOB data type
	
	/*
	 * Constructor that doesn't use auto-generated ContactInfoID
	 * NEED TO UPDATE ContactImage data type to be compatible with BLOB
	 */
	public ContactInfo (String FirstName, String LastName, Date DOB, String Street1, String Street2, 
			String City, String State, int ZipCode, String Email, String Gender, String ContactImage) {
		this.FirstName=FirstName;
		this.LastName=LastName;
		this.DOB=DOB;
		this.Street1=Street1;
		this.Street2=Street2;
		this.City=City;
		this.State=State;
		this.ZipCode=ZipCode;
		this.Email=Email;
		this.Gender=Gender;
		this.ContactImage=ContactImage;
	}
	
	/*
	 * Constructor that doesn't use auto-generated ContactInfoID
	 * NEED TO UPDATE ContactImage data type to be compatible with BLOB
	 */
	public ContactInfo (int ContactInfoId, String FirstName, String LastName, Date DOB, String Street1, String Street2, 
			String City, String State, int ZipCode, String Email, String Gender, String ContactImage) {
		this.ContactInfoId=ContactInfoId;
		this.FirstName=FirstName;
		this.LastName=LastName;
		this.DOB=DOB;
		this.Street1=Street1;
		this.Street2=Street2;
		this.City=City;
		this.State=State;
		this.ZipCode=ZipCode;
		this.Email=Email;
		this.Gender=Gender;
		this.ContactImage=ContactImage;
	}
	
	//Getters
	public String getFirstName() {return this.FirstName;}
	public String getLastName() {return this.LastName;}
	public Date getDOB() {return this.DOB;}
	public String getStreet1() {return this.Street1;}
	public String getStreet2() {return this.Street2;}
	public String getCity() {return this.City;} 
	public String getState() {return this.State;}
	public int getZipCode() {return this.ZipCode;}
	public String getEmail() {return this.Email;}
	public String getGender() {return this.Gender;}
	
	//Need Getter for ContactImage
	
	//Setters
	public void setStreet1(String newStreet1) {this.Street1=newStreet1;}
	public void setStreet2(String newStreet2) {this.Street2=newStreet2;}
	public void setCity(String newCity) {this.City=newCity;} 
	public void setState(String newState) {this.State=newState;}
	public void setZipCode(int newZipCode) {this.ZipCode=newZipCode;}
	public void setEmail(String newEmail) {this.Email=newEmail;}
	public void setGender(String newGender) {this.Gender=newGender;}
	
	//Need Setter for ContactImage
	

}
