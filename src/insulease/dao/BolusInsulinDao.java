package insulease.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import insulease.model.BolusInsulin;
import insulease.model.BolusInsulin.BolusType;
import insulease.model.Regiment;

public class BolusInsulinDao {
protected ConnectionManager connectionManager;
	
	// Singleton pattern: prevents database objects from being manipulated by multiple people simultaneously
		private static BolusInsulinDao instance = null;
		protected BolusInsulinDao() {
			connectionManager = new ConnectionManager();
		}
		
		public static BolusInsulinDao getInstance() {
			if(instance == null) {
				instance = new BolusInsulinDao();
			}
			return instance;
		}
		
		
		/**
		 *INSERT INTO BolusInsulin
		 */
		public BolusInsulin create(BolusInsulin bolusInsulin) throws SQLException {
			String insertBolusInsulin = "INSERT INTO BolusInsulin(Brand, BolusType) VALUES(?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			ResultSet resultKey = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertBolusInsulin, Statement.RETURN_GENERATED_KEYS);
				insertStmt.setString(1, bolusInsulin.getBrand());
				insertStmt.setString(2, bolusInsulin.BolusTypeToString());
				insertStmt.executeUpdate();
				resultKey = insertStmt.getGeneratedKeys();
				int bolusID = -1;
				if(resultKey.next()) {
					bolusID = resultKey.getInt(1);
				} else {
					throw new SQLException("Unable to retrieve auto-generated key.");
				}
				bolusInsulin.setBolusID(bolusID);
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
		
		/**
		 * DELETE FROM BolusInsulin
		 */
		public BolusInsulin delete(BolusInsulin bolusInsulin) throws SQLException {
			String deleteBolusInsulin = "DELETE FROM BolusInsulin WHERE BolusID=?;";
			Connection connection = null;
			PreparedStatement deleteStmt = null;
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteBolusInsulin);
				deleteStmt.setInt(1, bolusInsulin.getBolusID());
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
		 * SELECT FROM BolusInsulin WHERE BolusID=
		 */
		public BolusInsulin getBolusInsulinFromBolusID(int bolusID) throws SQLException {
			String selectBolus = "SELECT * FROM BolusInsulin WHERE BolusID=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectBolus);
				selectStmt.setInt(1, bolusID);
				results = selectStmt.executeQuery();
				if(results.next()) {
					int rBolusID = results.getInt("BolusID");
					String rBrand = results.getString("Brand");
					BolusType rBolusType = BolusInsulin.StringToBolusType(results.getString("BolusType"));
					BolusInsulin bolus  = new BolusInsulin(rBolusID, rBrand, rBolusType);
					return bolus;
					
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
