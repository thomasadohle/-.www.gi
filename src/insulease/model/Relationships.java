package insulease.model;



public class Relationships {
	private int RelID;
	private Users RelUser;
	private Patients RelPt;
	public enum RelType{admin, provider, caregiver}
	private RelType rel;
	
	/*
	 * Constructor
	 */
	public Relationships (int RelID, Users RelUser, Patients RelPt, RelType rel) {
		this.RelID=RelID;
		this.RelUser=RelUser;
		this.RelPt=RelPt;
		this.rel=rel;
	}
	
	public Relationships (Users RelUser, Patients RelPt, RelType rel) {
		this.RelUser=RelUser;
		this.RelPt=RelPt;
		this.rel=rel;
	}
	
	//Getters
	public int getRelID() {return this.RelID;}
	public Users getRelUser() {return this.RelUser;}
	public Patients getRelPt() {return this.RelPt;}
	public RelType getRel() {return this.rel;}
	
	//Setters
	public void setRelID(int relID) {this.RelID=relID;}
	
	/*
	 * Method to convert the enum RelType to the corresponding String
	 */
	public String relToString() {
		if (this.rel.equals(RelType.admin)) {return "admin";}
		else if (this.rel.equals(RelType.caregiver)) {return "caregiver";}
		else if (this.rel.equals(RelType.provider)) {return "provider";}
		else {throw new IllegalArgumentException("There is an error with the RelType");}
	}
	
	/*
	 * Method to convert a String to an enum of RelType
	 */
	public static RelType createType (String type) {
		if (type.equals("admin")) {return RelType.admin;}
		else if (type.equals("caregiver")){return RelType.caregiver;}
		else if (type.equals("provder")) {return RelType.provider;}
		else {throw new IllegalArgumentException("The String provided does not correspond to a relType");}
	}

}
