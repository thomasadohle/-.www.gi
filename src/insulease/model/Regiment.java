package insulease.model;

import java.sql.Date;


public class Regiment {
	private int RegimentID;
	private String PtID;
	private Date RegimentDate;
	private double A1C;
	private int DaytimeTarget;
	private int NighttimeTarget;
	private int DaytimeCorrection;
	private int NighttimeCorrection;
	private double BreakfastRatio;
	private double LunchRatio;
	private double DinnerRatio;
	private double BedTimeRatio;
	private int BasalID;
	private int BolusID;
	private int DrID;
	
	/*
	 * Constructor using auto-generated RegimentID
	 */
	public Regiment(int RegimentID, String PtID, Date RegimentDate, double A1C, int DaytimeTarget, int NighttimeTarget, int DaytimeCorrection,
			int NighttimeCorrection, double BreakfastRatio, double LunchRatio, double DinnerRatio, double BedTimeRatio, int BasalId, int BolusId, int DrID) {
		this.RegimentID=RegimentID;
		this.PtID=PtID;
		this.RegimentDate=RegimentDate;
		this.A1C=A1C;
		this.DaytimeTarget=DaytimeTarget;
		this.NighttimeTarget=NighttimeTarget;
		this.DaytimeCorrection=DaytimeCorrection;
		this.NighttimeCorrection=NighttimeCorrection;
		this.BreakfastRatio=BreakfastRatio;
		this.LunchRatio=LunchRatio;
		this.DinnerRatio=DinnerRatio;
		this.BedTimeRatio=BedTimeRatio;
		this.BasalID=BasalId;
		this.BolusID=BolusId;
		this.DrID=DrID;
	}
	
	/*
	 * Constructor not using auto-generated RegimentID
	 */
	public Regiment(String PtID, Date RegimentDate, double A1C, int DaytimeTarget, int NighttimeTarget, int DaytimeCorrection,
			int NighttimeCorrection, double BreakfastRatio, double LunchRatio, double DinnerRatio, double BedTimeRatio, int BasalId, int BolusId, int DrID) {
		this.PtID=PtID;
		this.RegimentDate=RegimentDate;
		this.A1C=A1C;
		this.DaytimeTarget=DaytimeTarget;
		this.NighttimeTarget=NighttimeTarget;
		this.DaytimeCorrection=DaytimeCorrection;
		this.NighttimeCorrection=NighttimeCorrection;
		this.BreakfastRatio=BreakfastRatio;
		this.LunchRatio=LunchRatio;
		this.DinnerRatio=DinnerRatio;
		this.BedTimeRatio=BedTimeRatio;
		this.BasalID=BasalId;
		this.BolusID=BolusId;
		this.DrID=DrID;
	}
	
	//Getters
	public int getRegimentID() {return this.RegimentID;}
	public String getPtID() {return this.PtID;}
	public Date getRegimentDate() {return this.RegimentDate;}
	public double getA1C() {return this.A1C;}
	public int getDayTimeTarget() {return this.DaytimeTarget;}
	public int getNighttimeTarget() {return this.NighttimeTarget;}
	public int getDaytimeCorrection() {return this.DaytimeCorrection;}
	public int getNighttimeCorrection() {return this.NighttimeCorrection;}
	public double getBreakfastRatio() {return this.BreakfastRatio;}
	public double getLunchRatio() {return this.LunchRatio;}
	public double getDinnerRatio() {return this.DinnerRatio;}
	public double getBedtimeRatio() {return this.BedTimeRatio;}
	public int getBasalID() {return this.BasalID;}
	public int getBolusID() {return this.BolusID;}
	public int getDrID() {return this.DrID;}
	
	//Setters
	public void setPtID(String newPtID) {this.PtID = newPtID;}
	public void setRegimentDate(Date newRegimentDate) {this.RegimentDate = newRegimentDate;}
	public void setA1C(double newA1C) {this.A1C = newA1C;}
	public void setDayTimeTarget(int newDayTimeTarget) {this.DaytimeTarget = newDayTimeTarget;}
	public void setNighttimeTarget(int newNighttimeTarget) {this.NighttimeTarget = newNighttimeTarget;}
	public void setDaytimeCorrection(int newDaytimeCorrection) {this.DaytimeCorrection = newDaytimeCorrection;}
	public void setNighttimeCorrection(int newNighttimeCorrection) {this.NighttimeCorrection = newNighttimeCorrection;}
	public void setBreakfastRatio(double newBreakfastRatio) {this.BreakfastRatio = newBreakfastRatio;}
	public void setLunchRatio(double newLunchRatio) {this.LunchRatio = newLunchRatio;}
	public void setDinnerRatio(double newDinnerRatio) {this.DinnerRatio = newDinnerRatio;}
	public void setBedtimeRatio(double newBedtimeRatio) {this.BedTimeRatio = newBedtimeRatio;}
	public void setBasalId(int newBasalId) {this.BasalID = newBasalId;}
	public void setBolusId(int newBolusId) {this.BolusID = newBolusId;}
	public void setDrID(int newDrID) {this.DrID = newDrID;}


	

}
