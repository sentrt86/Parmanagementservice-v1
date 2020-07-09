package com.htc.par.data.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.ParRltn;

public class ParRltnMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		final ParRltn parRltn = new ParRltn();
		parRltn.setRoleCode(rs.getInt("ROLE_CD"));
		parRltn.setLocationcode(rs.getInt("LOC_CD"));
		parRltn.setSkillcode(rs.getInt("SKILL_CD"));
		parRltn.setAreaCode(rs.getInt("AREA_CD"));
		parRltn.setExtstaffcode(rs.getInt("EXT_STAFF_CD"));
		return parRltn;
	}

}
