package insulease.model;
/*
 * DrID INT AUTO_INCREMENT,
    FirstName VARCHAR (255),
    LastName VARCHAR (255),
    Street1 VARCHAR (255),
    Street2 VARCHAR (255),
    City VARCHAR (255),
    State VARCHAR (255),
    ZipCode INT,
    AffiliatedInstitution VARCHAR(255),
 */
public class Drs {
	private int DrID;
	private String FirstName;
	private String LastName;
	private String Street1;
	private String Street2;
	private String City;
	private String State;
	private int ZipCode;
	private String AffiliatedInstitution;
	
	/*
	 * Constructor
	 */
	public Drs (int DrID, String FirstName, String LastName, String City, String State, int ZipCode, String AffiliatedInstitution) {
		this.DrID=DrID;
		this.FirstName=FirstName;
		this.LastName=LastName;
		this.City=City;
		this.State=State;
		this.ZipCode=ZipCode;
		this.AffiliatedInstitution=AffiliatedInstitution;
	}
	
	//Getters 
	public int getDrID() {return this.DrID;}
	public String getFirstName() {return this.FirstName;}
	public String getLastName() {return this.LastName;}
	public String getStreet1() {return this.Street1;}
	public String getStreet2() {return this.Street2;}
	public String getCity() {return this.City;}
	public String getState() {return this.State;}
	public int getZipCode() {return this.ZipCode;}
	public String getAffiliatedInstitutionD() {return this.AffiliatedInstitution;}
	
	
	//Setters 
	public void setStreet1(String newStreet1) { this.Street1=newStreet1;}
	public void setStreet2(String newStreet2) {this.Street2=newStreet2;}
	public void setCity(String newCity) { this.City = newCity;}
	public void setState(String newState) { this.State = newState;}
	public void setZipCode(int newZipCode) { this.ZipCode = newZipCode;}
	public void setAffiliatedInstitutionD(String newAffiliatedInstitution) { this.AffiliatedInstitution = newAffiliatedInstitution;}

}
