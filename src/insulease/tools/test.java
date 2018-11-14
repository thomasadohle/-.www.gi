package insulease.tools;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import insulease.dao.BloodGlucosesDao;
import insulease.dao.ContactInfoDao;
import insulease.dao.DrApptsDao;
import insulease.dao.PatientsDao;
import insulease.dao.UsersDao;
import insulease.model.BloodGlucoses;
import insulease.model.ContactInfo;
import insulease.model.DrAppts;
import insulease.model.Patients;
import insulease.model.Users;

public class test {
	public static void main (String[] args) throws SQLException {
		Date dob1 = new Date(2009-06-01);

		ContactInfo contact1 = new ContactInfo("Thomas","Dohle",dob1,"123","S Street","Somerville","MA",02145,"a@gmail.com","m","");
		Users thomas = new Users("tdohle","abc",contact1);
		Patients patient2 = new Patients("tdohle",thomas,contact1);
		
		ContactInfoDao.getInstance().create(contact1);
		UsersDao.getInstance().create(thomas);
		PatientsDao.getInstance().create(patient2);
		
	}

}
