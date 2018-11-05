package insulease.model;

import java.sql.Date;
import java.sql.Time;


public class DrAppts {
	private int ApptID;
	private Date ApptDate;
	private Time ApptTime;
	private String PtID;
	private int DrID;
	
	/*
	 * Constructor with auto-generated ApptID
	 */
	public DrAppts(int ApptID, Date ApptDate, Time ApptTime, String PtID, int DrID) {
		this.ApptID=ApptID;
		this.ApptDate=ApptDate;
		this.ApptTime=ApptTime;
		this.PtID=PtID;
		this.DrID=DrID;
	}
	
	/*
	 * Constructor without auto-generated ApptID
	 */
	public DrAppts(Date ApptDate, Time ApptTime, String PtID, int DrID) {
		this.ApptDate=ApptDate;
		this.ApptTime=ApptTime;
		this.PtID=PtID;
		this.DrID=DrID;
	}
	
	
	//Getters
	public int getApptID() {return this.ApptID;}
	public Date getApptDate() {return this.ApptDate;}
	public Time getApptTime() {return this.ApptTime;}
	public String getPtID() {return this.PtID;}
	public int geDrID() {return this.DrID;}
	
}
