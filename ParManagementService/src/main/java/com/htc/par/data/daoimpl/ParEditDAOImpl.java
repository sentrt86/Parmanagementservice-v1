package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.htc.par.data.dao.IParEditDAO;
import com.htc.par.data.dao.IParMiscDAO;
import com.htc.par.data.dao.IParRltnDAO;
import com.htc.par.data.mapper.EmailRecruitersMapper;
import com.htc.par.data.mapper.IntentToFillMapper;
import com.htc.par.data.mapper.ParMasterRowMapper;
import com.htc.par.model.ParMaster;
import com.htc.par.model.ParRltn;
import com.htc.par.to.EmailRecruitersTO;
import com.htc.par.to.IntentToFill;
import com.htc.par.to.ParMasterTO;

@Repository
public class ParEditDAOImpl implements IParEditDAO,IParRltnDAO,IParMiscDAO {
	
	@Autowired JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public ParMaster getParDetails(String parno) {
		ParMaster  parmaster = null;
		System.out.println("PArno"+parno);
		Object[] parms = new Object[] {parno};
		int[] parmtype = new int[] {Types.CHAR};
		System.out.println("call before query");
		parmaster = (ParMaster) jdbcTemplate.queryForObject(ParSqlQueries.getParMasterByParNumQuery,parms,parmtype,new ParMasterRowMapper());
		System.out.println("Call after query");
		
		return parmaster;
		
	}

	@Override
	public boolean updateParDetails(ParMaster parmaster) {
		System.out.println("update par details");
		boolean parMasterUpdated=false;
		System.out.println(parmaster);
		Object[] parms = new Object[] {parmaster.getParDescriptionText(),parmaster.getParReceivedDate(),parmaster.getParStatus(),parmaster.getParNumber()};
		int[] parmstype = new int[] {Types.CHAR,Types.DATE,Types.CHAR,Types.CHAR};
		System.out.println(Arrays.deepToString(parms));
		System.out.println(Arrays.toString(parmstype));
		int updateCount = jdbcTemplate.update(ParSqlQueries.updateParEntry,parms,parmstype);
		System.out.println("updateCount"+updateCount);
		if(updateCount > 0)
		{
			parMasterUpdated =true;
		}
		return parMasterUpdated;
	}

	@Override
	public boolean deleteParDetails(String parno) {
		System.out.println("Delete DAO call"+parno);
		boolean parDetailsdeleted =false;
		Object[] parms = new Object[] {parno};
		int[] parmsType = new int[] {Types.CHAR};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deleteParEntry,parms,parmsType);
		if (deleteCount > 0)
		{
			parDetailsdeleted =true;
		}
		return parDetailsdeleted;
	}

	@Override
	public int getparId(String parno) {
		int parId=0;
		Object[] parms = new Object[] {parno};
		int[] parmstype = new int[] {Types.CHAR};
		System.out.println("GetparID method");
		parId = (int)jdbcTemplate.queryForObject(ParSqlQueries.getParIdforParNo, parms, parmstype, Integer.class);
		return parId;
	}

	@Override
	public boolean updateParRltn(ParRltn parRltn,int parId) {
		System.out.println("update par relation");
		System.out.println(parRltn);
		Boolean parMasterRltnUpdated = false;
		Object[] parms = new Object[] {parRltn.getRoleCode(),parRltn.getAreaCode(),parRltn.getSkillcode(),parRltn.getExtstaffcode(),parRltn.getLocationcode(),parId};
		int[] parmsType = new int[] {Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER};
		int updateCount = jdbcTemplate.update(ParSqlQueries.updateParRltnQuery,parms,parmsType);
		if(updateCount > 0) {
			parMasterRltnUpdated = true;
		}		
		return parMasterRltnUpdated;
	}

	@Override
	public boolean deleteParRltn(int parId) {
		boolean parRltndeleted =false;
		Object[] parms = new Object[] {parId};
		int[] parmsType = new int[] {Types.INTEGER};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deleteParRltnforParId,parms,parmsType);
		if (deleteCount > 0)
		{
			parRltndeleted =true;
		}
		return parRltndeleted;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IntentToFill getIntentTofillforParId(int parId) {
		System.out.println("PArno"+parId);
		Object[] parms = new Object[] {parId};
		int[] parmtype = new int[] {Types.INTEGER};
		 
		return (IntentToFill) jdbcTemplate.queryForObject(ParSqlQueries.getIntentDetailsforParId,parms,parmtype, new IntentToFillMapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public EmailRecruitersTO getEmailRecruitersforParId(int parId) {
		Object[] parms = new Object[] {parId};
		int[] parmtype = new int[] {Types.INTEGER};
		return (EmailRecruitersTO) jdbcTemplate.queryForObject(ParSqlQueries.getEmailRecruitersforParId,parms,parmtype, new EmailRecruitersMapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public ParRltn getParRltn(int parId) {
		Object[] parms = new Object[] {parId};
		int[] parmtype = new int[] {Types.INTEGER};
		return (ParRltn) jdbcTemplate.queryForObject(ParSqlQueries.getParRltnQuery,parms,parmtype, new  ParRltnMapper());
	}
	
}
	
	


