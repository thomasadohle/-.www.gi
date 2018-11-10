package insulease.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import insulease.model.BasalInsulin;
import insulease.model.BgComments;

public class BgCommentsDao {
	
protected ConnectionManager connectionManager;
	
	// Singleton pattern: prevents database objects from being manipulated by multiple people simultaneously
		private static BgCommentsDao instance = null;
		protected BgCommentsDao() {
			connectionManager = new ConnectionManager();
		}
		
		public static BgCommentsDao getInstance() {
			if(instance == null) {
				instance = new BgCommentsDao();
			}
			return instance;
		}
		
		/**
		 *INSERT INTO BgComments 
		 */
		public BgComments create(BgComments bgComment) throws SQLException {
			String insertBgComments = "INSERT INTO BgComments(PtID, CommentText, BgID) VALUES(?,?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertBgComments);
				insertStmt.setString(1, bgComment.getPtID());
				insertStmt.setString(2, bgComment.getCommentText());
				insertStmt.setInt(3, bgComment.getBgID());
				insertStmt.executeUpdate();
				return bgComment;
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
		 * DELETE FROM BgComments
		 */
		public BgComments delete(BgComments bgComment) throws SQLException {
			String deleteBasalInsulin = "DELETE FROM BgComments WHERE BgCommentID=?;";
			Connection connection = null;
			PreparedStatement deleteStmt = null;
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteBasalInsulin);
				deleteStmt.setInt(1, bgComment.getBgID());
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
		 * SELECT FROM BgComments WHERE BgCommentID=
		 */
		public BgComments getBgCommentFromBgCommentId(int bgCommentID) throws SQLException {
			String selectBgComment = "SELECT * FROM BgComments WHERE BgCommentID=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectBgComment);
				selectStmt.setInt(1, bgCommentID);
				results = selectStmt.executeQuery();
				if(results.next()) {
					int rBgCommentID = results.getInt("BgCommentID");
					String rPtID = results.getString("PatientID");
					String rCommentText = results.getString("CommentText");
					int rBgID = results.getInt("BgID");
					BgComments bgComment  = new BgComments(rBgCommentID,rPtID,rCommentText,rBgID );
					return bgComment;
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
