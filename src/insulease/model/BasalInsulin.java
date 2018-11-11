package insulease.model;

public class BasalInsulin {
	private int BasalID;
	private String Brand;
	private int Frequency;

	
	/*
	 * Constructor using auto-generated BasalID
	 */
	public BasalInsulin (int BasalID, String Brand, int Frequency) {
		this.BasalID=BasalID;
		this.Brand=Brand;
		this.Frequency=Frequency;
		
	}
	
	/*
	 * Constructor without auto-generated BasalID
	 */
	public BasalInsulin (String Brand, int Frequency) {
		this.Brand=Brand;
		this.Frequency=Frequency;
	}
	
	
	//Getters
	public int getBasalID() {return this.BasalID;}
	public String getBrand() {return this.Brand;}
	public int getFrequency() {return this.Frequency;}


	//Setters
	public void setBrand(String brand) {this.Brand=brand;}
	public void setBasalID(int basalID) {this.BasalID=basalID;}

}
