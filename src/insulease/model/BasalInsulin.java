package insulease.model;
/*
 * BasalID INT AUTO_INCREMENT,
    Brand VARCHAR(255),
    Frequency TINYINT,
    PtID VARCHAR(255),
 */
public class BasalInsulin {
	private int BasalID;
	private String Brand;
	private int Frequency;
	private String PtID;
	
	/*
	 * Constructor using auto-generated BasalID
	 */
	public BasalInsulin (int BasalID, String Brand, int Frequency, String PtID) {
		this.BasalID=BasalID;
		this.Brand=Brand;
		this.Frequency=Frequency;
		this.PtID=PtID;
	}
	
	/*
	 * Constructor without auto-generated BasalID
	 */
	public BasalInsulin (String Brand, int Frequency, String PtID) {
		this.Brand=Brand;
		this.Frequency=Frequency;
		this.PtID=PtID;
	}
	
	
	//Getters
	public int getBasalID() {return this.BasalID;}
	public String getBrand() {return this.Brand;}
	public int getFrequency() {return this.Frequency;}
	public String getPtID() {return this.PtID;}


}
