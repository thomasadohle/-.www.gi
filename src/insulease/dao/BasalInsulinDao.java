package insulease.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import insulease.model.BasalInsulin;
import insulease.model.BolusInsulin;
import insulease.model.Regiment;
import insulease.model.BolusInsulin.BolusType;

public class BasalInsulinDao {
	
protected ConnectionManager connectionManager;
	
	// Singleton pattern: prevents database objects from being manipulated by multiple people simultaneously
		private static BasalInsulinDao instance = null;
		protected BasalInsulinDao() {
			connectionManager = new ConnectionManager();
		}
		
		public static BasalInsulinDao getInstance() {
			if(instance == null) {
				instance = new BasalInsulinDao();
			}
			return instance;
		}
		
		/**
		 *INSERT INTO BasalInsulin
		 */
		public BasalInsulin create(BasalInsulin basalInsulin) throws SQLException {
			String insertBasalInsulin = "INSERT INTO BasalInsulin(Brand, Frequency, PtID) VALUES(?,?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			ResultSet resultKey = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertBasalInsulin);
				insertStmt.setString(1, basalInsulin.getBrand());
				insertStmt.setInt(2, basalInsulin.getFrequency());
				insertStmt.executeUpdate();
				resultKey = insertStmt.getGeneratedKeys();
				int basalID = -1;
				if(resultKey.next()) {
					basalID = resultKey.getInt(1);
				} else {
					throw new SQLException("Unable to retrieve auto-generated key.");
				}
				basalInsulin.setBasalID(basalID);
				return basalInsulin;
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
		 * DELETE FROM BasalInsulin
		 */
		public BasalInsulin delete(BasalInsulin basalInsulin) throws SQLException {
			String deleteBasalInsulin = "DELETE FROM BasalInsulin WHERE BasalID=?;";
			Connection connection = null;
			PreparedStatement deleteStmt = null;
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteBasalInsulin);
				deleteStmt.setInt(1, basalInsulin.getBasalID());
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
		 * SELECT FROM BasalInsulin WHERE BasalID=
		 */
		public BasalInsulin getBasalInsulinFromBasalID(int basalID) throws SQLException {
			String selectBasal = "SELECT * FROM BasalInsulin WHERE BasalID=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectBasal);
				selectStmt.setInt(1, basalID);
				results = selectStmt.executeQuery();
				if(results.next()) {
					int rBasalID = results.getInt("BasalID");
					String rBrand = results.getString("Brand");
					int rFrequency = results.getInt("Frequency");
					BasalInsulin basal  = new BasalInsulin(rBasalID, rBrand, rFrequency);
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
		public BasalInsulin updateContent(BasalInsulin basalInsulin, String newBrand) throws SQLException {
			String updateContent= "UPDATE BasalInsulin SET Brand=? WHERE BasalID=?;";
			Connection connection = null;
			PreparedStatement updateStmt = null;
			try {
				connection = connectionManager.getConnection();
				updateStmt = connection.prepareStatement(updateContent);
				updateStmt.setString(1, newBrand);
				updateStmt.setInt(2, basalInsulin.getBasalID());
				updateStmt.executeUpdate();

				// Update the blogPost param before returning to the caller.
				basalInsulin.setBrand(newBrand);
				return basalInsulin;
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
