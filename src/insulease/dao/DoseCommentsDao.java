package insulease.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import insulease.model.BasalInsulin;
import insulease.model.BgComments;
import insulease.model.DoseComments;
import insulease.model.InsulinDoses;

public class DoseCommentsDao {
	
protected ConnectionManager connectionManager;
	
	// Singleton pattern: prevents database objects from being manipulated by multiple people simultaneously
		private static DoseCommentsDao instance = null;
		protected DoseCommentsDao() {
			connectionManager = new ConnectionManager();
		}
		
		public static DoseCommentsDao getInstance() {
			if(instance == null) {
				instance = new DoseCommentsDao();
			}
			return instance;
		}
		
		/**
		 *INSERT INTO DoseComments 
		 */
		public DoseComments create(DoseComments doseComment) throws SQLException {
			String insertDoseComments = "INSERT INTO DoseComments(DoseComment, DoseID) VALUES(?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			ResultSet resultKey = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertDoseComments, Statement.RETURN_GENERATED_KEYS);
				insertStmt.setString(1, doseComment.getDoseComment());
				insertStmt.setInt(2, doseComment.getDose().getDoseID());
				insertStmt.executeUpdate();
				resultKey = insertStmt.getGeneratedKeys();
				int doseCommentsID = -1;
				if(resultKey.next()) {
					doseCommentsID = resultKey.getInt(1);
				} else {
					throw new SQLException("Unable to retrieve auto-generated key.");
				}
				doseComment.setDoseCommentsID(doseCommentsID);
				return doseComment;
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
		 * DELETE FROM DoseComments
		 */
		public DoseComments delete(DoseComments doseComment) throws SQLException {
			String deleteDoseComment= "DELETE FROM DoseComments WHERE DoseCommentID=?;";
			Connection connection = null;
			PreparedStatement deleteStmt = null;
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteDoseComment);
				deleteStmt.setInt(1, doseComment.getDoseCommentId());
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
		 * SELECT FROM DoseComments WHERE BgCommentID=
		 */
		public DoseComments getDoseCommentFromDoseCommentId(int doseCommentID) throws SQLException {
			String selectBgComment = "SELECT * FROM DoseComments WHERE DoseCommentID=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectBgComment);
				selectStmt.setInt(1, doseCommentID);
				results = selectStmt.executeQuery();
				InsulinDosesDao insulinDosesDao = InsulinDosesDao.getInstance();
				if(results.next()) {
					int rDoseCommentID = results.getInt("DoseCommentID");
					String rComment = results.getString("DoseComment");
					int rDoseID = results.getInt("DoseID");
					InsulinDoses dose = insulinDosesDao.getInsulinDosesFromDoseID(rDoseID);
					DoseComments doseComment  = new DoseComments(rDoseCommentID, rComment, dose);
					return doseComment;
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
