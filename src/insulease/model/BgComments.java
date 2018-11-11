package insulease.model;

/*
 * BgCommentID INT AUTO_INCREMENT,
    PtID VARCHAR(255),
    CommentText TEXT,
    BgID INT,
 */
public class BgComments {
	private int BgCommentID;
	private String CommentText;
	private BloodGlucoses Bg;
	
	/*
	 * Constructor using auto-generated BgCommentId
	 */
	public BgComments (int BgCommentID, String CommentText, BloodGlucoses bg) {
		this.BgCommentID=BgCommentID;
		this.CommentText=CommentText;
		this.Bg=bg;
	}
	
	/*
	 * Constructor not using auto-generated BgCommentId
	 */
	public BgComments (String PtID, String CommentText, BloodGlucoses bg) {
		this.CommentText=CommentText;
		this.Bg=bg;
	}
	
	//Getters
	public int getBgCommentID() {return this.BgCommentID;}
	public String getCommentText() {return this.CommentText;}
	public BloodGlucoses getBg() {return this.Bg;}
	
	//Setters
	public void setCommentText(String newCommentText) { this.CommentText = newCommentText;}
	public void setBgCommentID(int bgCommentID) {this.BgCommentID = bgCommentID;}

}
