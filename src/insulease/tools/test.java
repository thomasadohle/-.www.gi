package insulease.tools;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import insulease.dao.DrApptsDao;
import insulease.model.DrAppts;

public class test {
	public static void main (String[] args) throws SQLException {
		
		DrApptsDao dao = DrApptsDao.getInstance();
		DrAppts appt = dao.getApptFromApptID(2);
		System.out.print(appt.getApptDate());
		
	}

}
