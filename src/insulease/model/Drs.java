package insulease.model;

public class Drs {
	private int DrID;
	private int ContactInfoID;
	private String AffiliatedInstitution;
	
	/*
	 * Constructor
	 */
	public Drs (int DrID, int ContactInfoID, String AffiliatedInstitution) {
		this.DrID=DrID;
		this.ContactInfoID = ContactInfoID;
		this.AffiliatedInstitution=AffiliatedInstitution;
	}
	
	//Getters 
	public int getDrID() {return this.DrID;}
	public int getContactInfoID() {return this.ContactInfoID;}
	public String getAffiliatedInstitutionD() {return this.AffiliatedInstitution;}
	
	
	//Setters 
	public void setAffiliatedInstitutionD(String newAffiliatedInstitution) { this.AffiliatedInstitution = newAffiliatedInstitution;}

}
