package com.htc.par.to;

import java.sql.Date;

public class IntentToFill {
	
	private int parId;
	private Boolean intentToFillind;
	private Date intentSentDate;
	
	public IntentToFill() {
		super();
	}

	public IntentToFill(int parId, Boolean intentToFillind, Date intentSentDate) {
		super();
		this.parId = parId;
		this.intentToFillind = intentToFillind;
		this.intentSentDate = intentSentDate;
	}

	public int getParId() {
		return parId;
	}

	public void setParId(int parId) {
		this.parId = parId;
	}

	public Boolean getIntentToFillind() {
		return intentToFillind;
	}

	public void setIntentToFillind(Boolean intentToFillind) {
		this.intentToFillind = intentToFillind;
	}

	public Date getIntentSentDate() {
		return intentSentDate;
	}

	public void setIntentSentDate(Date intentSentDate) {
		this.intentSentDate = intentSentDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intentSentDate == null) ? 0 : intentSentDate.hashCode());
		result = prime * result + ((intentToFillind == null) ? 0 : intentToFillind.hashCode());
		result = prime * result + parId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntentToFill other = (IntentToFill) obj;
		if (intentSentDate == null) {
			if (other.intentSentDate != null)
				return false;
		} else if (!intentSentDate.equals(other.intentSentDate))
			return false;
		if (intentToFillind == null) {
			if (other.intentToFillind != null)
				return false;
		} else if (!intentToFillind.equals(other.intentToFillind))
			return false;
		if (parId != other.parId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IntentToFill [parId=" + parId + ", intentToFillind=" + intentToFillind + ", intentSentDate="
				+ intentSentDate + "]";
	}
	
	
	
	

}
