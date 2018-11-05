package insulease.model;

/*
 * 	BolusID INT AUTO_INCREMENT,
    Brand VARCHAR(255),
    BolusType ENUM ('syringe','pen','pump'),
    PtID VARCHAR(255),
 */
public class BolusInsulin {
	private int BolusID;
	private String Brand;
	public enum BolusType {syringe, pen, pump}
	private BolusType bolusType;
	private String PtID;
	
	/*
	 * Constructor with auto-generated BolusID
	 */
	public BolusInsulin(int BolusID, String Brand, BolusType bolusType, String PtID) {
		this.BolusID=BolusID;
		this.Brand=Brand;
		this.bolusType=bolusType;
		this.PtID=PtID;
	}
	
	/*
	 * Constructor without auto-generated BolusID
	 */
	public BolusInsulin(String Brand, BolusType bolusType, String PtID) {
		this.Brand=Brand;
		this.bolusType=bolusType;
		this.PtID=PtID;
	}
	
	//Getters
	public int getBolusID() {return this.BolusID;}
	public String getBrand() {return this.Brand;}
	public BolusType getBolusType() {return this.bolusType;}
	public String getPtID() {return this.PtID;}

}
