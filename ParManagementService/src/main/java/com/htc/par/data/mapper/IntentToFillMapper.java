package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htc.par.to.IntentToFill;

public class IntentToFillMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		final IntentToFill intentTofill = new IntentToFill();
		intentTofill.setIntentToFillind(rs.getBoolean("INTNT_TO_FIL_IND"));
		intentTofill.setIntentSentDate(rs.getDate("INTNT_SENT_DT"));
		return intentTofill;
	}

}
