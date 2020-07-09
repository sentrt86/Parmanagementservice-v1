package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htc.par.to.EmailRecruitersTO;

public class EmailRecruitersMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		final EmailRecruitersTO emailRecruitersTo = new EmailRecruitersTO();
		emailRecruitersTo.setEmailSent(rs.getBoolean("EMAIL_SENT"));
		emailRecruitersTo.setParComment(rs.getString("PAR_CMMNT"));
		return emailRecruitersTo;
	}

}
