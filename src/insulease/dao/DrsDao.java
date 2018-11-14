package insulease.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import insulease.model.ContactInfo;
import insulease.model.Drs;

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
			String insertDr = "INSERT INTO Drs(ContactInfoId,AffiliatedInstitution) VALUES(?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			ResultSet resultKey = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertDr, Statement.RETURN_GENERATED_KEYS);
				insertStmt.setInt(1, dr.getContactInfo().getContactInfoID());
				insertStmt.setString(2, dr.getAffiliatedInstitutionD());
				insertStmt.executeUpdate();
				resultKey = insertStmt.getGeneratedKeys();
				int contactInfoId = -1;
				if(resultKey.next()) {
					contactInfoId = resultKey.getInt(1);
				} else {
					throw new SQLException("Unable to retrieve auto-generated key.");
				}
				dr.setDrID(contactInfoId);
				return dr;
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
		 * DELETE FROM DrsDao
		 */
		public Drs delete(Drs dr) throws SQLException {
			String deleteDr = "DELETE FROM Doctors WHERE DrID=?;";
			Connection connection = null;
			PreparedStatement deleteStmt = null;
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteDr);
				deleteStmt.setInt(1, dr.getDrID());
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
		 * SELECT FROM Drs WHERE DrID=
		 */
		public Drs getDrFromDrID(int DrID) throws SQLException {
			String selectUser = "SELECT * FROM Drs WHERE DrID=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			ResultSet resultKey = null;

			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectUser);
				selectStmt.setInt(1, DrID);
				results = selectStmt.executeQuery();
				ContactInfoDao contactInfoDao = ContactInfoDao.getInstance();
				if(results.next()) {
					int rDrID = results.getInt("DrID");
					int rContactInfoID = results.getInt("ContactInfoID");
					String rAffiliated = results.getString("AffiliatedInstitution");
					ContactInfo contactInfo = contactInfoDao.getContactInfoFromContactInfoID(rContactInfoID);
					Drs dr = new Drs(rDrID, contactInfo, rAffiliated);
					return dr;
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
