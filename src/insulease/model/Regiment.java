package insulease.model;

import java.sql.Date;


public class Regiment {
	private int RegimentID;
	private Patients pt;
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
	private BasalInsulin basalInsulin;
	private BolusInsulin bolusInsulin;
	private Drs dr;
	
	/*
	 * Constructor using auto-generated RegimentID
	 */
	public Regiment(int RegimentID, Patients pt, Date RegimentDate, double A1C, int DaytimeTarget, int NighttimeTarget, int DaytimeCorrection,
			int NighttimeCorrection, double BreakfastRatio, double LunchRatio, double DinnerRatio, double BedTimeRatio, BasalInsulin basal, BolusInsulin bolus, Drs dr) {
		this.RegimentID=RegimentID;
		this.pt=pt;
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
		this.basalInsulin=basal;
		this.bolusInsulin=bolus;
		this.dr=dr;
	}
	
	/*
	 * Constructor not using auto-generated RegimentID
	 */
	public Regiment(Patients pt, Date RegimentDate, double A1C, int DaytimeTarget, int NighttimeTarget, int DaytimeCorrection,
			int NighttimeCorrection, double BreakfastRatio, double LunchRatio, double DinnerRatio, double BedTimeRatio, BasalInsulin basal, 
			BolusInsulin bolus, Drs dr) {
		this.pt=pt;
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
		this.basalInsulin=basal;
		this.bolusInsulin=bolus;
		this.dr=dr;
	}
	
	//Getters
	public int getRegimentID() {return this.RegimentID;}
	public Patients getPt() {return this.pt;}
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
	public BasalInsulin getBasal() {return this.basalInsulin;}
	public BolusInsulin getBolus() {return this.bolusInsulin;}
	public Drs getDr() {return this.dr;}
	
	//Setters
	public void setRegimentID (int regimentID) {this.RegimentID=regimentID;}
	public void setPt(Patients newPt) {this.pt = newPt;}
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
	public void setBasal(BasalInsulin newBasal) {this.basalInsulin = newBasal;}
	public void setBolus(BolusInsulin newBolus) {this.bolusInsulin = newBolus;}
	public void setDrID(Drs newDr) {this.dr = newDr;}


	

}
