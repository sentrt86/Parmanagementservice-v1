package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.ParAllocation;

public class ParAllocationMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		final ParAllocation parAllocation = new ParAllocation();
		parAllocation.setParAllocId(rs.getInt("PAR_ALLOC_ID"));
		parAllocation.setParId(rs.getInt("PAR_CD"));
		parAllocation.setRecruiterId(rs.getInt("RECRUIT_CD"));
		parAllocation.setPrescrId(rs.getInt("PRE_SCR_CD"));
		parAllocation.setCandidateId(rs.getInt("CAND_CD"));
		parAllocation.setPreScrdate(rs.getString("PRE_SCR_DT"));
		parAllocation.setPreScrCommnt(rs.getString("PRE_SCR_CMNT_TXT"));
		parAllocation.setSubmitInd(rs.getString("SUBMIT_IND"));
		parAllocation.setSubmitDate(rs.getString("SUBMIT_DT"));
		parAllocation.setOfferRecieved(rs.getString("OFFER_RECVD_IND"));
		parAllocation.setExptdStartDt(rs.getString("EXPTD_START_DT"));
		parAllocation.setActualStartDt(rs.getString("ACTUAL_START_DT"));
		return parAllocation;
		

	}

	

}
