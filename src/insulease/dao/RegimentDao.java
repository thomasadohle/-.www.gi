package insulease.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import insulease.model.BasalInsulin;
import insulease.model.BolusInsulin;
import insulease.model.Drs;
import insulease.model.Patients;
import insulease.model.Regiment;

public class RegimentDao {
protected ConnectionManager connectionManager;
	
	// Singleton pattern: prevents database objects from being manipulated by multiple people simultaneously
		private static RegimentDao instance = null;
		protected RegimentDao() {
			connectionManager = new ConnectionManager();
		}
		
		public static RegimentDao getInstance() {
			if(instance == null) {
				instance = new RegimentDao();
			}
			return instance;
		}
		
		
		/**
		 *INSERT INTO Regiment
		 */
		public Regiment create(Regiment regiment) throws SQLException {
			String insertRegiment = "INSERT INTO Regiment(PtID, RegimentDate, A1C, DaytimeTarget, NighttimeTarget, "
					+ "DaytimeCorrection, NighttimeCorrection, BreakfastRatio, LunchRatio, DinnerRatio, BedTimeRatio, "
					+ "BasalId, BolusId, DrID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			ResultSet resultKey = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertRegiment);
				insertStmt.setString(1, regiment.getPt().getPtID());
				insertStmt.setDate(2, regiment.getRegimentDate());
				insertStmt.setDouble(3, regiment.getA1C());
				insertStmt.setInt(4, regiment.getDayTimeTarget());
				insertStmt.setInt(5, regiment.getNighttimeTarget());
				insertStmt.setDouble(6, regiment.getDaytimeCorrection());
				insertStmt.setDouble(7, regiment.getNighttimeCorrection());
				insertStmt.setDouble(8, regiment.getBreakfastRatio());
				insertStmt.setDouble(9, regiment.getLunchRatio());
				insertStmt.setDouble(10, regiment.getDinnerRatio());
				insertStmt.setDouble(11,regiment.getBedtimeRatio());
				insertStmt.setInt(12,regiment.getBasal().getBasalID());
				insertStmt.setInt(13, regiment.getBolus().getBolusID());
				insertStmt.setInt(14, regiment.getDr().getDrID());
				insertStmt.executeUpdate();
				resultKey = insertStmt.getGeneratedKeys();
				int regimentID = -1;
				if(resultKey.next()) {
					regimentID = resultKey.getInt(1);
				} else {
					throw new SQLException("Unable to retrieve auto-generated key.");
				}
				regiment.setRegimentID(regimentID);
				return regiment;
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
		 * DELETE FROM Regiment
		 */
		public Regiment delete(Regiment regiment) throws SQLException {
			String deleteRegiment = "DELETE FROM Regiment WHERE RegimentID=?;";
			Connection connection = null;
			PreparedStatement deleteStmt = null;
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteRegiment);
				deleteStmt.setInt(1, regiment.getRegimentID());
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
		 * SELECT FROM Users WHERE UserName=
		 */
		public Regiment getRegimentFromRegimentID(int regimentid) throws SQLException {
			String selectUser = "SELECT * FROM Users WHERE RegimentID=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectUser);
				selectStmt.setInt(1, regimentid);
				results = selectStmt.executeQuery();
				PatientsDao patientsDao = PatientsDao.getInstance();
				BasalInsulinDao basalDao = BasalInsulinDao.getInstance();
				BolusInsulinDao bolusDao = BolusInsulinDao.getInstance();
				DrsDao drsDao = DrsDao.getInstance();
				if(results.next()) {
					int rRegimentId = results.getInt("RegimentID");
					String rPatientId = results.getString("PtID");
					Date rRegimentDate = results.getDate("RegimentDate");
					double rA1C = results.getDouble("A1C");
					int rDaytimeTarget = results.getInt("DayTimeTarget");
					int rNighttimeTarget = results.getInt("NighttimeTarget");
					int rDaytimeCorrection = results.getInt("DaytimeCorrection");
					int rNighttimeCorrection = results.getInt("NighttimeCorrection");
					double rBreakfastRatio = results.getDouble("BreakfastRatio:");
					double rLunchRatio = results.getDouble("LunchRatio");
					double rDinnerRatio = results.getDouble("DinnerRatio");
					double rBedtimeRatio = results.getDouble("BedtimeRatio");
					int rBasalId = results.getInt("BasalID");
					int rBolusId = results.getInt("BolusID");
					int rDrId = results.getInt("DrID");
					Patients pt = patientsDao.getPatientFromPtID(rPatientId);
					BasalInsulin basal = basalDao.getBasalInsulinFromBasalID(rBasalId);
					BolusInsulin bolus = bolusDao.getBolusInsulinFromBolusID(rBolusId);
					Drs dr = drsDao.getDrFromDrID(rDrId);
					
					Regiment regiment = new Regiment(rRegimentId, pt, rRegimentDate, rA1C, rDaytimeTarget, 
							rNighttimeTarget, rDaytimeCorrection, rNighttimeCorrection, rBreakfastRatio, 
							rLunchRatio, rDinnerRatio, rBedtimeRatio, basal, bolus, dr);
					return regiment;
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
	 * Update double values
	 * This runs a UPDATE statement.
	 */
	public Regiment updateRegiment(Regiment regiment, String attribute, double value ) throws SQLException {
		String attributeToUpdate = "";
		if (attribute.equals("A1C") || attribute.equals("BreakfastRatio") || attribute.equals("LunchRatio") || 
				attribute.equals("DinnerRatio") || attribute.equals("BedtimeRatio")) {attributeToUpdate = attribute;}
		else {throw new IllegalArgumentException("The parameter passed to update the regiment is invalid");}
		
		String updateAbout = "UPDATE Regiment SET " + attributeToUpdate + "=? WHERE RegimentID=?;";
		System.out.println(updateAbout);
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateAbout);
			updateStmt.setDouble(1, value);
			updateStmt.setInt(2, regiment.getRegimentID());
			updateStmt.executeUpdate();
			System.out.println(updateStmt.toString());
			// Update the person param before returning to the caller.
			if (attribute.equals("A1C")) {regiment.setA1C(value);}
			else if (attribute.equals("BreakfastRatio")) {regiment.setBreakfastRatio(value);}
			else if (attribute.equals("LunchRatio")) {regiment.setLunchRatio(value);}
			else if (attribute.equals("DinnerRatio")) {regiment.setDinnerRatio(value);}
			else if (attribute.equals("BedtimeRatio")) {regiment.setBreakfastRatio(value);}
			// Need to update the regiment date upon any updates regiment.setRegimentDate(new Date());
			return regiment;
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
	
	/**
	 * Update int values
	 * This runs a UPDATE statement.
	 */
	public Regiment updateRegiment(Regiment regiment, String attribute, int value ) throws SQLException {
		String attributeToUpdate = "";
		if (attribute.equals("DaytimeTarget") || attribute.equals("NighttimeTarget") || 
				attribute.equals("DaytimeCorrection") || attribute.equals("NighttimeCorrection")) {attributeToUpdate += attribute;}
		else {throw new IllegalArgumentException("The parameter passed to update the regiment is invalid");}
		
		String updateAbout = "UPDATE Regiment SET " + attributeToUpdate + "=? WHERE RegimentID=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateAbout);
			updateStmt.setDouble(1, value);
			updateStmt.setInt(2, regiment.getRegimentID());
			updateStmt.executeUpdate();
			
			// Update the person param before returning to the caller.
			if (attribute.equals("DayTimeTarget")) {regiment.setDayTimeTarget(value);}
			else if (attribute.equals("NighttimeTarget")) {regiment.setNighttimeTarget(value);}
			else if (attribute.equals("DaytimeCorrection")) {regiment.setDaytimeCorrection(value);}
			else if (attribute.equals("NighttimeCorrection")) {regiment.setNighttimeCorrection(value);}
			//Need to update the date regardless. Don't know how
			return regiment;
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
