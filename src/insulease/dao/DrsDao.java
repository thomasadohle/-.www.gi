package insulease.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import insulease.model.Regiment;

public class DrsDao {
protected ConnectionManager connectionManager;
	
	// Singleton pattern: prevents database objects from being manipulated by multiple people simultaneously
		private static DrsDao instance = null;
		protected DrsDao() {
			connectionManager = new ConnectionManager();
		}
		
		public static DrsDao getInstance() {
			if(instance == null) {
				instance = new DrsDao();
			}
			return instance;
		}
		
		
		/**
		 *INSERT INTO Drs
		 */
		public Drs create(Drs dr) throws SQLException {
			String insertDr = "INSERT INTO Drs() VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertRegiment);
				insertStmt.setString(1, regiment.getPtID());
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
				insertStmt.setInt(12,regiment.getBasalID());
				insertStmt.setInt(13, regiment.getBolusID());
				insertStmt.setInt(14, regiment.getDrID());
				insertStmt.executeUpdate();
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
}
