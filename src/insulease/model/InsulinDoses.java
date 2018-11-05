package insulease.model;

import java.sql.Date;
import java.sql.Time;


public class InsulinDoses {
	private int DoseID;
	private String PtID;
	private Date DoseDate;
	private Time DoseTime;
	public enum DoseType{breakfast, morning_snack, lunch, afternoon_snack, dinner, bedtime_snack, overnight}
	private DoseType doseType;
	private int CarbCount;
	private int BgId;
	private double CalculatedDose;
	private double ActualDose;
	
	/*
	 * Constructor using auto-generated DoseID
	 */
	public InsulinDoses (int DoseID, String PtID, Date DoseDate, Time DoseTime, DoseType doseType, int CarbCount,
			int BgId, double CalculatedDose, double ActualDose) {
		this.DoseID=DoseID;
		this.PtID=PtID;
		this.DoseDate=DoseDate;
		this.DoseTime=DoseTime;
		this.doseType=doseType;
		this.CarbCount=CarbCount;
		this.BgId = BgId;
		this.CalculatedDose=CalculatedDose;
		this.ActualDose=ActualDose;
	}
	
	/*
	 * Constructor not using auto-generated DoseID
	 */
	public InsulinDoses (String PtID, Date DoseDate, Time DoseTime, DoseType doseType, int CarbCount,
			int BgId, double CalculatedDose, double ActualDose) {
		this.PtID=PtID;
		this.DoseDate=DoseDate;
		this.DoseTime=DoseTime;
		this.doseType=doseType;
		this.CarbCount=CarbCount;
		this.BgId = BgId;
		this.CalculatedDose=CalculatedDose;
		this.ActualDose=ActualDose;
	}
	
	//Getters
	public String getPtID() {return this.PtID;}
	public Date getDoseDate() {return this.DoseDate;}
	public Time getDoseTime() {return this.DoseTime;}
	public DoseType getDoseType() {return this.doseType;}
	public int getCarbCount() {return this.CarbCount;}
	public int getBgID() {return this.BgId;}
	public double getCalcualtedDose () {return this.CalculatedDose;}
	public double getActualtedDose () {return this.ActualDose;}
	
	//Setters
	public void setDoseDate(Date newDoseDate) { this.DoseDate = newDoseDate;}
	public void setDoseTime(Time newDoseTime) { this.DoseTime = newDoseTime;}
	public void setDoseType(DoseType newDoseType) { this.doseType = newDoseType;}
	public void setCarbCount(int newCarbCount) { this.CarbCount = newCarbCount;}
	public void setActualtedDose (double newActualDose) { this.ActualDose = newActualDose;}
	

}
