package insulease.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import insulease.model.BgComments;
import insulease.model.BloodGlucoses;
import insulease.model.BolusInsulin;
import insulease.model.Patients;

public class BloodGlucosesDao {
protected ConnectionManager connectionManager;
	
	// Singleton pattern: prevents database objects from being manipulated by multiple people simultaneously
		private static BloodGlucosesDao instance = null;
		protected BloodGlucosesDao() {
			connectionManager = new ConnectionManager();
		}
		
		public static BloodGlucosesDao getInstance() {
			if(instance == null) {
				instance = new BloodGlucosesDao();
			}
			return instance;
		}
		
		/**
		 *INSERT INTO BloodGlucoses
		 */
		public BloodGlucoses create(BloodGlucoses bloodGlucose) throws SQLException {
			String insertBloodGlucoses = "INSERT INTO BloodGlucoses(BgDate, BgTime, PtID, BloodGlucose) VALUES(?,?,?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertBloodGlucoses, Statement.RETURN_GENERATED_KEYS);
				insertStmt.setString(1, bloodGlucose.getBgDate());
				insertStmt.setString(2, bloodGlucose.getBgTime());
				insertStmt.setString(3, bloodGlucose.getPt().getPtID());
				insertStmt.setInt(4, bloodGlucose.getBloodGlucose());
				insertStmt.executeUpdate();
				ResultSet resultKey = null;
				resultKey = insertStmt.getGeneratedKeys();
				int bgID = -1;
				if(resultKey.next()) {
					bgID = resultKey.getInt(1);
				} else {
					throw new SQLException("Unable to retrieve auto-generated key.");
				}
				bloodGlucose.setBgID(bgID);
				return bloodGlucose;
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
		 * DELETE FROM BloodGlucoses
		 */
		public BloodGlucoses delete(BloodGlucoses bg) throws SQLException {
			String deleteBG = "DELETE FROM BloodGlucoses WHERE BgID=?;";
			Connection connection = null;
			PreparedStatement deleteStmt = null;
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteBG);
				deleteStmt.setInt(1, bg.getBgID());
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
		 * SELECT FROM BloodGlucoses WHERE BgID=
		 */
		public BloodGlucoses getBgFromBgId(int bgID) throws SQLException {
			String selectBgComment = "SELECT * FROM BloodGlucoses WHERE BgID=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectBgComment);
				selectStmt.setInt(1, bgID);
				results = selectStmt.executeQuery();
				PatientsDao patientsDao = PatientsDao.getInstance();
				if(results.next()) {
					int rBgID = results.getInt("BgID");
					String rPtID = results.getString("PtID");
					String rDate = results.getString("BgDate");
					String rTime = results.getString("BgTime");
					int rBg = results.getInt("BloodGlucose");
					Patients pt = patientsDao.getPatientFromPtID(rPtID);
					BloodGlucoses bg = new BloodGlucoses(rBgID, rDate, rTime, pt, rBg);
					return bg;
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
		
		/**
		 * SELECT FROM BloodGlucoses WHERE PtID= LIMIT 10
		 */
		public List<BloodGlucoses> getBgFromPtID(String PtID) throws SQLException {
			String selectBgValues = "SELECT * FROM BloodGlucoses WHERE PtID=? LIMIT 10;";
			List<BloodGlucoses> BgList = new ArrayList<BloodGlucoses>();
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectBgValues);
				selectStmt.setString(1, PtID);
				results = selectStmt.executeQuery();
				PatientsDao patientsDao = PatientsDao.getInstance();
				while(results.next()) {
					int rBgID = results.getInt("BgID");
					String rPtID = results.getString("PtID");
					String rDate = results.getString("BgDate");
					String rTime = results.getString("BgTime");
					int rBg = results.getInt("BloodGlucose");
					Patients pt = patientsDao.getPatientFromPtID(rPtID);
					BloodGlucoses bg = new BloodGlucoses(rBgID, rDate, rTime, pt, rBg);
					BgList.add(bg);
			
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
			return BgList;
		}
		
		/**
		 * Update the BloodGlucose of the BloodGlucoses.
		 * 
		 */
		public BloodGlucoses updateBg(BloodGlucoses bg, int newBgVal) throws SQLException {
			String updateBlogComment = "UPDATE BloodGlucoses SET BloodGlucose=? WHERE BgID=?;";
			Connection connection = null;
			PreparedStatement updateStmt = null;
			try {
				connection = connectionManager.getConnection();
				updateStmt = connection.prepareStatement(updateBlogComment);
				updateStmt.setInt(1, newBgVal);
				updateStmt.setInt(2, bg.getBgID());
				updateStmt.executeUpdate();

				// Update the blogComment param before returning to the caller.
				bg.setBloodGlucose(newBgVal);
				
				return bg;
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally {
				if(connection != null) {
					connection.close();
				}
				if(updateStmt != null) {
					updateStmt.close();
				}
			}
		}
}
