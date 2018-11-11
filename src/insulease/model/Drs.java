package insulease.model;

public class Drs {
	private int DrID;
	private ContactInfo ContactInfo;
	private String AffiliatedInstitution;
	
	/*
	 * Constructor
	 */
	public Drs (int DrID, ContactInfo ContactInfo, String AffiliatedInstitution) {
		this.DrID=DrID;
		this.ContactInfo = ContactInfo;
		this.AffiliatedInstitution=AffiliatedInstitution;
	}
	
	public Drs (ContactInfo ContactInfo, String AffiliatedInstitution) {
		this.ContactInfo = ContactInfo;
		this.AffiliatedInstitution=AffiliatedInstitution;
	}
	
	//Getters 
	public int getDrID() {return this.DrID;}
	public ContactInfo getContactInfo() {return this.ContactInfo;}
	public String getAffiliatedInstitutionD() {return this.AffiliatedInstitution;}
	
	
	//Setters 
	public void setAffiliatedInstitutionD(String newAffiliatedInstitution) { this.AffiliatedInstitution = newAffiliatedInstitution;}
	public void setDrID (int DrID) {this.DrID = DrID;}

}
