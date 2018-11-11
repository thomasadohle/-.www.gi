package insulease.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import insulease.model.BolusInsulin;
import insulease.model.DrAppts;
import insulease.model.Drs;
import insulease.model.Patients;
import insulease.model.Regiment;
import insulease.model.BolusInsulin.BolusType;

public class DrApptsDao {
protected ConnectionManager connectionManager;
	
	// Singleton pattern: prevents database objects from being manipulated by multiple people simultaneously
		private static DrApptsDao instance = null;
		protected DrApptsDao() {
			connectionManager = new ConnectionManager();
		}
		
		public static DrApptsDao getInstance() {
			if(instance == null) {
				instance = new DrApptsDao();
			}
			return instance;
		}
		
		/**
		 *INSERT INTO DrAppts
		 */
		public DrAppts create(DrAppts drAppt) throws SQLException {
			String insertDrAppts = "INSERT INTO DrAppts(ApptDate, ApptTime, PtID, DrID) VALUES(?,?,?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			ResultSet resultKey = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertDrAppts);
				insertStmt.setDate(1, drAppt.getApptDate());
				insertStmt.setTime(2, drAppt.getApptTime());
				insertStmt.setString(3, drAppt.getPt().getPtID());
				insertStmt.setInt(4, drAppt.getDr().getDrID());
				insertStmt.executeUpdate();
				resultKey = insertStmt.getGeneratedKeys();
				int apptID = -1;
				if(resultKey.next()) {
					apptID = resultKey.getInt(1);
				} else {
					throw new SQLException("Unable to retrieve auto-generated key.");
				}
				drAppt.setApptID(apptID);;
				return drAppt;
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally {
				if(connection != null) {
					connection.close();
				}
				if(insertStmt != null) {
					insertStmt.close();
				}
			}
		}
		
		/**
		 * DELETE FROM DrAppts
		 */
		public DrAppts delete(DrAppts drAppt) throws SQLException {
			String deleteDrAppts = "DELETE FROM DrAppts WHERE ApptID=?;";
			Connection connection = null;
			PreparedStatement deleteStmt = null;
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteDrAppts);
				deleteStmt.setInt(1, drAppt.getApptID());
				deleteStmt.executeUpdate();

				// Return null so the caller can no longer operate on the Persons instance.
				return null;
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally {
				if(connection != null) {
					connection.close();
				}
				if(deleteStmt != null) {
					deleteStmt.close();
				}
			}
		}
		
		/**
		 * SELECT FROM DrAppts WHERE ApptID=
		 */
		public DrAppts getApptFromApptID(int apptID) throws SQLException {
			String selectDrAppts = "SELECT * FROM DrAppts WHERE ApptID=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectDrAppts);
				selectStmt.setInt(1, apptID);
				results = selectStmt.executeQuery();
				DrsDao drsDao = DrsDao.getInstance();
				PatientsDao patientsDao = PatientsDao.getInstance();
				if(results.next()) {
					int rApptID = results.getInt("ApptID");
					Date rDate = results.getDate("ApptDate");
					Time rTime = results.getTime("ApptTime");
					String rPtID = results.getString("PtID");
					int rDrID = results.getInt("DrID");
					Drs dr = drsDao.getDrFromDrID(rDrID);
					Patients pt = patientsDao.getPatientFromPtID(rPtID);
					DrAppts appt  = new DrAppts (rApptID, rDate, rTime, pt, dr);
					return appt;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally {
				if(connection != null) {
					connection.close();
				}
				if(selectStmt != null) {
					selectStmt.close();
				}
				if(results != null) {
					results.close();
				}
			}
			return null;
		}

}
