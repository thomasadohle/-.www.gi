package insulease.servlet;

import javax.servlet.annotation.WebServlet;
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


import insulease.dao.BloodGlucosesDao;
import insulease.model.BloodGlucoses;

@WebServlet("/DeleteBg")
public class DeleteBg extends HttpServlet{
protected BloodGlucosesDao dao;
	
	@Override
	public void init() throws ServletException {
		dao = BloodGlucosesDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        // Provide a title and render the JSP.
        messages.put("title", "Delete Blood Glucose Reading");        
        req.getRequestDispatcher("/DeleteBg.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String bgIDString = req.getParameter("BgID");
        if (bgIDString == null || bgIDString.trim().isEmpty()) {
        	
            messages.put("title", "Invalid BgID");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the BlogUser.
        	int bgID = Integer.parseInt(bgIDString);
	        BloodGlucoses bg = new BloodGlucoses(bgID);
	        try {
	        	bg = dao.delete(bg);
	        	// Update the message.
		        if (bg == null) {
		            messages.put("title", "Successfully deleted Bg ID " + bgIDString);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete Bg ID " + bgIDString);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/DeleteBg.jsp").forward(req, resp);
    }

}
