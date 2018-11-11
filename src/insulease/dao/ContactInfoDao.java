package insulease.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import insulease.model.ContactInfo;

public class ContactInfoDao {
	protected ConnectionManager connectionManager;

	
// Singleton pattern: prevents database objects from being manipulated by multiple people simultaneously
		private static ContactInfoDao instance = null;
		protected ContactInfoDao() {
			connectionManager = new ConnectionManager();
		}
		
		public static ContactInfoDao getInstance() {
			if(instance == null) {
				instance = new ContactInfoDao();
			}
			return instance;
		}
		
		

		/**
		 *INSERT INTO ContactInfo
		 */
		public ContactInfo create(ContactInfo contactInfo) throws SQLException {
			String insertContactInfo = "INSERT INTO ContactInfo(FirstName, LastName, DOB, Street1, "
					+ "Street2, City, State, ZipCode, Email, Gender, ContactImage) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			ResultSet resultKey = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertContactInfo, Statement.RETURN_GENERATED_KEYS);
				insertStmt.setString(1, contactInfo.getFirstName());
				insertStmt.setString(2, contactInfo.getLastName());
				insertStmt.setDate(3, contactInfo.getDOB());
				insertStmt.setString(4, contactInfo.getStreet1());
				insertStmt.setString(5, contactInfo.getStreet2());
				insertStmt.setString(6, contactInfo.getCity());
				insertStmt.setString(7, contactInfo.getState());
				insertStmt.setInt(8, contactInfo.getZipCode());
				insertStmt.setString(9, contactInfo.getEmail());
				insertStmt.setString(10, contactInfo.getGender());
				insertStmt.setString(11,contactInfo.getContactImage());
				insertStmt.executeUpdate();
				resultKey = insertStmt.getGeneratedKeys();
				int contactInfoId = -1;
				if(resultKey.next()) {
					contactInfoId = resultKey.getInt(1);
				} else {
					throw new SQLException("Unable to retrieve auto-generated key.");
				}
				contactInfo.setContactInfoID(contactInfoId);
				return contactInfo;
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
		 * DELETE FROM ContactInfo
		 */
		public ContactInfo delete(ContactInfo contactInfo) throws SQLException {
			String deleteContactInfo = "DELETE FROM ContactInfo WHERE ContactInfoID=?;";
			Connection connection = null;
			PreparedStatement deleteStmt = null;
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteContactInfo);
				deleteStmt.setInt(1, contactInfo.getContactInfoID());
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
		 * SELECT FROM ContactInfo WHERE ContactInfoID=
		 */
		public ContactInfo getContactInfoFromContactInfoID(int contactInfoID) throws SQLException {
			String selectContactInfo = "SELECT * FROM ContactInfo WHERE ContactInfoID=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectContactInfo);
				selectStmt.setInt(1, contactInfoID);
				results = selectStmt.executeQuery();
				if(results.next()) {
					int rContactInfoID = results.getInt("ContactInfoID");
					String rFirstName = results.getString("FirstName");
					String rLastName = results.getString("LastName");
					Date rDOB = results.getDate("DOB");
					String rStreet1 = results.getString("Street1");
					String rStreet2 = results.getString("Street2");
					String rCity = results.getString("City");
					String rState = results.getString("State");
					int rZip = results.getInt("ZipCode");
					String rEmail = results.getString("Email");
					String rGender = results.getString("Gender");
					String rContactImage = results.getString("ContactImage");
					
					ContactInfo contactInfo = new ContactInfo(rContactInfoID, rFirstName, rLastName, rDOB, rStreet1, rStreet2,
							rCity, rState, rZip, rEmail, rGender, rContactImage);
					return contactInfo;
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
