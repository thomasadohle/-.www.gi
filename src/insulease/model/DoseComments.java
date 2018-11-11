package insulease.model;

/*
 * DoseCommentId INT AUTO_INCREMENT,
    DoseComment TEXT,
    DoseId INT,
 */
public class DoseComments {
	private int DoseCommentId;
	private String DoseComment;
	private InsulinDoses Dose;
	
	/*
	 * Constructor using auto-generated DoseCommentId
	 */
	public DoseComments (int DoseCommentId, String DoseComment, InsulinDoses dose) {
		this.DoseCommentId = DoseCommentId;
		this.DoseComment = DoseComment;
		this.Dose = dose;
	}
	
	/*
	 * Constructor not using auto-generated DoseCommentId
	 */
	public DoseComments (String DoseComment, InsulinDoses dose) {
		this.DoseComment = DoseComment;
		this.Dose= dose;
	}
	
	//Getters
	public int getDoseCommentId() {return this.DoseCommentId;}
	public String getDoseComment() {return this.DoseComment;}
	public InsulinDoses getDose() {return this.Dose;}
	
	//Setters
	public void setDoseCommentsID(int doseCommentsID) {this.DoseCommentId=doseCommentsID;}
	public void setDoseComment(String newDoseComment) {this.DoseComment = newDoseComment;}

}
