package insulease.model;


public class Patients {
	
	private int PtID;
	private String MasterUserID;
	private int PtContactInfoID;
	
	public Patients (int PtID, String MasterUserID, int PtContactInfoID) {
		this.PtID=PtID;
		this.MasterUserID=MasterUserID;
		this.PtContactInfoID=PtContactInfoID;
	}
	
	public int getPtID() {return this.PtID;}
	public String getMasterUserID() {return this.MasterUserID;}
	public int getPtContactInfoID() {return this.PtContactInfoID;}

}
