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
	
	//Getters
	public int getRelID() {return this.RelID;}
	public String getRelUserName() {return this.RelUserName;}
	public String getRelPtID() {return this.RelPtID;}
	public RelType getRel() {return this.rel;}

}
