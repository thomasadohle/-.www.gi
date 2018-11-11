package insulease.model;

import java.sql.Date;
import java.sql.Time;


public class BloodGlucoses {
	private int BgID;
	private Date BgDate;
	private Time BgTime;
	private Patients Pt;
	private int BloodGlucose;
	
	
	/*
	 * Constructor with auto-generated BgID
	 */
	public BloodGlucoses(int BgID, Date BgDate, Time BgTime, Patients Pt, int BloodGlucose) {
		this.BgID=BgID;
		this.BgDate=BgDate;
		this.BgTime=BgTime;
		this.Pt=Pt;
		this.BloodGlucose=BloodGlucose;
	}
	
	/*
	 * Constructor without auto-generated BgID
	 */
	public BloodGlucoses(Date BgDate, Time BgTime, Patients pt, int BloodGlucose) {
		this.BgDate=BgDate;
		this.BgTime=BgTime;
		this.Pt=pt;
		this.BloodGlucose=BloodGlucose;
	}
	
	//Getters
	public int getBgID() {return this.BgID;}
	public Date getBgDate() {return this.BgDate;}
	public Time getBgTime() {return this.BgTime;}
	public Patients getPt() {return this.Pt;}
	public int getBloodGlucose() {return this.BloodGlucose;}
	
	//Setters
	public void setBgID(int bgID) {this.BgID=bgID;}
	public void setBgDate(Date newBgDate) {this.BgDate = newBgDate;}
	public void setBgTime(Time newBgTime) {this.BgTime = newBgTime;}
	public void setBloodGlucose(int newBloodGlucose) {this.BloodGlucose = newBloodGlucose;}
}
