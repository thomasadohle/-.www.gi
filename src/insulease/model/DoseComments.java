package insulease.model;

/*
 * DoseCommentId INT AUTO_INCREMENT,
    DoseComment TEXT,
    DoseId INT,
 */
public class DoseComments {
	private int DoseCommentId;
	private String DoseComment;
	private int DoseId;
	
	/*
	 * Constructor using auto-generated DoseCommentId
	 */
	public DoseComments (int DoseCommentId, String DoseComment, int DoseId) {
		this.DoseCommentId = DoseCommentId;
		this.DoseComment = DoseComment;
		this.DoseId = DoseId;
	}
	
	/*
	 * Constructor not using auto-generated DoseCommentId
	 */
	public DoseComments (String DoseComment, int DoseId) {
		this.DoseComment = DoseComment;
		this.DoseId = DoseId;
	}
	
	//Getters
	public int getDoseCommentId() {return this.DoseCommentId;}
	public String getDoseComment() {return this.DoseComment;}
	public int getDoseId() {return this.DoseId;}
	
	//Setters
	public void setDoseComment(String newDoseComment) {this.DoseComment = newDoseComment;}

}
