package insulease.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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




@WebServlet("/EditBg")
public class EditBg  extends HttpServlet{
protected BloodGlucosesDao bgDao;
	
	@Override
	public void init() throws ServletException {
		bgDao = BloodGlucosesDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String bgIDString = req.getParameter("bgID");
        String newBgString = req.getParameter("newBgVal");
        
        
        if (bgIDString == null || bgIDString.trim().isEmpty() || newBgString ==null || newBgString.trim().isEmpty()) {
            messages.put("success", "Please enter a valid BgID.");
        } else {
        	try {
        		int newBg = Integer.parseInt(newBgString);
                int bgID = Integer.parseInt(bgIDString);
        		BloodGlucoses bg = bgDao.getBgFromBgId(bgID);
        		if(bg == null) {
        			messages.put("success", "UserName does not exist.");
        		}
        		req.setAttribute("newBgObject", bg);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/EditBg.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String stringBgID = req.getParameter("bgID");
        if (stringBgID == null || stringBgID.trim().isEmpty()) {
            messages.put("success", "Please enter a valid BgID.");
        } else {
        	try {
        		int bgID = Integer.parseInt(stringBgID);
        		BloodGlucoses bg = bgDao.getBgFromBgId(bgID);
        		if(bg == null) {
        			messages.put("success", "BgID. No update to perform.");
        		} else {
        			String newBgString = req.getParameter("newBgVal");
        			int newBg = Integer.parseInt(newBgString);
        			if (newBgString == null || newBgString.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid new Bg Value.");
        	        } else {
        	        	bg = bgDao.updateBg(bgDao.getBgFromBgId(bgID), newBg);
        	        	messages.put("success", "Successfully updated record with BgID " + bgID );
        	        }
        		}
        		req.setAttribute("newBgObject", bg);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/EditBg.jsp").forward(req, resp);
    }

}
