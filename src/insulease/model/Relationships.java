package insulease.model;



public class Relationships {
	private int RelID;
	private String RelUserName;
	private String RelPtID;
	public enum RelType{admin, provider, caregiver}
	private RelType rel;
	
	/*
	 * Constructor
	 */
	public Relationships (int RelID, String RelUserName, String RelPtID, RelType rel) {
		this.RelID=RelID;
		this.RelUserName=RelUserName;
		this.RelPtID=RelPtID;
		this.rel=rel;
	}
	
	public Relationships (String RelUserName, String RelPtID, RelType rel) {
		this.RelUserName=RelUserName;
		this.RelPtID=RelPtID;
		this.rel=rel;
	}
	
	//Getters
	public int getRelID() {return this.RelID;}
	public String getRelUserName() {return this.RelUserName;}
	public String getRelPtID() {return this.RelPtID;}
	public RelType getRel() {return this.rel;}
	
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
