package insulease.model;

import java.sql.Date;
import java.sql.Time;


public class InsulinDoses {
	private int DoseID;
	private Patients Pt;
	private String DoseDate;
	private String DoseTime;
	public enum DoseType{breakfast, morning_snack, lunch, afternoon_snack, dinner, bedtime_snack, overnight}
	private DoseType doseType;
	private int CarbCount;
	private BloodGlucoses Bg;
	private double CalculatedDose;
	private double ActualDose;
	
	/*
	 * Constructor using auto-generated DoseID
	 */
	public InsulinDoses (int DoseID, Patients pt, String DoseDate, String DoseTime, DoseType doseType, int CarbCount,
			BloodGlucoses bg, double CalculatedDose, double ActualDose) {
		this.DoseID=DoseID;
		this.Pt=pt;
		this.DoseDate=DoseDate;
		this.DoseTime=DoseTime;
		this.doseType=doseType;
		this.CarbCount=CarbCount;
		this.Bg = bg;
		this.CalculatedDose=CalculatedDose;
		this.ActualDose=ActualDose;
	}
	
	/*
	 * Constructor not using auto-generated DoseID
	 */
	public InsulinDoses (Patients pt, String DoseDate, String DoseTime, DoseType doseType, int CarbCount,
			BloodGlucoses bg, double CalculatedDose, double ActualDose) {
		this.Pt=pt;
		this.DoseDate=DoseDate;
		this.DoseTime=DoseTime;
		this.doseType=doseType;
		this.CarbCount=CarbCount;
		this.Bg = bg;
		this.CalculatedDose=CalculatedDose;
		this.ActualDose=ActualDose;
	}
	
	//Getters
	public int getDoseID() {return this.DoseID;}
	public Patients getPt() {return this.Pt;}
	public String getDoseDate() {return this.DoseDate;}
	public String getDoseTime() {return this.DoseTime;}
	public DoseType getDoseType() {return this.doseType;}
	public int getCarbCount() {return this.CarbCount;}
	public BloodGlucoses getBg() {return this.Bg;}
	public double getCalcualtedDose () {return this.CalculatedDose;}
	public double getActualDose () {return this.ActualDose;}
	
	//Setters
	public void setIDoseID (int doseID) {this.DoseID=doseID;}
	public void setDoseDate(String newDoseDate) { this.DoseDate = newDoseDate;}
	public void setDoseTime(String newDoseTime) { this.DoseTime = newDoseTime;}
	public void setDoseType(DoseType newDoseType) { this.doseType = newDoseType;}
	public void setCarbCount(int newCarbCount) { this.CarbCount = newCarbCount;}
	public void setActualDose (double newActualDose) { this.ActualDose = newActualDose;}
	

	/*
	 * Convert BolusType to a String
	 */
	public String DoseTypeToString() {
		if (this.doseType.equals(doseType.breakfast)) {return "breakfast";}
		else if (this.doseType.equals(doseType.morning_snack)) {return "morning_snack";}
		else if (this.doseType.equals(doseType.lunch)) {return "lunch";}
		else if (this.doseType.equals(doseType.afternoon_snack)) {return "afternoon_snack";}
		else if (this.doseType.equals(doseType.dinner)) {return "dinner";}
		else if (this.doseType.equals(doseType.bedtime_snack)) {return "bedtime_snack";}
		else if (this.doseType.equals(doseType.overnight)) {return "overnight";}
		else {throw new IllegalArgumentException ("Dose type is invalid");}
	}
	
	
	
	/*
	 * Convert a String to a Dose Type by time of day
	 * breakfast, morning_snack, lunch, afternoon_snack, dinner, bedtime_snack, overnight.
	 */
	public static DoseType StringToDoseType(String str) {
		String type = str.toUpperCase();
		if (type.equals("breakfast")) {return DoseType.breakfast;}
		else if (type.equals("morning_snack")) {return DoseType.morning_snack;}
		else if (type.equals("lunch")) {return DoseType.lunch;}
		else if (type.equals("afternoon_snack")) {return DoseType.afternoon_snack;}
		else if (type.equals("dinner")) {return DoseType.dinner;}
		else if (type.equals("bedtime_snack")) {return DoseType.bedtime_snack;}
		else if (type.equals("overnight")) {return DoseType.overnight;}
		else {throw new IllegalArgumentException ("DoseType not recognized");}
	}

}
