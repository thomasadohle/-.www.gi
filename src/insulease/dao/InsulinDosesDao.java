package insulease.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import insulease.model.BloodGlucoses;
import insulease.model.InsulinDoses;
import insulease.model.InsulinDoses.DoseType;
import insulease.model.Patients;



public class InsulinDosesDao {
protected ConnectionManager connectionManager;
	
	// Singleton pattern: prevents database objects from being manipulated by multiple people simultaneously
		private static InsulinDosesDao instance = null;
		protected InsulinDosesDao() {
			connectionManager = new ConnectionManager();
		}
		
		public static InsulinDosesDao getInstance() {
			if(instance == null) {
				instance = new InsulinDosesDao();
			}
			return instance;
		}
		
		
		
		/**
		 *INSERT INTO InsulinDoses
		 */
		public InsulinDoses create(InsulinDoses insulinDoses) throws SQLException {
			String insertInsulinDoses = "INSERT INTO InsulinDoses(PtID, DoseDate, DoseTime, DoseType, CarbCount, BgId, CalculatedDose, ActualDose) VALUES(?,?,?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			ResultSet resultKey = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertInsulinDoses);
				insertStmt.setString(1, insulinDoses.getPt().getPtID());
				insertStmt.setDate(2, insulinDoses.getDoseDate());
				insertStmt.setTime(3, insulinDoses.getDoseTime());
				insertStmt.setString(4, insulinDoses.DoseTypeToString());
				insertStmt.setInt(5, insulinDoses.getCarbCount());
				insertStmt.setInt(6, insulinDoses.getBg().getBgID());
				insertStmt.setDouble(7, insulinDoses.getCalcualtedDose());
				insertStmt.setDouble(8, insulinDoses.getActualDose());
				insertStmt.executeUpdate();
				resultKey = insertStmt.getGeneratedKeys();
				int doseID = -1;
				if(resultKey.next()) {
					doseID = resultKey.getInt(1);
				} else {
					throw new SQLException("Unable to retrieve auto-generated key.");
				}
				insulinDoses.setIDoseID(doseID);
				return insulinDoses;
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
		 * DELETE FROM InsulinDoses
		 */
		public InsulinDoses delete(InsulinDoses insulinDoses) throws SQLException {
			String deleteInsulinDoses = "DELETE FROM InsulinDoses WHERE DoseID=?;";
			Connection connection = null;
			PreparedStatement deleteStmt = null;
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteInsulinDoses);
				deleteStmt.setInt(1, insulinDoses.getDoseID());
				deleteStmt.executeUpdate();

			
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
		 * SELECT FROM InsulinDoses WHERE DoseID=
		 */
		public InsulinDoses getInsulinDosesFromDoseID(int doseID) throws SQLException {
			String selectInsulin = "SELECT * FROM InsulinDoses WHERE DoseID=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectInsulin);
				selectStmt.setInt(1, doseID);
				results = selectStmt.executeQuery();
				PatientsDao patientsDao = PatientsDao.getInstance();
				BloodGlucosesDao bloodGlucosesDao = BloodGlucosesDao.getInstance();
				if(results.next()) {
					String iPatientId = results.getString("PtID");
					Date iDoseDate = results.getDate("DoseDate");
					Time iDoseTime = results.getTime("DoseTime");
					DoseType iDoseType = InsulinDoses.StringToDoseType("DoseType");
					int iCarbCount = results.getInt("CarbCount");
					int iBgId = results.getInt("BgId");
					double iCalculatedDose = results.getDouble("CalculatedDose");
					double iActualDose = results.getDouble("ActualDose");
					Patients pt = patientsDao.getPatientFromPtID(iPatientId);
					BloodGlucoses bg = bloodGlucosesDao.getBgFromBgId(iBgId);
								
					InsulinDoses insulinDose = new InsulinDoses(pt, iDoseDate, iDoseTime, iDoseType, iCarbCount, bg, iCalculatedDose, iActualDose);
					return insulinDose;
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
		 * Update the ActualDose of the InsulinDoses instance. This runs a UPDATE
		 * statement.
		 */
		public InsulinDoses updateExpiration(InsulinDoses insulinDose, double newActualDose) throws SQLException {
			String updateInsulinDose = "UPDATE InsulinDoses SET ActualDose=? WHERE DoseId=?;";
			Connection connection = null;
			PreparedStatement updateStmt = null;
			try {
				connection = connectionManager.getConnection();
				updateStmt = connection.prepareStatement(updateInsulinDose);
				updateStmt.setDouble(1, newActualDose);
				updateStmt.setDouble(2, insulinDose.getActualDose());
				updateStmt.executeUpdate();

				insulinDose.setActualDose(newActualDose);
				return insulinDose;
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally {
				if (connection != null) {
					connection.close();
				}
				if (updateStmt != null) {
					updateStmt.close();
				}
			}
		}
			
			

}