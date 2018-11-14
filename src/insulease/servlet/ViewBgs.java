package insulease.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

@WebServlet("/ViewBgs")
public class ViewBgs extends HttpServlet {
	
protected BloodGlucosesDao bloodGlucosesDao;
	
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

        List<BloodGlucoses> bloodGlucoses = new ArrayList<BloodGlucoses>();
        BloodGlucosesDao dao = BloodGlucosesDao.getInstance();
        
        // Retrieve and validate name.
        // firstname is retrieved from the URL query string.
        String PtID = req.getParameter("patientId");
        
        if (PtID == null || PtID.trim().isEmpty()) {
            messages.put("success", "Please enter a PatientId");
        } else {
        	// Retrieve BlogUsers, and store as a message.
        	try {
            	bloodGlucoses = dao.getBgFromPtID(PtID);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying past ten blood glucoses for " + PtID);
        	// Save the previous search term, so it can be used as the default
        	// in the input box when rendering FindUsers.jsp.
        	messages.put("previousPtID", PtID);
        }
        req.setAttribute("bloodGlucoses", bloodGlucoses);
        
        req.getRequestDispatcher("/ViewBgs.jsp").forward(req, resp);
	}

	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<BloodGlucoses> bloodGlucoses = new ArrayList<BloodGlucoses>();
        BloodGlucosesDao dao = BloodGlucosesDao.getInstance();
        // Retrieve and validate name.
        // firstname is retrieved from the form POST submission. By default, it
        // is populated by the URL query string (in FindUsers.jsp).
        String PtID = req.getParameter("PtID");
        if (PtID == null || PtID.trim().isEmpty()) {
            messages.put("success", "Please enter a valid name.");
        } else {
        	// Retrieve BlogUsers, and store as a message.
        	try {
            	bloodGlucoses = dao.getBgFromPtID(PtID);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying past 10 blood glucoses for " + PtID);
        }
        req.setAttribute("bloodGlucoses", bloodGlucoses);
        
        req.getRequestDispatcher("/ViewBgs.jsp").forward(req, resp);
    }

}
