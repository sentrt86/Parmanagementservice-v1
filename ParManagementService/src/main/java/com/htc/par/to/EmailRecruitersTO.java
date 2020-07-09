package com.htc.par.to;

public class EmailRecruitersTO {
	private int parId;
	private String parComment;
	private  Boolean emailSent;
	
	public EmailRecruitersTO() {
		super();
	}

	public EmailRecruitersTO(int parId, String parComment, Boolean emailSent) {
		super();
		this.parId = parId;
		this.parComment = parComment;
		this.emailSent = emailSent;
	}

	public int getParId() {
		return parId;
	}

	public void setParId(int parId) {
		this.parId = parId;
	}

	public String getParComment() {
		return parComment;
	}

	public void setParComment(String parComment) {
		this.parComment = parComment;
	}

	public Boolean getEmailSent() {
		return emailSent;
	}

	public void setEmailSent(Boolean emailSent) {
		this.emailSent = emailSent;
	}

	@Override
	public String toString() {
		return "EmailRecruitersTO [parId=" + parId + ", parComment=" + parComment + ", emailSent=" + emailSent + "]";
	}
	
	
	
	

}
