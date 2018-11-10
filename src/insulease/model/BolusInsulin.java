package insulease.model;


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
	
	/*
	 * Convert BolusType to a String
	 */
	public String BolusTypeToString() {
		if (this.bolusType.equals(bolusType.pen)) {return "pen";}
		else if (this.bolusType.equals(bolusType.pump)) {return "pump";}
		else if (this.bolusType.equals(bolusType.syringe)) {return "syringe";}
		else {throw new IllegalArgumentException ("Bolus type is invalid");}
	}
	
	/*
	 * Convert a String to a BolusType
	 */
	public static BolusType StringToBolusType(String str) {
		String type = str.toUpperCase();
		if (type.equals("PEN")) {return BolusType.pen;}
		else if (type.equals("PUMP")) {return BolusType.pump;}
		else if (type.equals("SYRINGE")) {return BolusType.syringe;}
		else {throw new IllegalArgumentException ("BolusType not recognized");}
	}

}
