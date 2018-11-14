package insulease.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import insulease.dao.BloodGlucosesDao;
import insulease.dao.PatientsDao;
import insulease.model.BloodGlucoses;
import insulease.model.Patients;

@WebServlet("/AddBg")

public class AddBg extends HttpServlet{
protected BloodGlucosesDao  bloodGlucosesDao;
	
	@Override
	public void init() throws ServletException {
		bloodGlucosesDao = BloodGlucosesDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        messages.put("success","Please enter a valid Patient ID");
        req.getRequestDispatcher("/NewBg.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        //Create objects for all pieces of Bg
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter time = DateTimeFormatter.ofPattern("hh:mm:ss");
        String bgDate = now.format(date);
        String bgTime = now.format(time);
        String patientID = req.getParameter("patientId");
        String bgString = req.getParameter("bg");
        int bg = Integer.parseInt(bgString);
        PatientsDao dao = PatientsDao.getInstance();
        BloodGlucoses newBg = null;
        
        if (patientID == null || patientID.trim().isEmpty()) {
            messages.put("success", "Please enter a valid name.");
        } else {
        	// Retrieve Patients, and store as a message.
        	try {
        		Patients patient = dao.getPatientFromPtID(patientID);
        		newBg = new BloodGlucoses(bgDate, bgTime, patient, bg);
            	bloodGlucosesDao.create(newBg);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Entered the following Bg for " + patientID);
        	// Save the previous search term, so it can be used as the default
        	// in the input box when rendering FindUsers.jsp.
        	messages.put("previousPatient", patientID);
        }
        
    	req.setAttribute("newBg", newBg);  
        req.getRequestDispatcher("/NewBg.jsp").forward(req, resp);
    }


}
