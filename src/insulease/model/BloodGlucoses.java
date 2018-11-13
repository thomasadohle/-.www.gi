package insulease.model;

import java.sql.Date;
import java.sql.Time;


public class BloodGlucoses {
	private int BgID;
	private String BgDate;
	private String BgTime;
	private Patients Pt;
	private int BloodGlucose;
	
	
	/*
	 * Constructor with auto-generated BgID
	 */
	public BloodGlucoses(int BgID, String BgDate, String BgTime, Patients Pt, int BloodGlucose) {
		this.BgID=BgID;
		this.BgDate=BgDate;
		this.BgTime=BgTime;
		this.Pt=Pt;
		this.BloodGlucose=BloodGlucose;
	}
	
	/*
	 * Constructor without auto-generated BgID
	 */
	public BloodGlucoses(String BgDate, String BgTime, Patients pt, int BloodGlucose) {
		this.BgDate=BgDate;
		this.BgTime=BgTime;
		this.Pt=pt;
		this.BloodGlucose=BloodGlucose;
	}
	
	//Getters
	public int getBgID() {return this.BgID;}
	public String getBgDate() {return this.BgDate;}
	public String getBgTime() {return this.BgTime;}
	public Patients getPt() {return this.Pt;}
	public int getBloodGlucose() {return this.BloodGlucose;}
	
	//Setters
	public void setBgID(int bgID) {this.BgID=bgID;}
	public void setBgDate(String newBgDate) {this.BgDate = newBgDate;}
	public void setBgTime(String newBgTime) {this.BgTime = newBgTime;}
	public void setBloodGlucose(int newBloodGlucose) {this.BloodGlucose = newBloodGlucose;}
}
