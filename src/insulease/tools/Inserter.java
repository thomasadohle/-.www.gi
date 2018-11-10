package insulease.tools;

import java.sql.Date;
import java.sql.SQLException;

import insulease.dao.BasalInsulinDao;
import insulease.dao.BgCommentsDao;
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
		PatientsDao DaoPatients = PatientsDao.getInstance();
		RegimentDao DaoRegiment = RegimentDao.getInstance();
		RelationshipsDao DaoRelationships = RelationshipsDao.getInstance();
		UsersDao DaoUsers = UsersDao.getInstance();
		
		
		//Create DOBs
		Date date1 = new Date(2018-10-01);
		
		
		//Create Dates
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
		DaoContactInfo.create(contact1);
		DaoContactInfo.create(contact2);
		DaoContactInfo.create(contact3);
		DaoContactInfo.create(contact4);
		DaoContactInfo.create(contact5);
		DaoContactInfo.create(contact6);
		
		//Update Contact Info
		
		
		//Make Users Objects
		Users thomas = new Users("tdohle","abc",1);
		Users deb = new Users("dallen","cde",2);
		Users nurse = new Users("nurse","fgh",4);
		Users grandpa = new Users("grandpa","123",5);
		
		//Load Users into database
		DaoUsers.create(thomas);
		DaoUsers.create(deb);
		DaoUsers.create(nurse);
		DaoUsers.create(grandpa);
		
		
		//Make Patients Objects
		Patients patient1 = new Patients("debschild","dallen",3); //Diabetic child
		Patients patient2 = new Patients("tdohle","tdohle",1); //tdohle is his own patient
		
		//Load patients into database
		DaoPatients.create(patient1);
		DaoPatients.create(patient2);
		
		
		//Make Relationships Objects
		Relationships relationship1 = new Relationships("nurse","debschild",RelType.provider);
		Relationships relationship2 = new Relationships("dallen","debschild",RelType.admin);
		Relationships relationship3 = new Relationships("tdohle","tdohle",RelType.admin);
		Relationships relationship4 = new Relationships("grandpa","debschild",RelType.caregiver);
		
		//Load relationships into database
		DaoRelationships.create(relationship1);
		DaoRelationships.create(relationship2);
		DaoRelationships.create(relationship3);
		DaoRelationships.create(relationship4);
		
		
		//Create Drs objects
		Drs dr = new Drs(6,"MGH");
		
		//Upload Drs
		DaoDrs.create(dr);
		
		
		//Create DrAppts objects
		
		//Upload DrAppts
		
		
		//Create BolusInsulin Objects
		BolusInsulin bolus = new BolusInsulin("brand1",BolusType.pen,"tdohle");
		
		//Upload BolusInsulin
		DaoBolusInsulin.create(bolus);
		
		
		//Create BasalInsulin objects
		BasalInsulin basal = new BasalInsulin("brand2",2,"tdohle");
		
		//Upload BasalInsulin
		DaoBasalInsulin.create(basal);
		
		
		//Create Regiment Objects
		Regiment regiment1 = new Regiment("tdohle",date1,12.2,130,150,2,2,1.5,1.5,1.5,1.5,1,1,1);
		
		//Upload BasalInsulin 
		//DaoRegiment.create(regiment1); 
		
		
		//Create Blood Glucoses Objects
		
		
		//Upload Blood Glucoses
		
		
		
		//Create BgComments Objects
		
		//Upload BgComments
		
		
		//Create InsulinDoses objecets
		
		//Upload InsulinDoses
		
		
		//Create DoseComments objects
		
		//Upload DoseComments
	}

}
