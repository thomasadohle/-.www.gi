package insulease.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import insulease.model.BloodGlucoses;
import insulease.model.BolusInsulin;

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
		 *INSERT INTO BolusInsulin
		 */
		public BloodGlucoses create(BloodGlucoses bloodGlucose) throws SQLException {
			String insertBloodGlucoses = "INSERT INTO BloodGlucoses(BgDate, BgTime, PtID, BloodGlucose) VALUES(?,?,?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertBloodGlucoses);
				insertStmt.setDate(1, bloodGlucose.getBgDate());
				insertStmt.setTime(2, bloodGlucose.getBgTime());
				insertStmt.setString(3, bolusInsulin.getPtID());
				insertStmt.executeUpdate();
				return bolusInsulin;
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
		

}
