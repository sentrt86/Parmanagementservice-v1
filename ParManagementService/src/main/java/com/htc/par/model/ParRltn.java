package com.htc.par.model;

public class ParRltn {
	
	private int roleCode;
	private int areaCode;
	private int skillcode;
	private int extstaffcode;
	private int locationcode;
	
	public ParRltn() {
		super();
	}

	public ParRltn(int roleCode, int areaCode, int skillcode, int extstaffcode, int locationcode) {
		super();
		this.roleCode = roleCode;
		this.areaCode = areaCode;
		this.skillcode = skillcode;
		this.extstaffcode = extstaffcode;
		this.locationcode = locationcode;
	}

	public int getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public int getSkillcode() {
		return skillcode;
	}

	public void setSkillcode(int skillcode) {
		this.skillcode = skillcode;
	}

	public int getExtstaffcode() {
		return extstaffcode;
	}

	public void setExtstaffcode(int extstaffcode) {
		this.extstaffcode = extstaffcode;
	}

	public int getLocationcode() {
		return locationcode;
	}

	public void setLocationcode(int locationcode) {
		this.locationcode = locationcode;
	}

	@Override
	public String toString() {
		return "ParRltn [roleCode=" + roleCode + ", areaCode=" + areaCode + ", skillcode=" + skillcode
				+ ", extstaffcode=" + extstaffcode + ", locationcode=" + locationcode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + areaCode;
		result = prime * result + extstaffcode;
		result = prime * result + locationcode;
		result = prime * result + roleCode;
		result = prime * result + skillcode;
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
		ParRltn other = (ParRltn) obj;
		if (areaCode != other.areaCode)
			return false;
		if (extstaffcode != other.extstaffcode)
			return false;
		if (locationcode != other.locationcode)
			return false;
		if (roleCode != other.roleCode)
			return false;
		if (skillcode != other.skillcode)
			return false;
		return true;
	}
	
	
	
	
	
	

}
