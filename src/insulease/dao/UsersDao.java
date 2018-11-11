package insulease.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import insulease.dao.ConnectionManager;
import insulease.model.ContactInfo;
import insulease.model.Users;

public class UsersDao {
	
	protected ConnectionManager connectionManager;
	
	// Singleton pattern: prevents database objects from being manipulated by multiple people simultaneously
		private static UsersDao instance = null;
		protected UsersDao() {
			connectionManager = new ConnectionManager();
		}
		
		public static UsersDao getInstance() {
			if(instance == null) {
				instance = new UsersDao();
			}
			return instance;
		}
		
		
		/**
		 *INSERT INTO Users
		 */
		public Users create(Users user) throws SQLException {
			String insertUser = "INSERT INTO Users(UserName,UserPassword,ContactInfoId) VALUES(?,?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertUser);
				insertStmt.setString(1, user.getUserName());
				insertStmt.setString(2, user.getUserPassword());
				insertStmt.setInt(3, user.getContactInfo().getContactInfoID());
				insertStmt.executeUpdate();
				return user;
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
		 * DELETE FROM Users
		 */
		public Users delete(Users user) throws SQLException {
			String deleteUser = "DELETE FROM Users WHERE UserName=?;";
			Connection connection = null;
			PreparedStatement deleteStmt = null;
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteUser);
				deleteStmt.setString(1, user.getUserName());
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
		public Users getUserFromUserName(String userName) throws SQLException {
			String selectUser = "SELECT * FROM Users WHERE UserName=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectUser);
				selectStmt.setString(1, userName);
				// Note that we call executeQuery(). This is used for a SELECT statement
				// because it returns a result set. For more information, see:
				// http://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
				// http://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
				results = selectStmt.executeQuery();
				//Iterate through result set and make a new User object
				ContactInfoDao contactInfoDao = ContactInfoDao.getInstance();
				UsersDao usersDao = UsersDao.getInstance();
				if(results.next()) {
					String resultUserName = results.getString("UserName");
					String resultPassword = results.getString("UserPassword");
					int contactInfoID = results.getInt("ContactInfoID");
					ContactInfo resultContactInfo = contactInfoDao.getContactInfoFromContactInfoID(contactInfoID);
					
					Users user = new Users(resultUserName,resultPassword,resultContactInfo);
					return user;
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
