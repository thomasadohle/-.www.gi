package insulease.model;

import java.sql.Date;
import java.sql.Time;


public class DrAppts {
	private int ApptID;
	private Date ApptDate;
	private Time ApptTime;
	private Patients Pt;
	private Drs Dr;
	
	/*
	 * Constructor with auto-generated ApptID
	 */
	public DrAppts(int ApptID, Date ApptDate, Time ApptTime, Patients Pt, Drs Dr) {
		this.ApptID=ApptID;
		this.ApptDate=ApptDate;
		this.ApptTime=ApptTime;
		this.Pt=Pt;
		this.Dr=Dr;
	}
	
	/*
	 * Constructor without auto-generated ApptID
	 */
	public DrAppts(Date ApptDate, Time ApptTime, Patients Pt, Drs Dr) {
		this.ApptDate=ApptDate;
		this.ApptTime=ApptTime;
		this.Pt=Pt;
		this.Dr=Dr;
	}
	
	
	//Getters
	public int getApptID() {return this.ApptID;}
	public Date getApptDate() {return this.ApptDate;}
	public Time getApptTime() {return this.ApptTime;}
	public Patients getPt() {return this.Pt;}
	public Drs getDr() {return this.Dr;}
	
	//Setters
	public void setApptID(int apptID) {this.ApptID=apptID;}
	
}
