package insulease.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import insulease.model.Relationships;
import insulease.model.Relationships.RelType;

public class RelationshipsDao {
	protected ConnectionManager connectionManager;
	
	// Singleton pattern: prevents database objects from being manipulated by multiple people simultaneously
		private static UsersDao instance = null;
		protected RelationshipsDao() {
			connectionManager = new ConnectionManager();
		}
		
		public static UsersDao getInstance() {
			if(instance == null) {
				instance = new UsersDao();
			}
			return instance;
		}
		
		
		/**
		 *INSERT INTO Relationships
		 */
		public Relationships create(Relationships relationship) throws SQLException {
			String insertRelationship = "INSERT INTO Relationships(RelUserName, RelPtID, rel) VALUES(?,?);";
			Connection connection = null;
			PreparedStatement insertStmt = null;
			try {
				connection = connectionManager.getConnection();
				insertStmt = connection.prepareStatement(insertRelationship);
				insertStmt.setString(1, relationship.getRelUserName());
				insertStmt.setString(2, relationship.getRelPtID());
				insertStmt.setString(3, relationship.relToString());
				insertStmt.executeUpdate();
				return relationship;
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
		 * DELETE FROM Relationships
		 */
		public Relationships delete(Relationships relationship) throws SQLException {
			String deleteRelationship = "DELETE FROM Relationships WHERE RelID=?;";
			Connection connection = null;
			PreparedStatement deleteStmt = null;
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteRelationship);
				deleteStmt.setInt(1, relationship.getRelID());
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
		 * SELECT FROM Relationships WHERE RelID=
		 */
		public Relationships getRelationshipsFromRelID(int RelID) throws SQLException {
			String selectRelationship = "SELECT * FROM Relationships WHERE RelID=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectRelationship);
				selectStmt.setInt(1, RelID);
				results = selectStmt.executeQuery();
				//Iterate through result set and make a new User object
				if(results.next()) {
					int resultRelID = results.getInt("RelID");
					String resultRelUserName = results.getString("RelUserName");
					String resultRelPtID = results.getString("RelPtID");
					RelType resultRelType = Relationships.createType(results.getString("RelType"));
					Relationships relationship = new Relationships (resultRelID,resultRelUserName, resultRelPtID, resultRelType);
					return relationship;
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
