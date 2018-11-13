package insulease.model;

import java.sql.Date;
import java.sql.Time;


public class DrAppts {
	private int ApptID;
	private String ApptDate;
	private String ApptTime;
	private Patients Pt;
	private Drs Dr;
	
	/*
	 * Constructor with auto-generated ApptID
	 */
	public DrAppts(int ApptID, String ApptDate, String ApptTime, Patients Pt, Drs Dr) {
		this.ApptID=ApptID;
		this.ApptDate=ApptDate;
		this.ApptTime=ApptTime;
		this.Pt=Pt;
		this.Dr=Dr;
	}
	
	/*
	 * Constructor without auto-generated ApptID
	 */
	public DrAppts(String ApptDate, String ApptTime, Patients Pt, Drs Dr) {
		this.ApptDate=ApptDate;
		this.ApptTime=ApptTime;
		this.Pt=Pt;
		this.Dr=Dr;
	}
	
	
	//Getters
	public int getApptID() {return this.ApptID;}
	public String getApptDate() {return this.ApptDate;}
	public String getApptTime() {return this.ApptTime;}
	public Patients getPt() {return this.Pt;}
	public Drs getDr() {return this.Dr;}
	
	//Setters
	public void setApptID(int apptID) {this.ApptID=apptID;}
	
}
