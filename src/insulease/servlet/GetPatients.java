package insulease.servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import insulease.dao.PatientsDao;
import insulease.model.Patients;



@WebServlet("/findpatient")   
public class GetPatients extends HttpServlet{
	
protected PatientsDao patientsDao;
	
	@Override
	public void init() throws ServletException {
		patientsDao = PatientsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        //List<Patients> patients = new ArrayList<Patients>();
        Patients patient = null;
        
        // Retrieve and validate name.
        // firstname is retrieved from the URL query string.
        String patientID = req.getParameter("patientID");
        if (patientID == null || patientID.trim().isEmpty()) {
            messages.put("success", "Please enter a valid name.");
        } else {
        	// Retrieve Patients, and store as a message.
        	try {
            	patient = patientsDao.getPatientFromPtID(patientID);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + patientID);
        	// Save the previous search term, so it can be used as the default
        	// in the input box when rendering FindUsers.jsp.
        	messages.put("previousPatient", patientID);
        }
        req.setAttribute("patient", patient);
        
        req.getRequestDispatcher("/GetPatient.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        Patients patientToPass = null;
        
        // Retrieve and validate name.
        // firstname is retrieved from the form POST submission. By default, it
        // is populated by the URL query string (in FindUsers.jsp).
        String patientID = req.getParameter("patientID");
        if (patientID == null || patientID.trim().isEmpty()) {
            messages.put("success", "Please enter a valid name.");
        } else {
        	// Retrieve BlogUsers, and store as a message.
        	try {
            	patientToPass = patientsDao.getPatientFromPtID(patientID);
            	
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + patientID);
        }
        req.setAttribute("patient", patientToPass);
        
        req.getRequestDispatcher("/GetPatient.jsp").forward(req, resp);
    }

}
