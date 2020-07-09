package com.htc.par.to;

import java.sql.Date;

import com.htc.par.model.Area;
import com.htc.par.model.ExternalStaff;
import com.htc.par.model.Location;
import com.htc.par.model.ParRole;
import com.htc.par.model.Skill;

public class ParMasterTO {
	
	private int parId;
	private String parNumber;
	private String parDescriptionText;
	private String parReceivedDate;
	private String parStatus;
	private String intentToFill;
	private String  intentSentDate;
	private String emailSent;
	private String  parComment;
	private Area area;
	private Skill skill;
	private ParRole parRole;
	private ExternalStaff externalStaff;
	private Location location;
	
	public ParMasterTO() {
		super();
	}

	public ParMasterTO(int parId,String parNumber, String parDescriptionText, String parReceivedDate, String parStatus,
			String intentToFill, String intentSentDate, String emailSent, String parComment, Area area, Skill skill,
			ParRole parRole, ExternalStaff externalStaff, Location location) {
		super();
		this.parId= parId;
		this.parNumber = parNumber;
		this.parDescriptionText = parDescriptionText;
		this.parReceivedDate = parReceivedDate;
		this.parStatus = parStatus;
		this.intentToFill = intentToFill;
		this.intentSentDate = intentSentDate;
		this.emailSent = emailSent;
		this.parComment = parComment;
		this.area = area;
		this.skill = skill;
		this.parRole = parRole;
		this.externalStaff = externalStaff;
		this.location = location;
	}

	public String getParNumber() {
		return parNumber;
	}

	public void setParNumber(String parNumber) {
		this.parNumber = parNumber;
	}

	public String getParDescriptionText() {
		return parDescriptionText;
	}

	public void setParDescriptionText(String parDescriptionText) {
		this.parDescriptionText = parDescriptionText;
	}

	public String getParReceivedDate() {
		return parReceivedDate;
	}

	public void setParReceivedDate(String parReceivedDate) {
		this.parReceivedDate = parReceivedDate;
	}

	public String getParStatus() {
		return parStatus;
	}

	public void setParStatus(String parStatus) {
		this.parStatus = parStatus;
	}

	public String getIntentToFill() {
		return intentToFill;
	}

	public void setIntentToFill(String intentToFill) {
		this.intentToFill = intentToFill;
	}

	public String getIntentSentDate() {
		return intentSentDate;
	}

	public void setIntentSentDate(String date) {
		this.intentSentDate = date;
	}

	public String getEmailSent() {
		return emailSent;
	}

	public void setEmailSent(String emailSent) {
		this.emailSent = emailSent;
	}

	public String getParComment() {
		return parComment;
	}

	public void setParComment(String parComment) {
		this.parComment = parComment;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public ParRole getParRole() {
		return parRole;
	}

	public void setParRole(ParRole parRole) {
		this.parRole = parRole;
	}

	public ExternalStaff getExternalStaff() {
		return externalStaff;
	}

	public void setExternalStaff(ExternalStaff externalStaff) {
		this.externalStaff = externalStaff;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	

	public int getParId() {
		return parId;
	}

	public void setParId(int parId) {
		this.parId = parId;
	}

	@Override
	public String toString() {
		return "ParMasterTO [parId=" + parId + ", parNumber=" + parNumber + ", parDescriptionText=" + parDescriptionText
				+ ", parReceivedDate=" + parReceivedDate + ", parStatus=" + parStatus + ", intentToFill=" + intentToFill
				+ ", intentSentDate=" + intentSentDate + ", emailSent=" + emailSent + ", parComment=" + parComment
				+ ", area=" + area + ", skill=" + skill + ", parRole=" + parRole + ", externalStaff=" + externalStaff
				+ ", location=" + location + "]";
	}
	
	
	
	

}
