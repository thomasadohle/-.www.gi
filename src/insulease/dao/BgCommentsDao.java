package insulease.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import insulease.model.BasalInsulin;
import insulease.model.BgComments;
import insulease.model.BloodGlucoses;
import insulease.model.Patients;

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
			String insertBgComments = "INSERT INTO BgComments(CommentText, BgID) VALUES(?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			ResultSet resultKey = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertBgComments);
				insertStmt.setString(1, bgComment.getCommentText());
				insertStmt.setInt(2, bgComment.getBg().getBgID());
				insertStmt.executeUpdate();
				resultKey = insertStmt.getGeneratedKeys();
				int bgCommentsID = -1;
				if(resultKey.next()) {
					bgCommentsID = resultKey.getInt(1);
				} else {
					throw new SQLException("Unable to retrieve auto-generated key.");
				}
				bgComment.setBgCommentID(bgCommentsID);;
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
				deleteStmt.setInt(1, bgComment.getBg().getBgID());
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
				BloodGlucosesDao bloodGlucosesDao = BloodGlucosesDao.getInstance();
				if(results.next()) {
					int rBgCommentID = results.getInt("BgCommentID");
					String rCommentText = results.getString("CommentText");
					int rBgID = results.getInt("BgID");
					String rPtID = results.getString("PtID");
					BloodGlucoses bg = bloodGlucosesDao.getBgFromBgId(rBgID);
					BgComments bgComment  = new BgComments(rBgCommentID,rCommentText,bg );
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
