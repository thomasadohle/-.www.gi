package insulease.tools;

import insulease.dao.BasalInsulinDao;
import insulease.dao.BgCommentsDao;
import insulease.dao.BloodGlucosesDao;
import insulease.dao.BolusInsulinDao;
import insulease.dao.ContactInfoDao;
import insulease.dao.DoseCommentsDao;
import insulease.dao.DrApptsDao;
import insulease.dao.DrsDao;
import insulease.dao.InsulinDosesDao;
import insulease.dao.PatientsDao;
import insulease.dao.RegimentDao;
import insulease.dao.RelationshipsDao;
import insulease.dao.UsersDao;
import insulease.model.BasalInsulin;
import insulease.model.BgComments;
import insulease.model.BloodGlucoses;
import insulease.model.BolusInsulin;
import insulease.model.BolusInsulin.BolusType;
import insulease.model.ContactInfo;
import insulease.model.DoseComments;
import insulease.model.DrAppts;
import insulease.model.Drs;
import insulease.model.InsulinDoses;
import insulease.model.InsulinDoses.DoseType;
import insulease.model.Patients;
import insulease.model.Regiment;
import insulease.model.Relationships;
import insulease.model.Relationships.RelType;
import insulease.model.Users;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import insulease.dao.BasalInsulinDao;
import insulease.dao.BgCommentsDao;
import insulease.dao.BloodGlucosesDao;
import insulease.dao.BolusInsulinDao;
import insulease.dao.ContactInfoDao;
import insulease.dao.DoseCommentsDao;
import insulease.dao.DrsDao;
import insulease.dao.PatientsDao;
import insulease.dao.RegimentDao;
import insulease.dao.RelationshipsDao;
import insulease.dao.UsersDao;
import insulease.model.BasalInsulin;
import insulease.model.BgComments;
import insulease.model.BloodGlucoses;
import insulease.model.BolusInsulin;
import insulease.model.BolusInsulin.BolusType;
import insulease.model.ContactInfo;
import insulease.model.Drs;
import insulease.model.Patients;
import insulease.model.Regiment;
import insulease.model.Relationships;
import insulease.model.Relationships.RelType;
import insulease.model.Users;

public class Inserter {
	
	public static void main (String[] args) throws SQLException {
		//Create Daos
				BasalInsulinDao DaoBasalInsulin = BasalInsulinDao.getInstance();
				BgCommentsDao DaoBgComments = BgCommentsDao.getInstance();
				BolusInsulinDao DaoBolusInsulin = BolusInsulinDao.getInstance();
				ContactInfoDao DaoContactInfo = ContactInfoDao.getInstance();
				DoseCommentsDao DaoDoseComments = DoseCommentsDao.getInstance();
				DrsDao DaoDrs = DrsDao.getInstance();
				DrApptsDao DaoDrAppt = DrApptsDao.getInstance();
				PatientsDao DaoPatients = PatientsDao.getInstance();
				RegimentDao DaoRegiment = RegimentDao.getInstance();
				RelationshipsDao DaoRelationships = RelationshipsDao.getInstance();
				UsersDao DaoUsers = UsersDao.getInstance();
				BloodGlucosesDao DaoBloodGlucoses = BloodGlucosesDao.getInstance();
				InsulinDosesDao DaoInsulinDoses = InsulinDosesDao.getInstance();
				
				
				
				
				//Create DOBs
				Date dob1 = new Date(2009-06-01);
				Date dob2 = new Date(1988-02-11);
				Date dob3 = new Date(1960-01-21);
				
				//Make ContactInfo Objects
				ContactInfo contact1 = new ContactInfo("Thomas","Dohle",dob1,"123","S Street","Somerville","MA",02145,"a@gmail.com","m","");
				ContactInfo contact2 = new ContactInfo("Deb","Allen",dob2,"234","K Street","Plymouth","MA",01456,"b@gmail.com","f","");
				ContactInfo contact3 = new ContactInfo("Dave","Diabetes",dob1,"234","K Street","Plymouth","MA",01456,"","m","");
				ContactInfo contact4 = new ContactInfo("Nurse","Nancy",dob2,"123","a street","Kingston","MA",01246,"nurse@nursing.com","f","");
				ContactInfo contact5 = new ContactInfo("Grandpa","Greg",dob3,"123","F Street","Stoughton","MA",54871," ","m","");
				ContactInfo contact6 = new ContactInfo("Dr","Bob",dob3,"123","J street","Weymouth","MA",01111,"bob@dr.com","m","");
				
				//Load ContactInfo to database
				//DaoContactInfo.create(contact1);
				ContactInfoDao.getInstance().create(contact1);
				DaoContactInfo.create(contact2);
				DaoContactInfo.create(contact3);
				DaoContactInfo.create(contact4);
				DaoContactInfo.create(contact5);
				DaoContactInfo.create(contact6);
				
				
				
				//Update Contact Info
				
				
				//Make Users Objects
				Users thomas = new Users("tdohle","abc",contact1);
				Users deb = new Users("dallen","cde",contact2);
				Users dave = new Users("dave","lmn",contact3);
				Users nurse = new Users("nurse","fgh",contact4);
				Users grandpa = new Users("grandpa","123",contact5);
				Users bob = new Users("docbob","123",contact6);
				
				//Load Users into database
				DaoUsers.create(thomas);
				DaoUsers.create(deb);
				DaoUsers.create(dave);
				DaoUsers.create(nurse);
				DaoUsers.create(grandpa);
				DaoUsers.create(bob);
				
				
				//Make Patients Objects
				Patients patient1 = new Patients("debschild",dave,contact3); //Diabetic child
				Patients patient2 = new Patients("tdohle",thomas,contact1); //tdohle is his own patient
				
				//Load patients into database
				DaoPatients.create(patient1);
				DaoPatients.create(patient2);
				
				
				//Make Relationships Objects
				Relationships relationship1 = new Relationships(nurse,patient1,RelType.provider);
				Relationships relationship2 = new Relationships(deb,patient1,RelType.admin);
				Relationships relationship3 = new Relationships(thomas,patient2,RelType.admin);
				Relationships relationship4 = new Relationships(grandpa,patient1,RelType.caregiver);
				
				//Load relationships into database
				DaoRelationships.create(relationship1);
				DaoRelationships.create(relationship2);
				DaoRelationships.create(relationship3);
				DaoRelationships.create(relationship4);
				
				
				//Create Drs objects
				Drs dr = new Drs(contact6,"MGH");
				
				//Load Drs objects
				DaoDrs.create(dr);
				
				
				//Create DrAppts objects
				DrAppts drAppt1 = new DrAppts ("2018-12-23","11:00:00",patient1, dr);
				DrAppts drAppt2 = new DrAppts ("2018-12-05","11:00:00",patient2, dr);
				
				//Load DrAppts objects
				DaoDrAppt.create(drAppt1);
				DaoDrAppt.create(drAppt2);
				
				
				//Create BolusInsulin Objects
				BolusInsulin bolus1 = new BolusInsulin("brand1",BolusType.pen);
				BolusInsulin bolus2 = new BolusInsulin("brand2",BolusType.syringe);
				BolusInsulin bolus3 = new BolusInsulin("brand3",BolusType.pump);
				
				//Load BolusInsulin
				DaoBolusInsulin.create(bolus1);
				DaoBolusInsulin.create(bolus2);
				DaoBolusInsulin.create(bolus3);
				
				
				//Create BasalInsulin objects
				BasalInsulin basal1 = new BasalInsulin("brand1",1);
				BasalInsulin basal2 = new BasalInsulin("brand2",2);
				
				//Load BasalInsulin
				DaoBasalInsulin.create(basal1);
				DaoBasalInsulin.create(basal2);
				
				//Update basalInsulin
				DaoBasalInsulin.updateContent(basal1, "new");
				
				
				//Create Regiment Objects
				Regiment regiment1 = new Regiment(patient2,"2018-11-12",12.2,130,150,50,50,9.0,10.0,9.0,11.0,basal1,bolus1,dr);
				Regiment regiment2 = new Regiment(patient1,"2018-11-11",7.5,120,150,90,90,11.0,20.0,14.0,16.0,basal2,bolus2,dr);
				
				//Upload Regiment 
				DaoRegiment.create(regiment1); 
				DaoRegiment.create(regiment2); 
				
				//Update Regiment
				DaoRegiment.updateRegiment(regiment1, "A1C", 8.1);
				DaoRegiment.updateRegiment(regiment1, "DaytimeTarget", 110);
				DaoRegiment.updateRegiment(regiment2, "A1C", 7.0);
				DaoRegiment.updateRegiment(regiment2, "DaytimeTarget", 130);
				
				
				
				//Create Blood Glucoses Objects
				BloodGlucoses bg1 = new BloodGlucoses("2018-11-11","13:00:00",patient2,150);
				BloodGlucoses bg2 = new BloodGlucoses("2018-11-11","09:00:00",patient2,160);
				BloodGlucoses bg3 = new BloodGlucoses("2018-11-11","17:00:00",patient2,179);
				BloodGlucoses bg4 = new BloodGlucoses("2018-11-11","13:00:00",patient1,140);
				BloodGlucoses bg5 = new BloodGlucoses("2018-11-11","09:00:00",patient1,120);
				BloodGlucoses bg6 = new BloodGlucoses("2018-11-11","17:00:00",patient1,79);
				
				//Upload Blood Glucoses
				DaoBloodGlucoses.create(bg1);
				DaoBloodGlucoses.create(bg2);
				DaoBloodGlucoses.create(bg3);
				DaoBloodGlucoses.create(bg4);
				DaoBloodGlucoses.create(bg5);
				DaoBloodGlucoses.create(bg6);
				
				
				//Create BgComments Objects
				BgComments bgComment1 = new BgComments("not great",bg1);
				BgComments bgComment2 = new BgComments("better",bg2);
				
				//Upload BgComments
				DaoBgComments.create(bgComment1);
				DaoBgComments.create(bgComment2);
				
				
				//Create InsulinDoses objects
				InsulinDoses insulin1 = new InsulinDoses(patient1, "2018-11-11", "13:00:00", DoseType.lunch, 48, bg1, 4.0, 3.5);
				InsulinDoses insulin2 = new InsulinDoses(patient1, "2018-11-11", "09:00:00", DoseType.breakfast, 52, bg2, 4.5, 4.5);
				InsulinDoses insulin3 = new InsulinDoses(patient1, "2018-11-11", "17:00:00", DoseType.dinner, 41, bg3, 5.0, 4.5);
				InsulinDoses insulin4 = new InsulinDoses(patient2, "2018-11-11", "13:00:00", DoseType.lunch, 47, bg4, 4.0, 3.5);
				InsulinDoses insulin5 = new InsulinDoses(patient2, "2018-11-11", "09:00:00", DoseType.breakfast, 56, bg5, 4.0, 3.5);
				InsulinDoses insulin6 = new InsulinDoses(patient2, "2018-11-11", "17:00:00", DoseType.dinner, 35, bg6, 5.0, 4.5);
				
				
				//Upload InsulinDoses
				DaoInsulinDoses.create(insulin1);
				DaoInsulinDoses.create(insulin2);
				DaoInsulinDoses.create(insulin3);
				DaoInsulinDoses.create(insulin4);
				DaoInsulinDoses.create(insulin5);
				DaoInsulinDoses.create(insulin6);
				
				
				//Create DoseComments objects
				DoseComments doseComments1 = new DoseComments("didn't want to crash, gave less", insulin1);
				DoseComments doseComments2 = new DoseComments("trending down, gave less", insulin3);
				DoseComments doseComments3 = new DoseComments("gave less", insulin5);
				
				//Upload DoseComments
				DaoDoseComments.create(doseComments1);
				DaoDoseComments.create(doseComments2);
				DaoDoseComments.create(doseComments3);
				

}
}