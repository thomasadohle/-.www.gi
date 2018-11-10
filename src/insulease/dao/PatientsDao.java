package insulease.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import insulease.model.Patients;

public class PatientsDao {
protected ConnectionManager connectionManager;
	
	// Singleton pattern: prevents database objects from being manipulated by multiple people simultaneously
		private static PatientsDao instance = null;
		protected PatientsDao() {
			connectionManager = new ConnectionManager();
		}
		
		public static PatientsDao getInstance() {
			if(instance == null) {
				instance = new PatientsDao();
			}
			return instance;
		}
		
		
		/**
		 *INSERT INTO Patients
		 */
		public Patients create(Patients patient) throws SQLException {
			String insertPatient = "INSERT INTO Patients(MasterUserID, PtContactInfoID) VALUES(?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertPatient);
				insertStmt.setString(1, patient.getMasterUserID());
				insertStmt.setInt(2, patient.getPtContactInfoID());
				insertStmt.executeUpdate();
				return patient;
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
		 * DELETE FROM Patients
		 */
		public Patients delete(Patients patient) throws SQLException {
			String deletePatient = "DELETE FROM Patients WHERE PtID=?;";
			Connection connection = null;
			PreparedStatement deleteStmt = null;
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deletePatient);
				deleteStmt.setInt(1, patient.getPtID());
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
		 * SELECT FROM Patients WHERE PtID=
		 */
		public Patients getPatientFromPtID(int PtId) throws SQLException {
			String selectPatient = "SELECT * FROM Patients WHERE PtID=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectPatient);
				selectStmt.setInt(1, PtId);
				results = selectStmt.executeQuery();
				if(results.next()) {
					int rPtID = results.getInt("PtID");
					String rMasterUserId = results.getString("MasterUserID");
					int rContactInfoID = results.getInt("PtContactInfoID");
					Patients patient = new Patients(rPtID, rMasterUserId, rContactInfoID);
					return patient;
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
