package insulease.servlet;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import insulease.dao.PatientsDao;
import insulease.dao.RegimentDao;
import insulease.model.Patients;
import insulease.model.Regiment;

@WebServlet("/GetRegiment")
public class GetRegiment extends HttpServlet {
	protected RegimentDao regimentDao;
	
	@Override
	public void init() throws ServletException {
		regimentDao = RegimentDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        //List<Patients> patients = new ArrayList<Patients>();
        Regiment regiment = null;
        
    
        String patientID = req.getParameter("patientId");
        if (patientID == null || patientID.trim().isEmpty()) {
            messages.put("success", "Please enter a valid patient ID.");
        } else {
        	// Retrieve Patients, and store as a message.
        	try {
            	regiment = regimentDao.getRegimentFromPatient(patientID);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + patientID);
        	// Save the previous search term, so it can be used as the default
        	// in the input box when rendering FindUsers.jsp.
        	messages.put("previousPatient", patientID);
        }
        req.setAttribute("regiment", regiment);
        
        req.getRequestDispatcher("/GetRegiment.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        Regiment regimentToPass = null;
        
       
        String patientID = req.getParameter("patientId");
        if (patientID == null || patientID.trim().isEmpty()) {
            messages.put("success", "Please enter a valid Patient ID.");
        } else {
        	// Retrieve BlogUsers, and store as a message.
        	try {
            	regimentToPass = regimentDao.getRegimentFromPatient(patientID);
            	
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + patientID);
        }
        req.setAttribute("regiment", regimentToPass);
        
        req.getRequestDispatcher("/GetRegiment.jsp").forward(req, resp);
    }
}
