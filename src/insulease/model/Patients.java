package insulease.model;

import java.sql.SQLException;

import insulease.dao.RegimentDao;

public class Patients {
	
	private String PtID;
	private Users MasterUser;
	private ContactInfo PtContactInfo;
	
	public Patients (String PtID, Users MasterUser, ContactInfo PtContactInfo) {
		this.PtID=PtID;
		this.MasterUser=MasterUser;
		this.PtContactInfo=PtContactInfo;
	}
	
	
	public String getPtID() {return this.PtID;}
	public Users getMasterUser() {return this.MasterUser;}
	public ContactInfo getPtContactInfo() {return this.PtContactInfo;}
	public Regiment getRegiment() throws SQLException {
		RegimentDao regimentDao = RegimentDao.getInstance();
		Regiment  regiment = regimentDao.getRegimentFromPatient(this.PtID);
		return regiment;
	}
	
	@Override
	public String toString() {return "got a patient";}

}
