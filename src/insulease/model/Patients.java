package insulease.model;


public class Patients {
	
	private String PtID;
	private String MasterUserID;
	private int PtContactInfoID;
	
	public Patients (String PtID, String MasterUserID, int PtContactInfoID) {
		this.PtID=PtID;
		this.MasterUserID=MasterUserID;
		this.PtContactInfoID=PtContactInfoID;
	}
	
	
	public String getPtID() {return this.PtID;}
	public String getMasterUserID() {return this.MasterUserID;}
	public int getPtContactInfoID() {return this.PtContactInfoID;}

}
