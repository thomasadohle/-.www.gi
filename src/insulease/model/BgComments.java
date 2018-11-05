package insulease.model;

/*
 * BgCommentID INT AUTO_INCREMENT,
    PtID VARCHAR(255),
    CommentText TEXT,
    BgID INT,
 */
public class BgComments {
	private int BgCommentID;
	private String PtID;
	private String CommentText;
	private int BgID;
	
	/*
	 * Constructor using auto-generated BgCommentId
	 */
	public BgComments (int BgCommentID, String PtID, String CommentText, int BgID) {
		this.BgCommentID=BgCommentID;
		this.PtID=PtID;
		this.CommentText=CommentText;
		this.BgID=BgID;
	}
	
	/*
	 * Constructor not using auto-generated BgCommentId
	 */
	public BgComments (String PtID, String CommentText, int BgID) {
		this.PtID=PtID;
		this.CommentText=CommentText;
		this.BgID=BgID;
	}
	
	//Getters
	public int getBgCommentID() {return this.BgCommentID;}
	public String getPtID() {return this.PtID;}
	public String getCommentText() {return this.CommentText;}
	public int getBgID() {return this.BgID;}
	
	//Setters
	public void setCommentText(String newCommentText) { this.CommentText = newCommentText;}

}
